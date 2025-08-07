interface i1{
	public void display();
	default void display1()
	{
		System.out.println("Inside i1");
	}
	static void dis()
	{
		System.out.println("Inside static block");
	}
}

interface i2{
	default void display1()
	{
		System.out.println("Inside i2");
	}
}

class mainHere implements i1,i2{
	@Override
	public void display()
	{
		System.out.println("Hello");
	}
	public void display1()
	{
		System.out.println("idk");
		i1.super.display1();
		i2.super.display1();
	}
}

class interDemo{
	public static void main(String[] args)
	{
		mainHere obj = new mainHere();
		obj.display();
		obj.display1();
		i1.dis();
	}
}
	