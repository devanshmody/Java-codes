import java.util.Scanner;
import java.util.*;
import java.io.*;


class Kmean
{
	public static void main(String args[])
    {
    	int n,i;
        Scanner sc=new Scanner(System.in);
    	System.out.print("Emter no of elements:");
    	n=sc.nextInt();
    	int a[]=new int[n];
    	System.out.println("Enter the elements:");
    	for(i=0;i<n;i++)
    	{
    		a[i]=sc.nextInt();
    	}
    	int x=new Random().nextInt(a.length);
    	int y=new Random().nextInt(a.length);
    	System.out.println("The number 1 is:"+x);
    	System.out.println("The number 2 is:"+y);
    	int k1[]=new int[n];
    	int k2[]=new int[n];
    	k1[0]=x;
    	k1[1]=y;
    	for(i=0;i<n;i++)
    	{
    		System.out.println("k1["+i+"]="+k1[i]);
    	}
    	for(i=0;i<n;i++)
    	{
    		if((a[i]!=x)&&(a[i]!=y))
    		{
    			k2[i]=a[i];
    		}
    		System.out.println("k2["+i+"]="+k2[i]);
    	}

    }


}