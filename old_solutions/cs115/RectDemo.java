// we need to import this package because it contains the definition of Rectangle
import java.awt.*;

public class RectDemo
{
	public static void main(String args[])
	{
		// when you create a variable of type Rectangle, it points to nothing
		// (even if you don't explicitly set it to null as I do here)
		Rectangle rect = null;
		
		// accessing a field from a null object would cause a null pointer exception
		// rect.width = 50; 
		
		System.out.println (rect == null);   // prints true
		
		// create a new rectangle object and make rect point to it
		rect = new Rectangle ();
		
		// this is ok now
		rect.width = 50;
		
		// we can create a Rectangle and give it values at the same time
		int x = 10;  int y = 20;  int width = 300;  int height = 200;
		Rectangle bbox = new Rectangle (x, y, width, height);
		
		// we can copy data from one object to the other
		rect.width = bbox.width;
		
		// or we can make rect point to the same object as bbox
		rect = bbox;
		
		// now rect and bbox are aliases for the same object, and the
		// object formerly known as rect ceases to exist, because no one
		// is pointing to it.
		
		// if we modify one of the fields of rect, bbox changes too
		rect.width = 712;
		System.out.println (bbox.width);      // prints 712
		
		// when we pass primitive types as parameters, the method gets a copy
		// when we pass Object types as parameters, the method gets a pointer to the
		// original object, and any changes it makes affect the caller
		int i = 10;
		mangle (i, rect);
		System.out.println (i);              // prints 10
		System.out.println (rect.width);     // prints 307
		
	}
	public static void mangle (int x, Rectangle r)
	{
		x = 36473;
		r.width = 307;
	}
}
