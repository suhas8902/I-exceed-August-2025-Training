import java.lang.reflect.Method;
class ex
{
	private static String name = "Suhas";
	static void display()
	{
		System.out.println("lets see");
		System.out.println(name);
	}
}

class javaAdv
{
	public static void main(String[] args)throws Exception
	{
		Class c = Class.forName("ex");
		Object o = c.newInstance();
		Method m1 = c.getDeclaredMethod("display");
		m1.setAccessible(true);
		m1.invoke(o);
	}
}