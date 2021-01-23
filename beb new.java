import java.util.*;
import java.lang.Math;
class binary
{
	public static void main(String args[])
	{
		int n,nc,dis=0,i,j,c=0,c1=0;
		int n1[]=new int[10]; 
		int flag[]=new int[10];
		int a[]=new int[10];   
		int b[]=new int[10];
		Scanner sc=new Scanner(System.in);
		//System.out.print("Enter no. of STATION:-\t");
		//nc=sc.nextInt();
     	System.out.print("Enter no. of collision:-\t");
     	n=sc.nextInt();
     	dis+=Math.pow(2,n)-1;
        for(i=0;i<dis;i++)
     	System.out.print(i+"\t");
     	System.out.print("\n");
     	for(i=0;i<dis;i++)
     	{
        	System.out.print("Enter the Random no. which display above for STATION"+(i+1)+":-\t");
     	    n1[i]=sc.nextInt();
     	}
     	for(i=0;i<dis;i++)
     		flag[i]=0;
     	for(i=0;i<dis;i++)
        for(j=i+1;j<dis;j++)
          if(n1[i]==n1[j])
          {
          	flag[i]=1;
          	a[i]=i+1;
           	b[i]=j+1;
           	c++;
           }
           for(i=0;i<c;i++)
           if(flag[i]==1)
     	    System.out.print("Collision occurs AT STATION"+a[i]+" & STATION"+b[i]+"\n");
           for(i=0;i<dis;i++)
           if(flag[i]==1)
           	c1++;
           if(c1==0)
     	    System.out.print("DATA TRANSFER successfully BETWEEN ALL STATIONS ");
	}
}