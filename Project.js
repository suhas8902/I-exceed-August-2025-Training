process.env.NODE_TLS_REJECT_UNAUTHORIZED = "0";
 
const xlsx = require("xlsx");
const readline = require("readline");
const moment = require("moment-timezone");
const ctt = require("country-timezone");
const fetch = require("node-fetch");
const fs = require("fs");
 
const API_KEY = "0cf44d8fa6901f6eb0f686d6";
 
// Unhandled error logging
process.on('unhandledRejection', (err) => {
  console.error("❌ Unhandled Rejection:", err.message);
});
 
// Setup readline
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});
 
function ask(question) {
  return new Promise(resolve => rl.question(question, answer => resolve(answer)));
}
 
// Helper function to clean object keys
function cleanObjectKeys(obj) {
  const cleaned = {};
  for (const key in obj) {
    cleaned[key.trim()] = obj[key];
  }
  return cleaned;
}
 
// Function to convert salaries using exchange rates + add local times
async function convertSalaries(employees, targetCurrency) {
  try {
    const response = await fetch(`https://v6.exchangerate-api.com/v6/${API_KEY}/latest/${targetCurrency}`);
    const parsed = await response.json();
 
    if (parsed.result !== "success") {
      throw new Error(parsed["error-type"] || "API error");
    }
 
    const rates = parsed.conversion_rates;
    let results = [];
 
    for (const emp of employees) {
      // Basic validation
      if (!emp.Currency || !emp.Salary || !emp.Country) {
        console.warn(`⚠️ Skipping incomplete entry: ${JSON.stringify(emp)}`);
        continue;
      }
 
      const salary = parseFloat(emp.Salary);
      if (isNaN(salary)) {
        console.warn(`⚠️ Invalid salary: ${emp.Salary}`);
        continue;
      }
 
      let converted;
      if (emp.Currency === targetCurrency) {
        converted = salary;
      } else if (rates[emp.Currency]) {
        converted = salary / rates[emp.Currency];
      } else {
        console.warn(`⚠️ No exchange rate for currency: ${emp.Currency}`);
        continue;
      }
 
      // Get time zone by country using country-timezone
      const timezones = ctt.getTimezones(emp.Country);
      const timezone = timezones && timezones.length > 0 ? timezones[0] : "UTC";
      const localTime = moment().tz(timezone).format("YYYY-MM-DD HH:mm:ss");
 
      results.push({
        ...emp,
        [`Salary in ${targetCurrency}`]: converted.toFixed(2),
        Time: localTime
      });
    }
 
    return results;
  } catch (err) {
    throw err;
  }
}
 
// Main function
async function run() {
  try {
    // Step 1: Load Excel file
    const fileName = "apiPractice.xlsx";
    if (!fs.existsSync(fileName)) {
      throw new Error(`File "${fileName}" not found in current directory.`);
    }
 
    const workbook = xlsx.readFile(fileName);
    const sheetName = workbook.SheetNames[0];
    const sheet = workbook.Sheets[sheetName];
    const rawData = xlsx.utils.sheet_to_json(sheet);
    const employees = rawData.map(cleanObjectKeys);
 
    if (employees.length === 0) {
      throw new Error("Excel sheet is empty.");
    }
 
    // Step 2: Ask user for target currency
    const targetCurrency = (await ask("Enter target currency (e.g., INR, USD, EUR): ")).toUpperCase();
    rl.close();
 
    // Step 3: Convert salaries + add local times
    const results = await convertSalaries(employees, targetCurrency);
 
    // Step 4: Save results to new Excel + JSON
    const newSheet = xlsx.utils.json_to_sheet(results);
    const newWorkbook = xlsx.utils.book_new();
    xlsx.utils.book_append_sheet(newWorkbook, newSheet, "Results");
 
    const filenameBase = `apiPractice_converted`;
    xlsx.writeFile(newWorkbook, `${filenameBase}.xlsx`);
    fs.writeFileSync(`${filenameBase}.json`, JSON.stringify(results, null, 2));
 
    console.log(`✅ Results saved to:`);
    console.log(`📄 ${filenameBase}.xlsx`);
    console.log(`📄 ${filenameBase}.json`);
  } catch (err) {
    console.error("❌ Error:", err.message);
  }
}
 
// Run program
run();