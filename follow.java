import java.util.*;
import java.io.*;
public class follow {
static char ntrmnl[],trmnl[];
static int ntlen,tlen;
static String grmr[][],fst[],flw[];
    public static void main(String[] args) {
        String nt,t;
        int i,j,n;
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the non terminal");
        nt=sc.next();
        ntlen=nt.length();
        ntrmnl= new char[ntlen];
        ntrmnl=nt.toCharArray();
        System.out.println("enter the terminal");
        t=sc.next();
        tlen=t.length();
        trmnl=new char[tlen];
        trmnl=t.toCharArray();
        System.out.println("Specify the grammar(enter 9 for eps)");
        grmr=new String[ntlen][];
        for(i=0;i<ntlen;i++)
        {
            System.out.println("enter no of productions for" +ntrmnl[i]);
            n=Integer.parseInt(sc.next());
            grmr[i]=new String[n];
            System.out.println("enter the productions");
            for(j=0;j<n;j++)
                grmr[i][j]=sc.next();
        }
        fst=new String[ntlen];
        for(i=0;i<ntlen;i++)
            fst[i]=first(i);
        flw=new String[ntlen];
        for(i=0;i<ntlen;i++)
            flw[i]=follow(i);
        System.out.println("Follow set");
        for(i=0;i<ntlen;i++)
            System.out.println(removeDup(flw[i]));


    }
    static String follow(int i)
    {
        char pro[],chr[];
        String temp="";
        int j,k,l,m,n,found=0;
        if(i==0)
            temp="$";
        for(j=0;j<ntlen;j++)
        {
            for(k=0;k<grmr[j].length;k++)
            {
                pro=new char[grmr[j][k].length()];
                pro=grmr[j][k].toCharArray();
                for(l=0;l<pro.length;l++)
                {
                    if(pro[l]==ntrmnl[i])
                    {
                        if(l==pro.length-1)
                        {
                            if(j<1)
                                temp=temp+flw[j];
                        }
                        else
                        {
                            for(m=0;m<ntlen;m++)
                            {
                                if(pro[l+1]==ntrmnl[m])
                                {
                                    chr=new char[fst[m].length()];
                                    chr=fst[m].toCharArray();
                                    for(n=0;n<chr.length;n++)
                                    {
                                        if(chr[n]=='9')
                                        {
                                        if(l+1==pro.length-1)
                                            temp=temp+follow(j);
                                        else
                                            temp=temp+follow(m);
                                    }
                                   else
                                        temp=temp+chr[n];
                                }
                                    found=1;
                            }
                        }
                            if(found!=1)
                                temp=temp+pro[l+1];
                    }
                }
            }
        }
    }
        return temp;
    }
    static String first(int i)
    {
        int j,k,l=0,found=0;
        String temp="",str="";
        for(j=0;j<grmr[i].length;j++)
        {
            for(k=0;k<grmr[i][j].length();k++,found=0)
            {
                for(l=0;l<ntlen;l++)
                {
                    if(grmr[i][j].charAt(k)==ntrmnl[l])
                    {
                        str=first(l);
                        if(!(str.length()==1 && str.charAt(0)=='9'))
                            temp=temp+str;
                        found=1;
                        break;
                    }
                }
                if(found==1)
                {
                    if(str.contains("9"))
                        continue;
                }
                else
                    temp=temp+grmr[i][j].charAt(k);
                break;
            }
        }
        return temp;
    }
    static String removeDup(String str)
    {
        int i;
        char ch;
        boolean seen[]=new boolean[256];
        StringBuilder sb= new StringBuilder(seen.length);
        for(i=0;i<str.length();i++)
        {
            ch=str.charAt(i);
            if(!seen[ch])
            {
                seen[ch]=true;
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}