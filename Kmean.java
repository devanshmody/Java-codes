import java.util.*;
import java.math.*;
class Kmean
{
	public static void main(String args[])
	{
		int n,i,j,k;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of points");
		n=sc.nextInt();
		double a[][]=new double[n][2];
		for(i=0;i<n;i++)
		{
			for(j=0;j<2;j++)
			{
				System.out.println("Enter the value for"+i+","+j+":");
				a[i][j]=sc.nextDouble();
			}	
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<2;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		Double x[][]=new Double[n][n];
		for(i=0;i<n;i++)
		{
			for(k=0;k<n;k++)
			{
				x[i][k]=Math.sqrt(Math.pow((a[i][0]-a[k][0]),2)+Math.pow((a[i][1]-a[k][1]),2));
			}
		}
		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
				System.out.print(x[i][j]+" \t\t\t\t\t");
			}
			System.out.println();
		}
				
	}
}