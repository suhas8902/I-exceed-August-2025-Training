class sample2 extends Thread
{
	Thread t = new Thread(this);
	sample2()
	{
		new Thread(this).start();
	}
	public void run()
	{
		t.setName("i-exceed");
		System.out.println("The info is \t" +t.getName());
	}
}

class demoThread2
{
	public static void main(String[] args)
	{
		System.out.println("The name in main method is \t"+ Thread.currentThread().getName());
		sample2 obj = new sample2();
	}
}