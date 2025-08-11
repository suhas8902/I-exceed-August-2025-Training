class sample4 extends Thread
{
	Thread t = new Thread(this);
	public void run()
	{
		try
		{
			for(var i=0;i<10;i++)
			{
				System.out.println(i);
				t.sleep(1000);
			}
		}catch(Exception e){}
	}
}

class demoThreads4
{
	public static void main(String[] args) throws InterruptedException
	{
		sample4 obj = new sample4();
		obj.start();
		for(var i=0;i<10;i++)
		{
			System.out.println(i);
			Thread.currentThread().sleep(1000);
		}
	}
}