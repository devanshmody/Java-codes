import java.util.*;
import java.io.*;
class Lexical
{
    public static void main(String args[])throws IOException
    {
        File fb=new File("C:\\Users\\Tejas Shah\\Documents\\lex.txt");
        BufferedReader br= new BufferedReader(new FileReader(new File("C:\\Users\\Tejas Shah\\Documents\\lex.txt")));
        String s,t1;
        int i,t=0;
        String k[]={"void","int"};
	String lit[]={"a","b","c"};
	String op[]={"+","="};
	String ter[]={"(",")","{","}",",",";"};
	String id[]={"main"};
        System.out.println("Line No."+"\t\tType"+"\t\t\tName");
        while((s=br.readLine())!=null) 
        {
            t++;
            Scanner sc=new Scanner(s).useDelimiter("\\s");
            while(sc.hasNext()) 
            {
		t1=sc.next();
		for(i=0;i<k.length;i++)
                    if(k[i].equals(t1))
                        System.out.println(t+"\t\t"+t1+"\t\tkeyword");
                for(i=0;i<lit.length;i++)
                    if(lit[i].equals(t1))
                        System.out.println(t+"\t\t"+t1+"\t\tliteral");
                for(i=0;i<op.length;i++)
                    if(op[i].equals(t1))
                        System.out.println(t+"\t\t"+t1+"\t\toperator");
                for(i=0;i<ter.length;i++)
                    if(ter[i].equals(t1))
                        System.out.println(t+"\t\t"+t1+"\t\tterminal");
                for(i=0;i<id.length;i++)
                    if(id[i].equals(t1))
                        System.out.println(t+"\t\t"+t1+"\t\tidentifier");
            }
        }
    }
}