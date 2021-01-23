import java.io.*;
import java.util.*;
import java.text.*;

public class id3{
	static NumberFormat nf=NumberFormat.getNumberInstance();
	public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		nf.setMaximumFractionDigits(3);
		Object obj[];
		ArrayList<String> temp;
		String s[];
		String data[][];
		String aName[];
		int n,a;
		System.out.print("\nEnter the number of instances: ");
		n=Integer.parseInt(br.readLine());
		System.out.print("\nEnter the number of attributes: ");
		a=Integer.parseInt(br.readLine());
		data=new String[n][a];
		obj=new Object[a];
		aName=new String[a];
		for(int i=0;i<a;i++)
			obj[i]=new ArrayList<String>();
		System.out.print("\nEnter the value of attributes: ");
		s=br.readLine().split(" ");
		for(int i=0;i<a;i++)
			aName[i]=s[i];
		System.out.println("\nEnter the values of instances: ");
		for(int i=0;i<n;i++){
			System.out.print("Instance "+(i+1)+": ");
			s=br.readLine().split(" ");
			for(int j=0;j<a;j++){
				temp=(ArrayList<String>)obj[j];
				data[i][j]=s[j];
				if(!temp.contains(s[j]))
					temp.add(s[j]);
			}
		}
		System.out.print("\nData generated:");
		for(int i=0;i<n;i++){
			System.out.print("\n"+(i+1));
			for(int j=0;j<a;j++)
				System.out.print(" "+data[i][j]);
		}
		System.out.println();
		generateTree(n,a,aName,data,0);
	}
	static int getMax(float gain[]){
		int large=0;
		for(int i=0;i<gain.length;i++){
			if(gain[large]<gain[i])
				large=i;
		}
		return large;
	}
	static void generateTree(int n,int a,String aName[], String data[][],int q){
		Object obj[]=new Object[a];
		ArrayList<String> temp;
		String subset[][];
		String subAName[];
		int pn[];
		String s[];
		float targetEntropy=0.0f;
		float gain[];
		
		for(int i=0;i<a;i++)
			obj[i]=new ArrayList<String>();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<a;j++){
				temp=(ArrayList<String>)obj[j];
				if(!temp.contains(data[i][j]))
					temp.add(data[i][j]);
			}
		}
		temp=(ArrayList<String>)obj[a-1];
		s=new String[temp.size()];
		for(int i=0;i<s.length;i++)
			s[i]=temp.get(i);
if(s.length!=1){
			pn=calTarget(n,a-1,s,data);
			targetEntropy=calEntropy(pn);
			System.out.println("\nEntropy: "+targetEntropy);
			gain=calGain(n,a,targetEntropy,aName,s,data);
			int l=getMax(gain);
			temp=(ArrayList<String>)obj[l];
			int z=temp.size();
			String m=aName[l];
			if(q==0){
				System.out.println("\n\nAttribute "+m.toUpperCase()+" is choosen as a Root Node\n");
				q=1;
			}
			else System.out.println("\n\nAttribute "+m.toUpperCase()+" is choosen as a Decision Node\n");
			for(int i=0;i<z;i++){
				subset=generateData(n,a,l,temp.get(i),data);
				String h=temp.get(i);
				System.out.print("Considering the value "+h.toUpperCase()+" of attribute "+m.toUpperCase());
				subAName=calName(l,subset[0].length,aName);
				int nn=subset.length;
				int na=subset[0].length;
				generateTree(nn,na,subAName,subset,q);
			}
			System.out.println("\n");
		}
		else{
			System.out.println("\n"+aName[a-1]+": "+s[0]);
			
		}	
	}
	static String[][] generateData(int n, int a, int l, String temp, String data[][]){
		int count=0;
		for(int i=0;i<n;i++){
			if(temp.equalsIgnoreCase(data[i][l]))
				count++;
		}
		String subset[][]=new String[count][a-1];
		int s=0,c=0;
		for(int i=0;i<n;i++){
			s=0;
			if(temp.equalsIgnoreCase(data[i][l])){
				
				for(int j=0;j<a;j++){
					if(j!=l)
					subset[c][s++]=data[i][j];
				}
				c++;
			}
		}
		return subset;
	}
	static String [] calName(int l,int a,String name[]){
		String s[]=new String[a];
		int c=0;
		for(int i=0;i<name.length;i++){
			if(i!=l){
				s[c++]=name[i];
			}
		}
		return s;
	}
	static int[] calTarget(int n,int k, String s[],String data[][]){
		int l=s.length;
		int pn[]=new int[l];
		for(int i=0;i<n;i++){
			for(int j=0;j<l;j++){
				if(s[j].equalsIgnoreCase(data[i][k])){
					pn[j]++;
					break;
				}
			}
		}
		return pn;
	}
	static float calEntropy(int pn[]){
		float prob[]=new float[pn.length];
		int sum=0;
		float result=0.0f;
		int l=pn.length;
		for(int i=0;i<l;i++)
			sum+=pn[i];
		
		for(int i=0;i<l;i++)
			prob[i]=(float)pn[i]/sum;
		
		for(int i=0;i<l;i++){
			if(prob[i]!=0)
				result+=(-prob[i]*(float)(Math.log(prob[i])/Math.log(2)));
		}
		result=Float.parseFloat(nf.format(result));
		return result;
	}
	static float[] calGain(int n, int a, float targetEntropy, String aName[], String s[],String data[][]){
		int count[];
		float entropy[];
		int pn[];
		TreeSet<String> tr=new TreeSet<String>();
		float EH[]=new float[a-1];
		float gain[]=new float[a-1];
		for(int i=0;i<a-1;i++){
			tr.clear();
			System.out.println("\nFor Attribute "+aName[i]+": ");
			for(int j=0;j<n;j++)
				tr.add(data[j][i]);
			count=new int[tr.size()];
			entropy=new float[count.length];
			for(int j=0; j<count.length ;j++){
				String temp=tr.pollFirst();
				pn=new int[s.length];
				for(int k=0;k<n;k++){
					if(data[k][i].equals(temp)){
						count[j]++;
						for(int m=0;m<s.length;m++){
							if(s[m].equalsIgnoreCase(data[k][a-1])){
								pn[m]++;
								break;
							}
						}
					}
				}
				entropy[j]=calEntropy(pn);
				System.out.println(temp+"\t\t"+entropy[j]);
			}
			EH[i]=expectedEntropy(entropy,count,n);
			gain[i]=Float.parseFloat(nf.format(targetEntropy-EH[i]));
			System.out.println("Expected Entropy:\t"+EH[i]);
			System.out.println("Information Gain:\t"+gain[i]);
		}
		return gain;
	}
	static float expectedEntropy(float entropy[],int count[],int n){
		float result=0.0f;
		float prob=0.0f;
		for(int i=0;i<count.length;i++){
			prob=(float)count[i]/n;
			result+=(prob*entropy[i]);
		}
		result=Float.parseFloat(nf.format(result));
		return result;
	}
	
}
