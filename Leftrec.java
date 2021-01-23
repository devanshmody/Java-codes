import java.util.*;
import java.io.*;
class Leftrec
{
	public static void main(String args[])
	{
		char non_terminal,beta,alpha;
		String production;
		int i=0;
		String input[]=new String[6];
		Scanner sn = new Scanner(System.in);
		System.out.println("enter no of productions(enter end to stop):");
		int n=sn.nextInt();
		System.out.println("enter initial source code");
		System.out.println();
		do
		{
			System.out.println("enter productions");
			i++;
			input[i]=sn.nextLine();
			i++;
		}
		while(input[i].equalsIgnoreCase("end")==false);
		System.out.println("grammer after removing left recursion");
		System.out.println("where 9 is epsilon");
		for(i=1;i<n;i++)
		{
			int index=3;
			production=input[i];
			non_terminal=production.charAt(0);			
			if(non_terminal==production.charAt(index))
			{
				alpha=production.charAt(index+1);
				while(production.charAt(index)!=0 && production.charAt(index)!='|')
					index++;
					if(production.charAt(index)!=0)
					{
						beta=production.charAt(index+1);
						System.out.println(non_terminal+"\'->"+beta+non_terminal+"\'");
						System.out.println("\n"+non_terminal+"\'->"+alpha+non_terminal+"\'9\n");
					}
					else
						System.out.println("grammer cannot be reduced");
			}
			else
				System.out.println("\n"+production);
			
		}
	}
}