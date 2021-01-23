import java.io.*;
import java.lang.*;
class First1
{
	static String grammar;
	static String rule[];
	static String var[];
	static String list;
	
	public static void main(String ar[])
	{
		input();
		rule = grammar.split(" ");
			System.out.println();
			for(int i=0; i<list.length();i++)
			{
				char c=list.charAt(i);
				System.out.println("First("+c+")={"+First(c)+"}");
			}	
			
	}
	static void input()
	{
		DataInputStream din=new DataInputStream(System.in);
		try{
			System.out.println("enter the grammar");
			grammar=din.readLine();
			System.out.println("List");
			list=din.readLine();
		}catch(Exception e){
			System.exit(0);
		}
		
	}
	static String First(char c)
	{
		if(!isNonTerminal(c))
			return c+"";
			String First="";
			for(int i=0;i<rule.length;i++)
			{
				String s="";
				for(int j=2;j<rule[i].length();j++)
				{
					char ch=rule[i].charAt(j);
					s=First(ch);
					if(!s.equals(" "))
						break;
				}
				First+=s+" ";
				
			}
			return First.trim;
	}
	
	static boolean isNonterminal(char c);
	{
		if('A'<=c&&c<='Z')
			return true;
			return false;
	}
	
}