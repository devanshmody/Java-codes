
import java.io.*;
import java.util.*;
 
 class Binarytheorem 
{

public static void main(String arg[])
{
	int buyspc=0,nbuyspc=0,age_yes=0,age_no=0,cr_yes=0,cr_no=0,income_yes=0,income_no=0,i;
     	double P_Y_cr=0,P_N_cr=0,P_Y_income=0,P_N_income,P_Y_age=0,P_N_age=0;

	Scanner sc=new Scanner(System.in);
     int id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};	
	String age[]={"youth","youth","middle_age","senior","senior","middle_age","youth","youth","senior","youth","middle_age","middle_age","senior"};
	String income[]={"high","high","high","medium","low","low","low","medium","low","medium","medium","medium","high","medium"};
	String Student[]={"no","no","no","no","yes","yes","yes","no","yes","yes","yes","no","yes","no"};
    String Credit_rating[]={"fair","excellent","fair","fair","fair","excellent","excellent","fair","fair","fair","excellent","excellent","fair","excellent"};
    String Classe[]={"no","no","yes","yes","yes","no","yes","no","yes","yes","yes","yes","yes","no"};
    System.out.println("Enter the number of samples to claasify");
    
    if(Class[i]=="yes")
    {
    	buyspc++;
    }
    P_buy=(double)buyspc/14;
    System.out.println("probabilty of buying computer="+P_buy);
    
     if(Class[i]=="No")
    {
    	buyspc++;
    }
     P_buy=(double)buyspc/14;
     System.out.println("probabilty of buying computer="+P_buy);
     P_nbuy=(double)nbuyspc/14;
     System.out.println("probalaity of student not buying computer"+P_nbuy);
     
     for(i=0;i<14;i++)
     {
     	if(age[i]=="youth" && Class[i]=="yes");
     	{
     	
     	age_yes++;
     	
     }
     
     if(age[i]=="youth" && Class[i]=="No");
     {
     	age_no++;
     }
 		P_Y_age=(double)age_yes/buyspc;
		P_N_age=(double)age_no/nbuyspc;
		System.out.println("probality of student under youth catergory for buying a computer"+P_Y_age);
		System.out.println("probability of student under youth catergory for not buyinhg computer"+P_N_age);
	  
     }
	  for(i=0;i<14;i++)
     {
     	if(credit_Rating[i]=="fair" && Class[i]=="yes");
     	cr_yes++;
     	
     }
     
     if(credit_Rating[i]=="fair" && Class[i]=="No");
     {
     	cr_no++;
     }
	P_Y_cr=(double)cr_yes/buyspc;
		P_N_cr=(double)cr_no/nbuyspc;
		System.out.println("probality of student under youth catergory for buying a computer"+P_Y_cr);
		System.out.println("probability of student under youth catergory for not buyinhg computer"+P_N_cr);
     }

        for(i=0;i<14;i++)
        {
     	if(income[i]=="medium" && Class[i]=="yes");
     	{
     	
     	income_yes++;
     	
        }
     
     if(income[i]=="medium" && Class[i]=="No");
     {
     	income_no++;
     }
	    P_Y_income=(double)income_yes/buyspc;
		P_N_income=(double)income_no/nbuyspc;
		System.out.println("probality of student under youth catergory for buying a computer"+P_Y_income);
		System.out.println("probability of student under youth catergory for not buyinhg computer"+P_N_income);
        }		
		
}
}