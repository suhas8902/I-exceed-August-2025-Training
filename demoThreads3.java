class sample3 extends Thread
{
	Thread t = new Thread(this);
	//sample3()
	//{
	//	new Thread(this).start();
	//}
	public void run()
	{
		try
		{
		for(var i=0;i<10;i++)
		{
			System.out.println(i);
			t.sleep(1000);
		}
		}catch(Exception Excep){}
	}
}

class demoThreads3
{
	public static void main(String[] args)
	{
		sample3 obj = new sample3();
		obj.start();
	}
}		