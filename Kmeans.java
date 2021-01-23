import java.util.*;
public class Kmeans
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
		double d[]= new double[100];
		double m[]= new double[100];
		double k1[]=new double[100];
		double k2[]=new double[100];
		double k1prev[]=new double[100];
		double k2prev[]=new double[100];
		int n,i,j,l,t1,t2;
		double m1,m2,d1,d2,total1=0,total2=0;
		System.out.println("Assume the number of clusters is: 2");
		System.out.println("Enter the number of elements in data set: ");
		n=sc.nextInt();
		System.out.println("Enter the elements in data set: ");
		for(i=0;i<n;i++)
		{
			d[i]=sc.nextDouble();
		}
		m1=d[0];
		m2=d[1];
		for(i=0,j=0,l=0;i<n;i++)
		{
			d1=Math.abs(d[i]-m1);
			d2=Math.abs(d[i]-m2);
			if(d1<d2 || d1==d2)
			{
				k1[j]=d[i];
				j++;
			}
			else
			{
				k2[l]=d[i];
				l++;
			}
		}
		for(i=0;i<n;i++)
		{
			if(k1[i]!=k1prev[i])
			{
				t1=0;
				break;
			}
			else
				t1=1;
		}
		for(i=0;i<n;i++)
		{
			if(k2[i]!=k2prev[i])
			{
				t2=0;
				break;
			}
			else
				t2=1;
		}
		for(i=0;i<n;i++)
		{
			k1prev[i]=k1[i];
			k2prev[i]=k2[i];
			total1+=k1[i];
			total2+=k2[i];
		}
		m1=total1/n;
		m2=total2/n;
		
	}
}