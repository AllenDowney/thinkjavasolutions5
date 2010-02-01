public class Loop
{
	public static void main(String args[])
	{
		float total = (float) 0.0;
		for (int i=1; i<=10000; i++) {
			total += 1.0 / i;
		}
		System.out.println (total);
		
		total = (float) 0.0;
		for (int i=10000; i>= 1; i--) {
			total += 1.0 / i;
		}
		System.out.println (total);
	}

}


