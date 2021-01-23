Agglomarative Clustering

Program
import java.io.*;
import java.util.*;

public class Agglomaritive {
    public static void main(String args[])throws IOException{
        int distanceMatrix[][];
        int points[];
        String s[];
        int n=0,minX=0,minY=0,minDistance=99999;
        ArrayList<ArrayList> clusters=new ArrayList<ArrayList>();
        ArrayList<Integer> level=new ArrayList<Integer>();
        ArrayList<Integer> temp;
        ArrayList<ArrayList> cl1;
        ArrayList<ArrayList> t1;
        ArrayList<ArrayList> t2;
        ArrayList<ArrayList> node=new ArrayList<ArrayList>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the points: ");
        s=br.readLine().split(",");
        points=new int[s.length];
        for(int i=0;i<s.length;i++)
            points[i]=Integer.parseInt(s[i]);
        n=s.length;
        System.out.println("Distance Matrix Calculated as: ");
        distanceMatrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                distanceMatrix[i][j]=Math.abs(points[i]-points[j]);
                distanceMatrix[j][i]=distanceMatrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j:distanceMatrix[i])
                System.out.print(j+"\t");
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(distanceMatrix[i][j]<minDistance && distanceMatrix[i][j]!=0){
                    minX=i;
                    minY=j;
                    minDistance=distanceMatrix[i][j];
                }
            }
        }
        
        for(int i=0;i<n;i++){
            temp=new ArrayList<Integer>();
            temp.clear();
            temp.add(points[i]);
            node.add(temp);
        }
        System.out.println();
        while(node.size()!=1){
            minDistance=9999;
            distanceMatrix=new int[node.size()][node.size()];
            for(int i=0;i<node.size();i++){
                for(int j=i;j<node.size();j++){
                    if(i!=j){
                    	
                        int l1=node.get(i).size();
                        int l2=node.get(j).size();
                        int []a1=new int[l1];
                        int []a2=new int[l2];
                        if(l1==1)
                        	a1[0]=(int)node.get(i).get(0);
                        else{
                        	for(int k=0;k<l1;k++){
                        		a1[k]=(int)node.get(i).get(k);
	                        }	
                        }
                        if(l2==1)
                        	a2[0]=(int)node.get(j).get(0);
                        else{
                        	for(int k=0;k<l2;k++){
                        		a2[k]=(int)node.get(j).get(k);
	                        }	
                        }
                        	
                        int dist[]=new int[l1*l2];
                        int minimum=999;
                        int z=0;
                        for(int k=0;k<l1;k++){
                        	for(int m=0;m<l2;m++){
                        		dist[z++]=Math.abs(a1[k]-a2[m]);
                        	}
                        }
                        for(int k=0;k<z;k++){
                        	if(dist[k]<minimum)
                        		minimum=dist[k];
                        }
                        distanceMatrix[i][j]=minimum;
                        distanceMatrix[j][i]=minimum;
                        
                    }
                }
            }
            minX=0;
            minY=0;
            n=node.size();
            for(int i=0;i<n;i++){
            	for(int j=i;j<n;j++){
                	if(distanceMatrix[i][j]<minDistance && distanceMatrix[i][j]!=0){
                    	minX=i;
                    	minY=j;
                    	minDistance=distanceMatrix[i][j];
                	}
            	}
        	}
			System.out.println("Merging "+node.get(minX)+" and "+node.get(minY)+" at Level "+minDistance);
			cl1=new ArrayList<ArrayList>();
      		cl1.add(node.get(minX));
	        cl1.add(node.get(minY));
        	if(minX<minY){
	        	node.remove(minX);
    	    	node.remove(minY-1);
        	}
        	else{
        		node.remove(minX);
        		node.remove(minY);
        	}
	        t1=cl1.get(0);
    	  	t2=cl1.get(1);
	       	for(int i=0;i<t2.size();i++)
    	   		t1.add(t2.get(i));
       		node.add(0,t1);
       		t2=new ArrayList<ArrayList>();
       		for(int i=0;i<t1.size();i++)
       			t2.add(t1.get(i));
       		clusters.add(t2);
			level.add(minDistance);
        }

    }
}

Output

Enter the points: 1,5,8,10,2
Distance Matrix Calculated as: 
0   4   7   9   1   
4   0   3   5   3   
7   3   0   2   6   
9   5   2   0   8   
1   3   6   8   0   

Merging [1] and [2] at Level 1
Merging [8] and [10] at Level 2
Merging [8, 10] and [5] at Level 3
Merging [8, 10, 5] and [1, 2] at Level 3Agglomarative Clustering

