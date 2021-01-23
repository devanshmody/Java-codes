import java.util.*;
class eglo
{
	public static void main(String args[])
	{
		double x[]=new double[10];
		double y[]=new double[10];
		double d[][]=new double[10][10];
		double x1[]=new double[10];
		double y1[]=new double[10];
		Double cls[]=new Double[10];
		double min,max;
		int i,j,n,a,b,count=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter no of points:");
		n=sc.nextInt();
		System.out.println("enter x co-ordinate:");
		for(i=0;i<n;i++)
		{
			x[i]=sc.nextDouble();
		}
		System.out.println("enter y co-ordinate:");
		for(i=0;i<n;i++)
		{
			y[i]=sc.nextDouble();
		}
		System.out.println("x co-ordinates are");
		for(i=0;i<n;i++)
		{
		   System.out.println(x[i]);
		}
		System.out.println("y co-ordinates are");
		for(i=0;i<n;i++)
		{
		   System.out.println(y[i]);
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j)
				{
					d[i][j]=0.0;
				}
				else
				{
					x1[i]=Math.pow((x[i]-x[j]),2);
					y1[i]=Math.pow((y[i]-y[j]),2);
					d[i][j]=Math.sqrt(x1[i]+y1[i]);
				}
			}
		}
		System.out.println("the distances are:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(d[i][j]+" ");
			}
			System.out.println("\n");
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(i==j)
				{
					d[i][j]=99.99;
				}
			}
		}
		min=d[0][0];
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				if(d[i][j]<min)
				{
					min=d[i][j];
				}
			}
		}
		count++;
		System.out.println("The minimum value is:"+min);
	}
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			for(k=0;k<count;k++)
			if(d[i][j]==min)
			{
				cls[k]=i;
				cls[k++]=j;
			}
		}
	}
	for(i=0;i<count;i++)
	{
		System.out.println(cls[i]);
	}
}