import java.util.*;
class fcfs
{
public static void main(String args[]) throws Exception
{
int n,AT[],BT[],WT[],TAT[];
float AWT=0;
Scanner sc=new Scanner(System.in);
System.out.println("Enter no of process");
n=sc.nextInt();
BT=new int[n];
WT=new int[n];
TAT=new int[n];
AT=new int[n];
System.out.println("Enter Burst time for each process\n******************************");
for(int i=0;i<n;i++)
{
System.out.println("Enter BT for process "+(i+1));
BT[i]=sc.nextInt();
}
System.out.println("***********************************************");
for(int i=0;i<n;i++)
{
System.out.println("Enter AT for process"+i);
AT[i]=sc.nextInt();
}
System.out.println("***********************************************");
WT[0]=0;
for(int i=1;i<n;i++)
{
WT[i]=WT[i-1]+BT[i-1];
WT[i]=WT[i]-AT[i];
}
for(int i=0;i<n;i++)
{
TAT[i]=WT[i]+BT[i];
AWT=AWT+WT[i];
}
System.out.println("PROCESS BT WT TAT");
for(int i=0;i<n;i++)
{System.out.println(""+ i + ""+BT[i]+""+WT[i]+""+TAT[i]);}
AWT=AWT/n;
System.out.println("***********************************************");
System.out.println("Avg waiting time="+AWT+"\n***********************************************");
}
}
