import java.util.*;
class ID3
{
	public static void main(String args[])
	{
		Random r=new Random();
		
		ArrayList ec= new ArrayList();
		ArrayList vc= new ArrayList();
		ArrayList mc= new ArrayList();
		
		ArrayList wh= new ArrayList();
		ArrayList mh= new ArrayList();
		ArrayList vh= new ArrayList();
		
		ArrayList c= new ArrayList();
		ArrayList h= new ArrayList();
		
		int n[]=new int[100]; 
		int i;
		int cc=0,hc=0,ecc=0,mcc=0,vcc=0,whc=0,mhc=0,vhc=0;	
		double h1=0.0,h2=0,h3=0,h21=0,h22=0,h31=0,h32=0,h33=0,h34=0,h35=0,h36=0;

		for(i=0;i<100;i++)
		{
			n[i]=r.nextInt(48)-10;
			System.out.print(n[i]+"\t");
			
			if(n[i]<18)
			{
				c.add(n[i]);
				cc++;
				
					if(n[i]<0)
					{
						ec.add(n[i]);
						ecc++;
					}
					else if(n[i]>=1 && n[i]<=12)
					{
						vc.add(n[i]);
						vcc++;
					}
					else
					{
						mc.add(n[i]);
						mcc++;
					}
				
			}
			else
			{
				h.add(n[i]);
				hc++;
				
				if (n[i]>=19 && n[i]<=23)
				{
					wh.add(n[i]);
					whc++;
				}
				else if (n[i]>=24 && n[i]<=29)
				{
					mh.add(n[i]);
					mhc++;
				}
				else 
				{
					vh.add(n[i]);
					vhc++;
				}
			}
			
			if(i%10==0)
				System.out.println();
								
		}
			int l=n.length;
			h1=-logCal(1,l);
			
			System.out.println("\n\nH1 : "+h1);
					
			h2=-logCal(cc,l)-logCal(hc,l);
			System.out.println("H2 : "+h2);
h3=-logCal(whc,hc)-logCal(mhc,hc)-logCal(vhc,hc)-logCal(ecc,cc)-   logCal(mcc,cc)-logCal(vcc,cc);	
			System.out.println("H3 : "+h3);
			System.out.println("\nINFORMATION GAIN : "+(h1-h3));
	}
	
	static double logCal(double count,double count2)
	{
		double temp2=count/count2;
		
		double temp1=Math.log(count)-Math.log(count2);
		temp1=temp1/Math.log(2);
	
		temp1=temp1*temp2;
		return temp1;
	}
}

OUTPUT:
--------------------Configuration: <Default>--------------------  
0   23  -6  -5  16  -9  32  -1  -8  34  
10  15  3   4   -1  34  31  5   -9  11  
12  18  23  2   16  22  -6  1   24  4   
11  -8  25  4   16  29  5   -9  16  3   
-8  25  20  22  18  35  -5  17  -1  -7  
8   28  34  -10 -10 21  16  2   12  -7  
9   14  28  32  33  28  5   2   -4  -3  
-8  -6  25  24  -9  5   5   4   9   -9  
16  35  11  26  13  -5  17  4   34  33  
9   36  0   4   16  -8  -4  36  30  -3

H1 : 0.06643856189774726
H2 : 0.9043814577244944
H3 : 3.004872577629973

INFORMATION GAIN : -2.9384340157322257

Process completed.
