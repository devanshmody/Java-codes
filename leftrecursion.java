import java.io.*;
import java.util.*;
class leftrecursion
 {
public static void main (String args[]) {
  char non_terminal;
  char beta,alpha;
  String production;
  int i=0;
  String[] input=new String[6];
  Scanner sn=new Scanner(System.in);
   System.out.println("Enter the Initial source Code:");
  System.out.println();
  do
  { 
  System.out.println("Enter production");
  i++;
   input[i]=sn.nextLine();
  
  }
  while(input[i].equalsIgnoreCase("End")==false);
  int n=i;
  System.out.println("GRAMMAR AFTER REMOVING LEFT RECURSION IS:\n");
  System.out.println("WHERE 9 IS EPSILON");

  for(i=1;i<n;i++)
{int index=3;
  production=input[i];
  non_terminal=production.charAt(0);
  if(non_terminal==production.charAt(index)) {
    alpha=production.charAt(index+1);
    
    while(production.charAt(index)!=0 && production.charAt(index)!='|')
      index++;
    if(production.charAt(index)!=0) {
      beta=production.charAt(index+1);
     
      System.out.println(non_terminal+"\'->"+beta+non_terminal+"\'");
      System.out.println("\n"+non_terminal+"\'->"+alpha+non_terminal+"\'|9\n");
    }
    else
      System.out.println("Grammar can't be reduced\n");
  }
  else
    System.out.println("\n"+production);
 }
}}
