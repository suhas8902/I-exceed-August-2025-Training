class sample extends Thread{
	sample()
	{
		Thread t = new Thread(this).start();
	}
	public void run()
	{
		display();
	}
	public void display()
	{
		System.out.println("Learning threads");
	}
}

class threadsDemo
{
	public static void main(String[] args)
	{
		sample obj = new sample();
		//obj.start();
	}
}
		