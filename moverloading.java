class sample{
	sample()
	{
		
	}
	public void display()
	{
		System.out.println("In the super class");
	}
}

class sample1 extends sample{
	sample1()
	{

	}
	public void display()
	{
		System.out.println("In derived class");
	}
}

class moverloading{
	public static void main(String[] Args)
	{
		//sample ref 
		sample objs = new sample();
		sample1 objd = new sample1();
		objs.display();
		//ref=objd;
		//ref.display() this way u dont need to disturb the code and that the idea behind it. this way the result is achieved at runtime instead of compile time
		objd.display(); // you can either directly assign this way or create a ref var of sample type and assingn the instance var to it 
	}
}