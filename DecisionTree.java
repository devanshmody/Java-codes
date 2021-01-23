import java.io.*;
import java.util.*;
import java.math.*;
class DecisionTree
{
	public static void main(String args[])
	{
	int n,i,count=0,diff=0,county=0,countn=0,countmy=0,countmn=0,countsy=0,countsn=0,counthy=0,counthn=0,countmey=0,countmen=0,countly=0,countln=0;
	double info,a=0.0,b=0.0,c=0.0,d=0.0,e=0.0,infoy,infom,infos,a1=0.0,a2=0.0,a3=0.0,ena,gaina,infoh,infome,infol,eni,gaini;
	int id[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	String age[]={"youth","youth","middleAged","senior","senior","senior","middleAged","youth","youth","senior","youth","middleAged","middleAged","senior"};
	String income[]={"high","high","high","medium","low","low","low","medium","low","medium","medium","medium","high","medium"};
	String Student[]={"no","no","no","no","yes","yes","yes","no","yes","yes","yes","no","yes","no"};
	String Credit_Rating[]={"fair","excellent","fair","fair","fair","excellent","excellent","fair","fair","fair","excellent","excellent","fair","excellent"};
	String Class[]={"No","No","Yes","Yes","Yes","No","Yes","No","Yes","Yes","Yes","Yes","Yes","No"};
	Scanner sc=new Scanner(System.in);
	for(i=0;i<14;i++)
	{
	if(Class[i]=="Yes")
	{
	count++;
	}
	}
	System.out.println("No.of Tuples with class Yes = "+count);
	diff=14-count;
	System.out.println("No.of Tuples with class No = "+diff);
	c=(double)count/14;
	d=(double)diff/14;
	a=c*(Math.log(c)/Math.log(2));
	b=d*(Math.log(d)/Math.log(2));

	info=(-a-b);
	System.out.println("Info(D)  ="+info);
	System.out.println("Satratin with attribute age");
	for(i=0;i<14;i++)
	{
		if(age[i]=="youth"&&Class[i]=="Yes")
			county++;
		if(age[i]=="youth"&&Class[i]=="No")
			countn++;
	}
	System.out.println("No.of Tuples with class Yes = "+county);
	System.out.println("No.of Tuples with class No = "+countn);
	a1=county+countn;
	b=(double)county/a1;
	c=(double)countn/a1;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infoy=(-d-e);
	System.out.println("Info(Y)  ="+infoy);
	for(i=0;i<14;i++)
	{
		if(age[i]=="middleAged"&&Class[i]=="Yes")
			countmy++;
		if(age[i]=="middleAged"&&Class[i]=="No")
			countmn++;
	}
	System.out.println("No.of Tuples with class Yes = "+countmy);
	System.out.println("No.of Tuples with class No = "+countmn);
	a2=countmy+countmn;
	b=(double)countmy/a2;
	c=(double)countmn/a2;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infom=(int)(-d-e);
	System.out.println("Info(M)  ="+infom);
	for(i=0;i<14;i++)
	{
		if(age[i]=="senior"&&Class[i]=="Yes")
			countsy++;
		if(age[i]=="senior"&&Class[i]=="No")
			countsn++;
	}
	System.out.println("No.of Tuples with class Yes = "+countsy);
	System.out.println("No.of Tuples with class No = "+countsn);
	a3=countsy+countsn;
	b=(double)countsy/a3;
	c=(double)countsn/a3;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infos=(-d-e);
	System.out.println("Info(S)  ="+infos);
	ena=((a1/14)*infoy+(a2/14)*infom+(a3/14)*infos);
	System.out.println("The value of entropy(age) is= "+ena);
	gaina=info-ena;
	System.out.println("The value of gain(age)= "+gaina);
	
	System.out.println("Satratin with attribute income");
	for(i=0;i<14;i++)
	{
		if(income[i]=="high"&&Class[i]=="Yes")
			counthy++;
		if(income[i]=="high"&&Class[i]=="No")
			counthn++;
	}
	System.out.println("No.of Tuples with class Yes = "+counthy);
	System.out.println("No.of Tuples with class No = "+counthn);
	a1=counthy+counthn;
	b=(double)counthy/a1;
	c=(double)counthn/a1;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infoh=(-d-e);
	System.out.println("Info(H)  ="+infoh);
	for(i=0;i<14;i++)
	{
		if(income[i]=="medium"&&Class[i]=="Yes")
			countmey++;
		if(income[i]=="medium"&&Class[i]=="No")
			countmen++;
	}
	System.out.println("No.of Tuples with class Yes = "+countmey);
	System.out.println("No.of Tuples with class No = "+countmen);
	a2=countmey+countmen;
	b=(double)countmey/a2;
	c=(double)countmen/a2;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infome=(-d-e);
	System.out.println("Info(ME)  ="+infome);
	for(i=0;i<14;i++)
	{
		if(income[i]=="low"&&Class[i]=="Yes")
			countly++;
		if(income[i]=="low"&&Class[i]=="No")
			countln++;
	}
	System.out.println("No.of Tuples with class Yes = "+countly);
	System.out.println("No.of Tuples with class No = "+countln);
	a3=countly+countln;
	b=(double)countly/a3;
	c=(double)countln/a3;
	d=b*(Math.log(b)/Math.log(2));
	e=c*(Math.log(c)/Math.log(2));
	infol=(-d-e);
	System.out.println("Info(L)  ="+infol);
	eni=((a1/14)*infoh+(a2/14)*infome+(a3/14)*infol);
	System.out.println("The value of entropy(age) is= "+eni);
	gaini=info-eni;
	System.out.println("The value of gain(income)= "+gaini);
	
}
}