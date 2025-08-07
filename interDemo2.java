interface i1{
	public void display();
	default void display1()
	{
		System.out.println("Inside i1");
	}
}

interface i2{//interface i2 extends i1{
	default void display1()
	{
		System.out.println("Inside i2");
	}
}

class main implements i2,i1//class main implements i2
{
	@Override
	public void display()
	{
		System.out.println("display");
	}

	public void display1()
	{
		System.out.println("Hello");
		i2.super.display1();
		i1.super.display1();
	}
}

class interDemo2
{
	public static void main(String[] args)
	{
		main obj = new main();
		obj.display();
		obj.display1();
	}
}
