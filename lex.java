import java.io.*;
import java.util.*;
import java.lang.*;
class lex
{
public static void main(String args[])throws IOException
{
int k=0;
boolean flag=false;
String[] operators={"+","-","*","/",">","<",">=","<=","=","%","==","=+","=-","=*","=/","=%","++","--","+-/*%=<>"};
String[] keywords={"int","float","double","if","else","for","while","do","return","break","char","goto","void"};
String[] delim={"(",")","{","}",";",":"};
BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter the String");
String s=b.readLine();
String delims = "[+\\-*/=\\^\\<>()&|;: ]+"; 
String[] sub = s.split(delims);
String[] tokens=s.split("");
System.out.println("keywords are:");
for(int i=0;i<sub.length;i++)
{   
for(int j=0;j<keywords.length;j++)
	{
       if(sub[i].equals(keywords[j]))
		{
                System.out.println(sub[i]);
		sub[i]="";
		}
	}      
}
System.out.println("Relational Operators are:");
for(int i=0;i<tokens.length;i++)
{   
for(int j=0;j<operators.length;j++)
	{
       if(tokens[i].equals(operators[j]))
               System.out.println(tokens[i]);
      	}      
}

System.out.println("Delimiters are:");

for(int i=0;i<tokens.length;i++)
{   
for(int j=0;j<delim.length;j++)
	{
       if(tokens[i].equals(delim[j]))
               System.out.println(tokens[i]);
      	}      
}

System.out.println("Identifiers are:");
for(int i=0;i<sub.length;i++)
	{
		char[] t=sub[i].toCharArray();
		for(int j=0;j<t.length;j++)
			if(Character.isLetter(t[j]))
				{
				flag=true;
				k=i;
				}
if(flag==true)
System.out.println(sub[k]);	
			
	}


flag=false;
System.out.println("Numbers are:");

for(int i=0;i<sub.length;i++)
	{
		char[] t=sub[i].toCharArray();
		for(int j=0;j<t.length;j++)
			if(Character.isDigit(t[j]))
				{
				flag=true;
				k=i;
				}
if(flag==true)
System.out.println(sub[k]);
	}                     
}
}     
