class car
{
	final private engine eng;
	String name;
	String model;
	car(String name, String model)
	{
		eng = new engine("Finally understood");
		this.name=name;
		this.model=model;
	}
	public void displayDetails()
	{
		System.out.println("The name is "+name);
		System.out.println("The model is "+model);
		eng.disp1();
	}
}

class engine
{
	String det;
	engine(String det)
	{
		this.det = det;
	}
	public void disp1()
	{
		System.out.println("Engine dets "+det);
	}
}
class comp
{
	public static void main(String[] args)
	{
		car obj = new car("Suzuki","Nexa");
		obj.displayDetails();
	}
}
		