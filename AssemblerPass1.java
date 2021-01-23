import java.io.*;
import java.lang.*;
import java.util.*;
class AssemblerPass1
{
FileInputStream fin= new FileInputStream("pass1.txt");
DataInputStream in= new DataInputStream(fin);
String s[]=new String[20]; int n,i;
String mot[][]=new String[20][20]; int top;
String pot[][]=new String[20][20]; int top1;
String st[][]=new String[20][20]; int top2;
String bt[][]=new String[20][2];
String lt[][]=new String[20][20]; int top3;
String pass1[][]=new String[20][20]; int top4;
String pass2[][]=new String[20][20];
int j,lc,reg,f1,f2,f3;
boolean flag;

AssemblerPass1()throws IOException
{
i=top=top1=top2=top3=top4=-1;
String temp=in.readLine();
while(temp!=null)
{
s[++i]=temp;
temp=in.readLine();
}
n=i;
for(j=0;j<=15;j++)
{
bt[j][0]="N";
bt[j][1]="-";
}
}

void initialize()
{
String psedo_char[]={ "START" , "USING" , "DROP" , "EQU" , "END" , "DS" , "DC" };
String mcop[]={ "A" , "L" , "ST" , "MVC" };
String dtype[]= { "DS" , "DC" };
compute(psedo_char,mcop,dtype);
display();
}
void compute(String psedo_char[],String mcop[],String dtype[])
{
int p1,p2,p3,p4;
String s1;
char c1;
f1=f2=f3=-1;
boolean f6=false;
lc=0;
flag=true;
for(i=0;i<=n;i++)
{
f1=s[i].indexOf("START");
f2=s[i].indexOf("USING");
f3=s[i].indexOf("L ");
findlc();
//MOT
for(j=0;j<4;j++)
{
p1=s[i].indexOf(mcop[j]);
if(p1!=-1)
{
p2=mcop[j].length();
c1=s[i].charAt(p1+p2);
if(c1==' ')
{
p3=s[i].lastIndexOf(",");
p4=s[i].indexOf("USING");
flag=check(mot,top,mcop[j]);
if(flag)
{
mot[++top][0]=mcop[j];
mot[top][1]=Integer.toHexString(45*(top+1));
mot[top][2]="4";
}
if((top3==-1) && i>1)
{
pass1[++top4][0]=Integer.toString(lc);
pass1[top4][1]=s[i].substring(p1,p3+1)+"_"+"(0,"+Integer.toString(reg)+")";
pass2[top4][0]=Integer.toString(lc);
pass2[top4][1]=s[i].substring(p1)+"(0,"+Integer.toString(reg)+")";
}
}
}
}
//POT
for(j=0;j<7;j++)
{
flag=true;
p1=s[i].indexOf(psedo_char[j]);
if(p1!=-1)
{
f6=psedo_char[j].equals("USING");
boolean f4=psedo_char[j].equals("DC");
boolean f5=psedo_char[j].equals("DS");
if(f6)
{
p2=s[i].indexOf(",");
reg=Integer.parseInt(s[i].substring(p2+1));
}
flag=check(pot,top1,psedo_char[j]);
if(flag)
{
pot[++top1][0]=psedo_char[j];
pot[top1][1]="P1"+psedo_char[j];
}
//LT
if(f4 || f5)
{
p3=s[i].lastIndexOf(" ");
p4=s[i].indexOf(" ");
lt[++top3][0]=s[i].substring(0,p4);
lt[top3][1]=s[i].substring(p3+1);
lt[top3][2]=Integer.toHexString(lc);
lt[top3][3]="1";
lt[top3][4]="R";
p3=lt[top3][1].indexOf("F'");
if(p3!=-1)
{
pass1[++top4][1]=lt[top3][1].substring(p3+2,lt[top3][1].length()-1);
pass2[top4][1]=Integer.toBinaryString(Integer.parseInt(pass1[top4][1]));
pass1[top4][0]=pass2[top4][0]=Integer.toString(lc);
}
if(f5)
{
pass1[++top4][1]=pass2[top4][1]="-";
pass1[top4][0]=pass2[top4][0]=Integer.toString(lc);
}
for(int k=0;k<=top4;k++)
pass2[k][1]=pass2[k][1].replace(lt[top3][0],Integer.toString(lc));
}
}
}
//ST
p1=s[i].charAt(0);
if(p1!=' ')
{
p2=s[i].indexOf(" ");
flag=check(st,top2,s[i].substring(0,p2));
if(flag)
{
st[++top2][0]=s[i].substring(0,p2);
st[top2][1]=Integer.toHexString(lc);
st[top2][2]="1";
st[top2][3]="R";
}
}
}
//BT
bt[reg][0]="Y";
bt[reg][1]="000";
}
void findlc()
{
if( (f1==-1 && f2==-1 && f3==-1) )
lc=lc+4;
}
boolean check(String ax[][],int ptr,String st)
     {
      boolean flag1=false;
      if(ptr!=-1)
      {
      for(int l=0;l<=ptr;l++)
      if(ax[l][0].equals(st))
      {
      flag1=true;
      break;
      }
      if(flag1)
      return false;
      else
      return true;
      }
      else
      return true;
     }
void display()
{
System.out.println("\nGiven Source Code:");
System.out.println();
for(i=0;i<=n;i++)
System.out.println(s[i]);
System.out.println("\nMOT:");
System.out.println("Machine-op\tBinary-op\tInstn length");
System.out.println();
for(i=0;i<=top;i++)
System.out.println(mot[i][0]+"\t\t"+mot[i][1]+"\t\t"+mot[i][2]);
System.out.println("\nPOT:");
System.out.println("Psedo-op\tRel. Address");
System.out.println();
for(i=0;i<=top1;i++)
System.out.println(pot[i][0]+"\t\t"+pot[i][1]);
System.out.println("\nST:");
System.out.println("Symbol\t\tValue\t\tLength\t\tRelocation");
System.out.println();
for(i=0;i<=top2;i++)
{
if(!st[i][0].equals("L") && !st[i][0].equals("A") && !st[i][0].equals("ST") && !st[i][0].equals("USING"))
System.out.println(st[i][0]+"\t\t"+st[i][1]+"\t\t"+st[i][2]+"\t\t"+st[i][3]);
}
System.out.println("\nBT:");
System.out.println("Indicator\tAvailable"/*\tRelative addr"*/);
System.out.println();
for(i=0;i<=15;i++)
System.out.println(i+"\t\t "+bt[i][0]/*+"\t\t "+bt[i][1]*/);
System.out.println("\nLT:");
System.out.println("Literal\t\tValue\t\tLength\t\tRelocation");
System.out.println();
for(i=0;i<=top3;i++)
System.out.println(lt[i][1]+"\t\t"+lt[i][2]+"\t\t"+lt[i][3]+"\t\t"+lt[i][4]);
System.out.println("\nPass1:");
System.out.println("Rel. Addr\tMnemonic instn");
System.out.println();
for(i=0;i<=top4;i++)
System.out.println(pass1[i][0]+"\t\t"+pass1[i][1]);
}
public static void main(String args[])throws Exception
{
AssemblerPass1 as=new AssemblerPass1();
as.initialize();
}
}
