import java.util.*;
import java.io.*;
class Lexical
{
	public static void main (String args[]) throws IOException
	{
		FileReader f1 = new FileReader("C:\\ganesh\\lex.txt");
		Scanner sc = new Scanner (f1);
		int i=0, count=1;
		String str;
		String key[]={"int","char","string","void","class"};
		String op[]={"+","-","/","*","="};
		String id[]={"main"};
		String ter[]={":",";"};
		String lit[]={"a","b","c","(",")"};
		while (sc.hasNext())
		{
			str=sc.next();
			for(i=0; i<key.length; i++)
			{
				if(str.equals(key[i]))
				{	System.out.println(count+"\t"+key[i]+"\tkeyword");
					break;
				}	
			}
			for(i=0; i<op.length; i++)
			{
				if(str.equals(op[i]))
				{	System.out.println(count+"\t"+op[i]+"\toperator");
					break;
				}	
			}
			for(i=0; i<id.length; i++)
			{
				if(str.equals(id[i]))
				{	System.out.println(count+"\t"+id[i]+"\tidentifier");
					break;
				}	
			}
			for(i=0; i<ter.length; i++)
			{
				if(str.equals(ter[i]))
				{	System.out.println(count+"\t"+ter[i]+"\tterminal");
					break;
				}	
			}
			for(i=0; i<lit.length; i++)
			{
				if(str.equals(lit[i]))
				{	System.out.println(count+"\t"+lit[i]+"\tliteral");
					break;
				}	
			}
			if (str.equals(")")||str.equals("{")||str.equals("}")||str.equals(";"))
				count++;
		}
		
		
	}
}

