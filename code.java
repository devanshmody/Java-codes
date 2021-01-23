import java.io.*;
import java.util.*;

class code {
  public static void main(String args[]) {
    Scanner sn = new Scanner(System.in);
    int n;
    int i,j;
    System.out.println("Enter number of expressions you want?");
    n=sn.nextInt();
    String sla[]=new String[n];
    String brkr[]=new String[n];
    String brkl[]=new String[n];
    for(i=0;i<n;i++) {
     sla[i]=sn.next();
    }
    for(i=0;i<n;i++)
    {
     StringTokenizer stp=new StringTokenizer(sla[i],"=");
     brkr[i]=stp.nextToken();
     brkl[i]=stp.nextToken();
    }
    for(i=0;i<n;i++) {
     for(j=0;j<n;j++)
      {
       if(i!=j) {
       if(brkl[j].contains(brkl[i])) {
           String str=brkl[j];
           String searchQuery = brkl[i];
            String replaceWord = brkr[i];
            int startIndexVal = 0;
            int endIndexVal = 0;

            startIndexVal = str.indexOf(searchQuery);
            endIndexVal = startIndexVal + searchQuery.length();
            str = str.substring(0, startIndexVal) + replaceWord + str.substring(endIndexVal);
            brkl[j]=str;
       }
        }
      }
    }  
System.out.println("\nAfter common subexpression elimination:");
for(i=0;i<n;i++)
 {
  System.out.println(brkr[i]+"="+brkl[i]);
 }
}
}