Program
import java.io.*;
import java.util.*;

public class Agglomaritive {
    public static void main(String args[])throws IOException{
        int distanceMatrix[][];
        int points[];
        String s[];
        int n=0,minX=0,minY=0,minDistance=99999;
        ArrayList<ArrayList> clusters=new ArrayList<ArrayList>();
        ArrayList<Integer> level=new ArrayList<Integer>();
        ArrayList<Integer> temp;
        ArrayList<ArrayList> cl1;
        ArrayList<ArrayList> t1;
        ArrayList<ArrayList> t2;
        ArrayList<ArrayList> node=new ArrayList<ArrayList>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nEnter the points: ");
        s=br.readLine().split(",");
        points=new int[s.length];
        for(int i=0;i<s.length;i++)
            points[i]=Integer.parseInt(s[i]);
        n=s.length;
        System.out.println("Distance Matrix Calculated as: ");
        distanceMatrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                distanceMatrix[i][j]=Math.abs(points[i]-points[j]);
                distanceMatrix[j][i]=distanceMatrix[i][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j:distanceMatrix[i])
                System.out.print(j+"\t");
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(distanceMatrix[i][j]<minDistance && distanceMatrix[i][j]!=0){
                    minX=i;
                    minY=j;
                    minDistance=distanceMatrix[i][j];
                }
            }
        }
        
        for(int i=0;i<n;i++){
            temp=new ArrayList<Integer>();
            temp.clear();
            temp.add(points[i]);
            node.add(temp);
        }
        System.out.println();
        while(node.size()!=1){
            minDistance=9999;
            distanceMatrix=new int[node.size()][node.size()];
            for(int i=0;i<node.size();i++){
                for(int j=i;j<node.size();j++){
                    if(i!=j){
                    	
                        int l1=node.get(i).size();
                        int l2=node.get(j).size();
                        int []a1=new int[l1];
                        int []a2=new int[l2];
                        if(l1==1)
                        	a1[0]=(int)node.get(i).get(0);
                        else{
                        	for(int k=0;k<l1;k++){
                        		a1[k]=(int)node.get(i).get(k);
	                        }	
                        }
                        if(l2==1)
                        	a2[0]=(int)node.get(j).get(0);
                        else{
                        	for(int k=0;k<l2;k++){
                        		a2[k]=(int)node.get(j).get(k);
	                        }	
                        }
                        	
                        int dist[]=new int[l1*l2];
                        int minimum=999;
                        int z=0;
                        for(int k=0;k<l1;k++){
                        	for(int m=0;m<l2;m++){
                        		dist[z++]=Math.abs(a1[k]-a2[m]);
                        	}
                        }
                        for(int k=0;k<z;k++){
                        	if(dist[k]<minimum)
                        		minimum=dist[k];
                        }
                        distanceMatrix[i][j]=minimum;
                        distanceMatrix[j][i]=minimum;
                        
                    }
                }
            }
            minX=0;
            minY=0;
            n=node.size();
            for(int i=0;i<n;i++){
            	for(int j=i;j<n;j++){
                	if(distanceMatrix[i][j]<minDistance && distanceMatrix[i][j]!=0){
                    	minX=i;
                    	minY=j;
                    	minDistance=distanceMatrix[i][j];
                	}
            	}
        	}
			System.out.println("Merging "+node.get(minX)+" and "+node.get(minY)+" at Level "+minDistance);
			cl1=new ArrayList<ArrayList>();
      		cl1.add(node.get(minX));
	        cl1.add(node.get(minY));
        	if(minX<minY){
	        	node.remove(minX);
    	    	node.remove(minY-1);
        	}
        	else{
        		node.remove(minX);
        		node.remove(minY);
        	}
	        t1=cl1.get(0);
    	  	t2=cl1.get(1);
	       	for(int i=0;i<t2.size();i++)
    	   		t1.add(t2.get(i));
       		node.add(0,t1);
       		t2=new ArrayList<ArrayList>();
       		for(int i=0;i<t1.size();i++)
       			t2.add(t1.get(i));
       		clusters.add(t2);
			level.add(minDistance);
        }

    }
}

Output

Enter the points: 1,5,8,10,2
Distance Matrix Calculated as: 
0   4   7   9   1   
4   0   3   5   3   
7   3   0   2   6   
9   5   2   0   8   
1   3   6   8   0   

Merging [1] and [2] at Level 1
Merging [8] and [10] at Level 2
Merging [8, 10] and [5] at Level 3
Merging [8, 10, 5] and [1, 2] at Level 3
