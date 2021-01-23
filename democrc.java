import java.util.*;
import java.lang.*;
import java.io.*;
public class democrc
{
    public int exor(int a,int b)
    {
        int s=0;
        if(a==0 && b==0 || a==1 && b==1)
        {
            s=0;
        }
        if(a==1 && b==0 || a==0 && b==1)
        {
            s=1;
        }
        return s;
    }
    public void div(int c[],int d[])
    {
        int i,j,k,l;
        int z[]=new int[15];
        for(i=0;i<14;i++)
        {
            z[i]=c[i];
        }
        for(k=0;k<9;k++)
        {
            if(z[k]==1)
            {
                    for(i=0;i<5;i++)
                    {
                        j=exor(z[k+i],d[i]);
                        z[k+i]=j;
                    }   
            }
        }        
       for(i=0;i<11;i++)
        {
            z[i]=c[i];
        }
        for(k=0;k<9;k++)
        {
            if(z[k]==1)
            {
                    for(i=0;i<5;i++)
                    {
                        j=exor(z[k+i],d[i]);
                        z[k+i]=j;
                    }
            }
        }
        if(z[13]==0 && z[12]==0 && z[11]==0 && z[10]==0 && z[9]==0)
        {
            System.out.println("CORRECT CODE RECEIVED");
        }
        else
        {
            System.out.println("INCORRECT CODE RECEIVED");
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int c[]=new int [15];
        int i,a,sum=0,j;
        democrc m=new democrc();
        System.out.println("enter the data bits : ");
        for (i=0;i<11;i++)
        {
            c[i]=sc.nextInt();
        }
        int d[]=new int[5];
        d[0]=1;
        d[1]=0;
        d[2]=1;
        d[3]=1;
        d[4]=1;
        c[11]=0;
        c[12]=0;
        c[13]=0;
        for(i=0;i<13;i++)
        {
            System.out.print(c[i]+" ");
        }
        a=m.exor(1,0);
        System.out.println("output :"+a);
        m.div(c,d);
    }

}
