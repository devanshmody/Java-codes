import java.util.*;
class Kmeans{
	public static void main(String args[]){
		float data[]=new float[10];
		float mean[]=new float[5];
		float cluster[][]=new float[10][10];
		int n,c,i,j,k=0;
		float sum=0,diff;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter number of data objects: ");
		n=sc.nextInt();
		System.out.print("Enter number of clusters: ");
		c=sc.nextInt();
		System.out.print("Enter data objects: ");
		for(i=0;i<n;i++){
			data[i]=sc.nextFloat();
		}
		for(i=0;i<c;i++){
			mean[i]=data[i];
		}
		for(int z=0;z<5;z++){
			for(i=0;i<n;i++){
				diff=999;
				for(j=0;j<c;j++){
					if(diff>Math.abs(mean[j]-data[i])){
						diff=Math.abs(mean[j]-data[i]);
					}
					else
						break;
				}
				cluster[i][j-1]=data[i];
			}
			for(i=0;i<c;i++){
				System.out.print("Cluster "+(i+1)+": ");
				for(j=0;j<n;j++){
					if(cluster[j][i]!=0)
						System.out.print(cluster[j][i]+" ");		
				}
				System.out.print("\n");
			}
			for(i=0;i<c;i++){
				sum=0;
				k=0;
				for(j=0;j<n;j++){
					if(cluster[j][i]!=0){
						sum=sum+cluster[j][i];
						k++;
					}
				}
				mean[i]=sum/k;
			}
			for(i=0;i<c;i++){
				for(j=0;j<n;j++)
					cluster[j][i]=0;		
			}
		}
	}
}