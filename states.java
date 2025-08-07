class Karnataka
{
	String cm_name;
	int area;
	//Karnataka(String cm_name, int area)
	//{
	//	this.cm_name = cm_name;
	//	this.area = area;
	//}
	class Bengaluru
	{
		String district;
		int population;
		Bengaluru(String district, int population, String cm_name, int area)
		{
			this.district = district;
			this.population = population;
			Karnataka.this.cm_name = cm_name;
			Karnataka.this.area = area;
		}
		public void displayDetails()
		{
			System.out.println("The name of the district is "+district);
			System.out.println("The population is "+population);
			System.out.println("The CM name is "+cm_name);
			System.out.println("The area is "+area);
		}
	}
}

class states
{
	public static void main(String[] args)
	{
		Karnataka obj1 = new Karnataka();
		Karnataka.Bengaluru obj = obj1.new Bengaluru("Bengaluru",10000000,"Siddu",100000000);
		//Karnataka.Bengaluru obj = new Karnataka().Bengaluru("Bengaluru",10000000,"Siddu",100000000); ig works only when u wanna give values for the inner class alone.
		obj.displayDetails();
	}
}