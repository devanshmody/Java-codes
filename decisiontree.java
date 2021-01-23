import java.util.*;
class decisiontree
{
	public static void main(String args[])
	{
		String age[]=new String[3];
		String q[]=new String[3];
		int in[]=new int[5];
		String d[]=new String[2];
		int i,n,j;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of entries:");
		n=sc.nextInt();
		System.out.println("enter their ages:");
		for(i=0;i<n;i++)
		{
			age[i]=sc.next();
		}
		System.out.println("enter their incomes :");
		for(i=0;i<n;i++)
		{
			in[i]=sc.nextInt();
		}
		System.out.println("check whether student or no:");
		for(i=0;i<n;i++)
		{
			q[i]=sc.next();
		}
		
	}
}