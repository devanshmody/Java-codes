import java.io.*;
class largest
{
	public static void main(String args[])throws Exception
	{
	int a,b,c,max;
	DataInputStream din=new DataInputStream(System.in);
	System.out.println("enter numbere");
	a=Integer.parseInt(din.readLine());
	System.out.println("value="+a);
	b=Integer.parseInt(din.readLine());
	System.out.println("value="+b);
	c=Integer.parseInt(din.readLine());
	System.out.println("value="+c);
	if(a>b)
	{
		if(a>c)
		{
			max=a;
		}
		else
		{
			max=c;
		}
	}
	else
	{
		if(b>c)
		{
			max=b;
		}
		else
		{
			max=c;
		}
	}
		System.out.println("largest number="+max);

	}
}