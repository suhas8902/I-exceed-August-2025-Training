class Family{

	String motherName;
	String fatherName;
	Student s1;
	Address adr;

	Family(String motherName,String fatherName, Address adr, Student s1)
	{
		this.motherName = motherName;
		this.fatherName = fatherName;
		this.adr = adr;
		this.s1 = s1;
	}

	public void displayDetails()
	{
		System.out.println("Mother Name = "+ motherName);
		System.out.println("Father Name = "+ fatherName);
		adr.displayAddress();
		s1.displayStudent();
	}
}

class Main{

	public static void main(String[] args)
	{
		Address a1 = new Address("Bang",560008);
		Student s1 = new Student(33,"Suhas",a1);
		Family f1 = new Family("xx","xy",a1,s1);
		f1.displayDetails();
	}
}