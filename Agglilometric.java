import java.util.*;
class Agglilometric
{
	public static void main(String args[])	
	{
		int n,i,j,a,b;
		double x[],y[],dist[][],min=1.0,dist1[][];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the no of points");
		 n=sc.nextInt();
		x=new double[n];
		y=new double[n];
		System.out.println("Enter the xco-ordinate");	
		for(i=0;i<n;i++)
		{
			x[i]=sc.nextDouble();
		}
		System.out.println("Enter the yco-ordinate");
		for(i=0;i<n;i++)
		{
			y[i]=sc.nextDouble();
		}
	dist=new double[n][n];
		dist1=new double[n][n];
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			dist[i][j]=Math.sqrt(Math.pow((x[i]-x[j]),2)+Math.pow((y[i]-y[j]),2));
			
		}
	}

		for(i=0;i<n;i++)
		{
			for(j=0;j<n;j++)
			{
			System.out.print(dist[i][j]+"\t\t\t");
		}
		System.out.println();
	}
	for(i=0;i<n;i++)	{
		for(j=0;j<n;j++)
		{
			if(dist[i][j]!=0 && dist[i][j]<min)
			{
				
				min=dist[i][j];
			}
		}
	}
	System.out.println("Min dist is "+min);
	for(i=0;i<n;i++){
		for(j=0;j<n;j++)
		{
			if(dist[i][j]==min)
			{
					a=i;
					b=j;
					System.out.println("points are p"+(i+1)+" p"+(j+1));
					break;
			}
		}
		
	}
  }
}