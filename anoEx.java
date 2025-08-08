interface animal
{
	public void sound();
}

class anoEx
{
	public static void main(String[] args)
	{
		animal a = new animal()
		{
			@Override
			public void sound()
			{
				System.out.println("Roar");
			}
		};
		a.sound();
	}
}