public class Stats
{
	public static void main(String args[])
	{
		int n = 1000;
		double[] doubarr = new double[n];
		int[] intarr = new int[n];
		
		randomizeIntArray (intarr);
		randomizeDoubleArray (doubarr);
		
		int total = sum(intarr);
		System.out.println (total);
		
		System.out.println (frequency(intarr, 17));

		// it's ok to have a variable with the same name as a method, although
		// it is sometimes frowned upon
		int max = max(intarr);
		System.out.println (max);

		int index = find(intarr, 17);
		System.out.println (index);

		// the second time we use index, we don't declare it again; we just
		// assign a new value to it
		index = find2(intarr, 17);
		System.out.println (index);
		
		System.out.println (inInterval (doubarr, 0.25, 0.75));
	}

	public static void randomizeDoubleArray (double[] a)
	{
		// choose a random double between 0.0 and 1.0 (including 0.0 but not 1.0)
		for (int i = 0; i<a.length; i++) {
			a[i] = Math.random ();
		}
	}
	
	public static void randomizeIntArray (int[] a)
	{
		// choose a random integer between 0 and 99
		for (int i = 0; i<a.length; i++) {
			a[i] = (int) (Math.random () * 100);
		}
	}
	
	public static int sum (int[] a)
	{
		int total = 0;
		for (int i = 0; i<a.length; i++) {
			total += a[i];
		}
		return total;
	}
	
	public static int frequency (int[] a, int p)
	{
		int count = 0;
		for (int i = 0; i<a.length; i++) {
			if (a[i] == p) count++;
		}
		return count;
	}
	
	public static int max (int[] a)
	{
		// we have to start with an initial value that is lower that the
		// largest value in the array.  In this case we know that the array
		// elements are between 0 and 99, so -1 is fine for a starting value
		int max = -1;
		for (int i = 0; i<a.length; i++) {
			if (a[i] > max) max = a[i];
		}
		return max;
	}
	
	public static int find (int[] a, int p)
	{
		for (int i = 0; i<a.length; i++) {
			if (a[i] == p) return i;
		}
		return -1;
	}		

	public static int find2 (int[] a, int p)
	{
		// in this case we have to declare i outside the loop because we need
		// to use it outside the loop
		int i;
		for (i=0; i<a.length; i++) {
			if (a[i] == p) break;
		}
		// if we got all the way through the array and didn't find it, return -1
		// else return the value of i
		if (i == a.length) return -1;
		else return i;
	}	

	public static int inInterval 
		(double[] a, double low, double high)
	{
		int count = 0;
		for (int i=0; i<a.length; i++) {
			if (a[i] >= low && a[i] <= high) count++;
		}
		return count;
	}
}