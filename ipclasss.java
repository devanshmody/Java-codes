import java.lang.*;
import  java.io.*;
class ipclasss
{
	public static void main(String args[])throws Exception
	{
		int ip[]=new int[4];
		int i=0,j=0,k=0,remainder;
		String bin;
		while(j!=3)
		{
			while(i<args[0].length() && args[0].charAt(i++) =='.')
			{
				ip[j++]=Integer.parseInt(args[0].substring(k,i-1));
				k=i;
			}
		}
		ip[j++]=Integer.parseInt(args[0].substring(k,args[0].length()));
		if(ip[0] >-1 &&ip[0] < 256 && ip[1] > -1 && ip[1] < 256 && ip[2] > -1 && ip[2] < 256 && ip[3] > -1 && ip[3] < 256)
		{
			System.out.println("Ip is valid");
			bin=Integer.toBinaryString(ip[0]);
			if(bin.charAt(0)=='0')
			{
				System.out.println("The Ip entered is a Class A Address");
				System.out.println("Net ID :- "+ip[0]);
				System.out.println("Host ID :- "+ip[1]+"."+ip[2]+"."+ip[3]);
			}
			else
			{
				if(bin.charAt(1)=='0')
				{
					System.out.println("The Ip entered is a Class B Address");
					System.out.println("Net ID :- "+ip[0]+"."+ip[1]);
					System.out.println("Host ID :- "+ip[2]+"."+ip[3]);
				}
				else
				{
					if(bin.charAt(2)=='0')
					{
						System.out.println("The Ip entered is a Class C Address");
						System.out.println("Net ID :- "+ip[0]+"."+ip[1]+"."+ip[2]);
						System.out.println("Host ID :- "+ip[3]);
					}
					else
					{
						if(bin.charAt(3)=='0')
							System.out.println("The Ip entered is a Class D Address");
						else
							System.out.println("The Ip entered is a Class E Address");
					}
				}
			}
		}
		else
			System.out.println("Ip is invalid");
	}
}
