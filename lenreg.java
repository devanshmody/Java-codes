import java.io.*;
import java.util.*;
import java.math.*;
class leniar_regression
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		float x[]=new float [20];
		float y[]=new float [20];
            float yan=0;
               
                float sx=0,xans=0,yans=0,c=0,a1=0,a2=0,a3=0,a4=0,B1=0,B0=0,s1=0,s2=0;
		int n=0;
		System.out.println("enter the no of values points: \n");
		n=sc.nextInt();
                System.out.println("enter the value of X  points: \n");
		for(int i=0;i<n;i++)
                {
                     System.out.println("enter the value of X:"+i);
                     x[i]=sc.nextFloat();
                    
                }
                for(int i=0;i<n;i++)
                {
                    sx=sx+x[i];
                }
                c=sx/n;
                 System.out.println("value of c is "+c);

                 for(int i=0;i<n;i++)
                 {
                     if(x[i]<c)
                         y[i]=0;
                     else
                         y[i]=1;
                 }
                 System.out.println("value of y are");
                  for(int i=0;i<n;i++)
                  {
                       System.out.println(y[i]);

                  }


                 for(int i=0;i<n;i++)
                  {
                       xans=xans+x[i];
                       yans=yans+y[i];


                 }
                 for(int i=0;i<n;i++)
                  {
                       a1=a1+x[i]*y[i];

                 }
                 for(int i=0;i<n;i++)
                  {
                       a2=xans*yans;

                 }
                 a2=a2/n;
                 

                 for(int i=0;i<n;i++)
                  {
                      a3=a3+(x[i]*x[i]);
                  }

                  a4=(xans*xans)/n;
                 
                  B1=(a1-a2)/(a3-a4);
                  
                  for(int i=0;i<n;i++)
                  {
                    s1=s1+y[i];
                    s2=s2+(B1*x[i]);
                  }
                  B0=(yans-s2)/n;

                  System.out.println("values of B0 : "+B0+"\n B1 : "+B1);

                  for(int i=0;i<n;i++)
                  {
                     y[i]=B0+B1*x[i];

                  }
                   for(int i=0;i<n;i++)
                  {
                     y[i]=B0+B1*x[i];

                  }
                   for(int i=0;i<n;i++)
                  {
                     System.out.println("y:"+1+" "+y[i]);

                  }
                  
           
	}

}