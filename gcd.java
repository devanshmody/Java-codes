import java.io.*;
class gcd
{
	public static void main(String args[])throws Exception
	{
	int a,b,c,d,r,g;
	DataInputStream din=new DataInputStream(System.in);
	System.out.println("enter numbere");
	a=Integer.parseInt(din.readLine());
	System.out.println("value of a="+a);
	c=a;
	b=Integer.parseInt(din.readLine());
	System.out.println("value of b="+b);
	d=b;
	while(b!=0)
	{
		r=a%b;
		a=d;
		b=r;
	}

	System.out.println("gcd="+a);
	
	
	}
}