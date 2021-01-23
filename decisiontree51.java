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
		double count=0.0,count1=0.0,a,b,c,d,infod,a1,info1,info2,info3,c1=0.0,c2=0.0,c3=0.0,ent_age,gain_age;
		Scanner sc=new Scanner(System.in);
		/*System.out.println("enter customer id:");
		for(i=0;i<14;i++)
		{
			id[i]=sc.nextInt();
		}
		System.out.println("enter their age:");
		for(i=0;i<14;i++)
		{
			age[i]=sc.next();
		}
		System.out.println("enter their income:");
		for(i=0;i<14;i++)
		{
			income[i]=sc.next();
		}
		System.out.println("enter whether student or not:");
		for(i=0;i<14;i++)
		{
			student[i]=sc.next();
		}
		System.out.println("enter their credit rating:");
		for(i=0;i<14;i++)
		{
			cr[i]=sc.next();
		}
		System.out.println("enter their buyer class:");
		for(i=0;i<14;i++)
		{
			buy[i]=sc.next();
		}*/
		System.out.println("the table is as follows:");
		System.out.println("ID"+"\t"+"Age"+"\t"+"Income"+"\t"+"Student"+"\t"+"Credit Rating"+"\t"+"Buyer Class");
		for(i=0,j=0,k=0,l=0,m=0,n=0;i<14;i++,j++,k++,l++,m++,n++)
		{
			System.out.println(id[i]+"\t"+age[j]+"\t"+income[k]+"\t"+student[l]+"\t"+cr[m]+"\t"+buy[n]);
		}
		for(i=0;i<14;i++)
		{
			if(buy[i]=="y")
			{
				count++;
			}
			else if(buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		a=count+count1;
		a1=(count/a);
		System.out.println(a1);
		b=(count1/a);
		c=Math.log(a1)/Math.log(2);
		d=Math.log(b)/Math.log(2);
		infod=-a1*c-b*d;
		System.out.println("the value of infod="+infod);
		count=0.0;
		count1=0.0;
		System.out.println("for attribute age:");
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
		a=count+count1;
		a1=(count/a);
		System.out.println(a1);
		b=(count1/a);
		c=Math.log(a1)/Math.log(2);
		d=Math.log(b)/Math.log(2);
		info1=-a1*c-b*d;
		System.out.println("the value of info1="+info1);
		count=0.0;
		count1=0.0;
        for(i=0;i<14;i++)
		{
			if(age[i]=="m"&&buy[i]=="y")
			{
				count++;
			}
			else if(age[i]=="m"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		a=count+count1;
		a1=(count/a);
		System.out.println(a1);
		b=(count1/a);
		c=Math.log(a1)/Math.log(2);
		d=Math.log(b)/Math.log(2);
		info2=(int)(-a1*c-b*d);
		System.out.println("the value of info2="+info2);
		count=0;
		count1=0;
		for(i=0;i<14;i++)
		{
			if(age[i]=="s"&&buy[i]=="y")
			{
				count++;
			}
			else if(age[i]=="s"&&buy[i]=="n")
			{
				count1++;
			}
		}
		System.out.println("no of yes tuples="+count);
		System.out.println("no of no tuples="+count1);
		a=count+count1;
		a1=(count/a);
		System.out.println(a1);
		b=(count1/a);
		c=Math.log(a1)/Math.log(2);
		d=Math.log(b)/Math.log(2);
		info3=(-a1*c-b*d);
		System.out.println("the value of info3="+info3);
		for(i=0;i<14;i++)
		{
			if(age[i]=="y")
			{
				c1++;
			}
			else if(age[i]=="m")
			{
				c2++;
			}
			else if(age[i]=="s")
			{
				c3++;
			}
		}
		a=14;	
		ent_age=((c1/a)*info1)+	((c2/a)*info2)+((c3/a)*info3);
		System.out.println("entropy of age="+ent_age);
		gain_age=infod-ent_age;
		System.out.println("the gain of age is="+gain_age);
	}
}