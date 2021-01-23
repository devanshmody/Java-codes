//0 2 1 0 0 0 2 1 1 0 1 2 1 0 1 2 1 1 0 1 2 0 0 0 1 2 0 0 1 0 1 0 0 1 1 0 1 1 0 0 0 0 0 0 1 2 1 0 0 1 0 1 0 1 1 1 1 1 1 1 1 2 0 0 1 2 1 1 1 0
import java.util.*;
import java.io.*;
class DTree{
	public static void main(String args[]){
		double log2=Math.log(2);
		int i,j;
		double syes=0,sno=0,sun=0,over=0,ono=0,oyes=0,rain=0,ryes=0,rno=0;
		double gain[]=new double[10];
		int table[][]=new int[14][5];
		Scanner sc=new Scanner(System.in);
		for(i=0;i<14;i++){
			for(j=0;j<5;j++)
				table[i][j]=sc.nextInt();
		}
		for(int k=0;k<4;k++){
			syes=0;sno=0;sun=0;over=0;ono=0;oyes=0;rain=0;ryes=0;rno=0;
			for(i=0;i<14;i++){
				if(table[i][k]==0){
					sun++;
					if(table[i][4]==1)
						syes++;
					else
						sno++;
				}
				
				if(table[i][k]==2){
					rain++;
					if(table[i][4]==1)
						ryes++;
					else
						rno++;
				}
			}
			double eover=45,esun=45,erain=45;
			if(sno==0 || syes==0)
				esun=0;
		
			else
				erain=(-1*rno/rain*(Math.log(rno/rain)/log2))+(-1*ryes/rain*(Math.log(ryes/rain)/log2));
			//System.out.print(esun+" "+eover+" "+erain+"\n");
			double avenout=(sun/14*esun)+(over/14*eover)+(rain/14*erain);
			//System.out.print("Average Entropy: "+avenout+"\n");
			double yes=syes+oyes+ryes;
			
			//System.out.print(" Information Gain: "+gain[k]+"\n");
		}
		double max=0,temp=0;
		for(i=0;i<4;i++){
			if(max<gain[i]){
				max=gain[i];
				temp=i;
			}
		}
		if(temp==0)
			System.out.print("\tOutlook\n Sunny Overcast Rain\n");
		else if(temp==1)
			System.out.print("\tTemperature\n High Medium Cold\n");
		else if(temp==2)
			System.out.print("\tHumidity\n Hig Medium Low\n");
		else if(temp==3)
			System.out.print("\tWind\n Weak Strong\n");
		double tsun=0;
		for(int k=1;k<4;k++){
			syes=0;sno=0;sun=0;over=0;ono=0;oyes=0;rain=0;ryes=0;rno=0;tsun=0;
			for(i=0;i<14;i++){
				if(table[i][0]==0){
					tsun++;
					if(table[i][k]==0){
						sun++;
					if(table[i][4]==1)
						syes++;
					else
						sno++;
					}
				
					else
						ono++;
					}
					if(table[i][k]==2){
						rain++;
					if(table[i][4]==1)
						ryes++;
					else
						rno++;
					}
				}
			}
			double eover=45,esun=45,erain=45;
			if(sno==0 || syes==0)
				esun=0;
			else
			ono/over)/log2))+(-1*oyes/over*(Math.log(oyes/over)/log2));
			if(rno==0 || ryes==0)
				erain=0;
			else
				erain=(-1*rno/rain*(Math.log(rno/rain)/log2))+(-1*ryes/rain*(Math.log(ryes/rain)/log2));
			//System.out.print(esun+" "+eover+" "+erain+"\n");
			double avenout=(sun/tsun*esun)+(over/tsun*eover)+(rain/tsun*erain);
			//System.out.print("Average Entropy: "+avenout+"\n");
			double yes=syes+oyes+ryes;
			double no=sno+ono+rno;
			double es=(-1*no/tsun*(Math.log(no/tsun)/log2))+(-1*yes/tsun*(Math.log(yes/tsun)/log2));
			gain[k]=es-avenout;
			//System.out.print(" Information Gain: "+gain[k]+"\n");
		}
		max=0;temp=0;
		for(i=1;i<4;i++){
			if(max<gain[i]){
				max=gain[i];
				temp=i;
			}
		}
		if(temp==1)
			System.out.print("Temperature");
		else if(temp==2)
			System.out.print("Humidity");
		else if(temp==3)
			System.out.print("Wind");
		for(int k=1;k<4;k=k+2){
			syes=0;sno=0;sun=0;over=0;ono=0;oyes=0;rain=0;ryes=0;rno=0;tsun=0;
			for(i=0;i<14;i++){
				if(table[i][0]==2){
					tsun++;
					if(table[i][k]==0){
						sun++;
					if(table[i][4]==1)
						syes++;
					else
						sno++;
					}
					if(table[i][k]==1){
						over++;
					
					}
					if(table[i][k]==2){
						rain++;
					if(table[i][4]==1)
						ryes++;
					else
						rno++;
					}
				}
			}
			double eover=45,esun=45,erain=45;
			if(sno==0 || syes==0)
				esun=0;
			else
				esun=(-1*sno/sun*(Math.log(sno/sun)/log2))+(-1*syes/sun*(Math.log(syes/sun)/log2));
			if(ono==0 || oyes==0)
				eover=0;
			else
				eover=(-1*ono/over*(Math.log(ono/over)/log2))+(-1*oyes/over*(Math.log(oyes/over)/log2));
			if(rno==0 || ryes==0)
				erain=0;
			
			//System.out.print(esun+" "+eover+" "+erain+"\n");
			double avenout=(sun/tsun*esun)+(over/tsun*eover)+(rain/tsun*erain);
			//System.out.print("Average Entropy: "+avenout+"\n");
			double yes=syes+oyes+ryes;
			double no=sno+ono+rno;
		
			gain[k]=es-avenout;
			//System.out.print(" Information Gain: "+gain[k]+"\n");
		}
	
		if(temp==1)
			System.out.print("\t\tTemperature\n");
		else if(temp==3)
			System.out.print("\t\tWind\n");
	}
}