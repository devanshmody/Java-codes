import java.io.*;
import java.util.*;

class Decision 
{
	public static void main(String arg[])throws Exception 
	{
		int n,i,count=0,diff=0;
			double c=0.0,d=0.0,a=0.0,b=0.0,info=0.0;
		int id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		String age[]={"youth","youth","middle_age","senior","senior","middle_age","youth","youth","senior","youth","middle_age","middle_age","senior"};
		String income[]={"high","high","high","medium","low","low","low","medium","low","medium","medium","medium","high","medium"};
		String Student[]={"no","no","no","no","yes","yes","yes","no","yes","yes","yes","no","yes","no"};
        String Credit_rating[]={"fair","excellent","fair","fair","fair","excellent","excellent","fair","fair","fair","excellent","excellent","fair","excellent"};
        String Classe[]={"no","no","yes","yes","yes","no","yes","no","yes","yes","yes","yes","yes","no"};
        
        for(i=0;i<14;i++)
        {
        	if(Classe[i]=="yes")
        	{
        		count++;
        	}
        }
        System.out.println("Number of tupels with class yes is:" +count);
        diff=14-count;
        System.out.println("Number of tupels with class no is:" +diff);
        
        c=(double)count/14;
        d=(double)diff/14;
        a=c*(Math.log(c))/Math.log(2);
        b=d*(Math.log(d))/Math.log(2);
        info=-a-b;
        System.out.println("Info(D):" +info);
       
        
	}
}
