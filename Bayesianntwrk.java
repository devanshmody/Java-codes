import java.util.*;
import java.lang.*;
class decisiontree51
{
	public static void main(String args[])
	{
		int id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		String age[]={"y","y","m","s","s","s","m","y","y","s","y","m","m","s"};
		String income[]={"h","h","h","m","l","l","l","m","l","m","m","m","h","m"};
		String student[]={"n","n","n","n","y","y","y","n","y","y","y","n","y","n"};
		String cr[]={"f","e","f","f","f","e","e","f","f","f","e","e","f","e"};
		String buy[]={"n","n","y","y","y","n","y","n","y","y","y","y","y","n"};
		String gain[]=new String[10];
		int i,j,k,l,m,n;
		double count,count1,a=0.0,b=0.0,c,d,infod,a1,info1,info2,info3,c1=0.0,c2=0.0,c3=0.0,ent_age,gain_age,pyes,pno,page1,page2,pin1,pin2,pst1,pst2,pcr1,pcr2,px1,px2,p1,p2;
		Scanner sc=new Scanner(System.in);
		System.out.println("the table is as follows:");
		System.out.println("ID"+"\t"+"Age"+"\t"+"Income"+"\t"+"Student"+"\t"+"Credit Rating"+"\t"+"Buyer Class");
		for(i=0,j=0,k=0,l=0,m=0,n=0;i<14;i++,j++,k++,l++,m++,n++)
		{
			System.out.println(id[i]+"\t"+age[j]+"\t"+income[k]+"\t"+student[l]+"\t"+cr[m]+"\t"+buy[n]);
		}
		System.out.println("the query is as follows:");
		System.out.println("age=youth, income=medium, student=yes, creditrating=fair");
		for(i=0;i<14;i++)
		{
			if(buy[i]=="y")
			{
				a++;
			}
			else if(buy[i]=="n")
			{
				b++;
			}
		}
		System.out.println("no of yes tuples="+a);
		System.out.println("no of no tuples="+b);
		pyes=a/14;
		pno=b/14;
		System.out.println("probability of buy class yes="+pyes);
		System.out.println("probability of buy class no="+pno);
		System.out.println("for attribute age=youth:");
		count=0.0;
		count1=0.0;
		for(i=0;i<14;i++)
		{
			if(age[i]=="y"&&buy[i]=="y")
			{
				count++;
			}
			else if(age[i]=="y"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		page1=count/a;
		page2=count1/b;
		System.out.println("probability of age youth and buy class yes="+page1);
		System.out.println("probability of age youth and buy class no="+page2);
		System.out.println("for attribute income=medium:");
		count=0.0;
		count1=0.0;
		for(i=0;i<14;i++)
		{
			if(income[i]=="m"&&buy[i]=="y")
			{
				count++;
			}
			else if(income[i]=="m"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		pin1=count/a;
		pin2=count1/b;
		System.out.println("probability of income medium and buy class yes="+pin1);
		System.out.println("probability of income medium and buy class no="+pin2);
		System.out.println("for attribute student=yes:");
		count=0.0;
		count1=0.0;
		for(i=0;i<14;i++)
		{
			if(student[i]=="y"&&buy[i]=="y")
			{
				count++;
			}
			else if(student[i]=="y"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		pst1=count/a;
		pst2=count1/b;
		System.out.println("probability of student yes and buy class yes="+pst1);
		System.out.println("probability of student yes and buy class no="+pst2);
		System.out.println("for attribute creditrating=fair:");
		count=0.0;
		count1=0.0;
		for(i=0;i<14;i++)
		{
			if(cr[i]=="f"&&buy[i]=="y")
			{
				count++;
			}
			else if(cr[i]=="f"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		pcr1=count/a;
		pcr2=count1/b;
		System.out.println("probability of creditrating fair and buy class yes="+pcr1);
		System.out.println("probability of creditrating fair and buy class no="+pcr2);
		px1=page1*pin1*pst1*pcr1;
		px2=page2*pin2*pst2*pcr2;
		System.out.println("posterior probability of buy class yes="+px1);
		System.out.println("posterior probability of buy class no="+px2);
		p1=pyes*px1;
		p2=pno*px2;
		System.out.println("the overall posterior probability of buy class yes="+p1);
		System.out.println("the overall posterior probability of buy class no="+p2);
		if(p1>p2)
			System.out.println("then bayesion classifier predicts buy class yes for query X");
		else	
		    System.out.println("then bayesion classifier predicts buy class no for query X");
	}
}	