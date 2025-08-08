class Student
{
	private String name;
	private int rollNo;
	Student(String name, int rollNo)
	{
		this.name=name;
		this.rollNo=rollNo;
	}
	public void getDetails()
	{
		System.out.println("First student name is "+name);
		System.out.println("Student usn is "+rollNo);
	}
	public void setName(String n)
	{
		this.name=n;
	}
	public String getName()
	{
		return name;
	}
	public void setRollNo(int roll)
	{
		this.rollNo=roll;
	}
	public int getRollNo()
	{
		return rollNo;
	}
}

class GandS
{
	public static void main(String[] args)
	{
		Student obj = new Student("Suhas",210);
		obj.getDetails();
		obj.setName("Sai");
		System.out.println(obj.getName());
		obj.setName("Ram");
		System.out.println(obj.getName());
	}
}
		
		