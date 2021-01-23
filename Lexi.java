import java.util.*;
import java.io.*;
class Lexi
{
	public static void main(String args[]) throws IOException
	{
		FileReader f1=new FileReader("lex.txt");
		Scanner sc=new Scanner(f1);
		int i=0,count=1;
		String str;
		String key[]={"int","char","float","double","void","main","class"};
		String op[]={"+","-","*","/","="};
		String id[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String ter[]={".",",",";"};
		String num[]={"0","1","2","3","4","5","6","7","8","9"};
		while(sc.hasNext())
		{
			str=sc.next();
			for(i=0;i<key.length;i++)
			{
				if(str.equals(key[i]))
				{
					System.out.println(count+"\t"+key[i]+"\tkeyboard");
					break;
				}
			}
			for(i=0;i<op.length;i++)
			{
				if(str.equals(op[i]))
				{
					System.out.println(count+"\t"+op[i]+"\toperands");
					break;
				}
			}
			for(i=0;i<ter.length;i++)
			{
				if(str.equals(ter[i]))
				{
					System.out.println(count+"\t"+ter[i]+"\tspecial character");
					break;
				}	
			}
			for(i=0;i<key.length;i++)
			{
				if(str.equals(id[i]))
				{
					System.out.println(count+"\t"+id[i]+"\tidentifier");
					break;
				}
			}
			for(i=0;i<num.length;i++)
			{
				if(str.equals(num[i]))
				{
					System.out.println(count+"\t"+num[i]+"\tnumber");
					break;
				}
			}
			if(str.equals(")")||str.equals("{")||str.equals("}")||str.equals(")"))
			{
				count++;
			}
		}
	}
}
		