/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwm;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sakec
 */
public class KMean2D
{
    @SuppressWarnings("empty-statement")
    public static void main(String args[])
    {

        float input[][],adjmat[][],clustercentroid[][],grpmat[][],temp[][],tempgrp[][];
        int n,i,j,cnt,cnt1,cluster1[],cluster2[];
        boolean flag=true;
        float c1x,c1y,c2x,c2y;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of inputs=");
        n=sc.nextInt();
        input=new float[n][2];
        adjmat=new float[n][n];
        clustercentroid=new float[2][2];
        grpmat=new float[2][n];
        temp=new float[2][n];
        tempgrp=new float[2][n];
        for(i=0;i<n;i++)
        {
            System.out.print("Enter the input coordinates for point "+(i+1)+"=");
            for(j=0;j<2;j++)
            {
                input[i][j]=sc.nextFloat();
            }
        }
        for(i=0;i<n;i++)
        {
            float tempx=input[i][0];
            float tempy=input[i][1];
            for(j=0;j<n;j++)
            {
                adjmat[i][j]=(float)Math.sqrt(Math.pow(tempx-input[j][0], 2)+Math.pow(tempy-input[j][1], 2));
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.printf("%.2f\t",adjmat[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nRandomly Slected points");
        for(i=0;i<2;i++)
        {
            int temp1=0,rnd;
            do
            {
                rnd = new Random().nextInt(n);
            }
            while(temp1==rnd);
            System.out.print((rnd+1)+"\t");
            temp1=rnd;
            for(j=0;j<2;j++)
            {
                clustercentroid[i][j]=input[rnd][j];
                System.out.print(clustercentroid[i][j]+"\t");
                //clustercentroid[1][j]=input[2][j];
            }
            System.out.println();
        }

        
            for(i=0;i<2;i++)
            {
                float tempx=clustercentroid[i][0];
                float tempy=clustercentroid[i][1];
                for(j=0;j<n;j++)
                {
                    temp[i][j]=(float)Math.sqrt(Math.pow(tempx-input[j][0], 2)+Math.pow(tempy-input[j][1], 2));
                }
            }
            System.out.println("\nDistance MAtrix from Centroid");
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    System.out.print(temp[i][j]+"\t");
                }
                System.out.println();
            }
            for(j=0;j<n;j++)
            {
                if(temp[0][j]<=temp[1][j])
                    grpmat[0][j]=1;
                else
                    grpmat[1][j]=1;
            }
            System.out.println("\nGroup Matrix");
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    System.out.print(grpmat[i][j]+"\t");
                }
                System.out.println();
            }
        do
        {
            flag=true;
            c1x=c1y=c2x=c2y=(float)0.0;
            cnt=0;
            cnt1=0;
            
            for(j=0;j<n;j++)
            {
                if(grpmat[0][j]==1.0)
                {
                    cnt++;
                    c1x+=input[j][0];
                    c1y+=input[j][1];
                }
                else if(grpmat[1][j]==1.0)
                {
                    cnt1++;
                    c2x+=input[j][0];
                    c2y+=input[j][1];
                }
            }
            clustercentroid[0][0]=c1x/cnt;
            clustercentroid[0][1]=c1y/cnt;
            clustercentroid[1][0]=c2x/cnt1;
            clustercentroid[1][1]=c2y/cnt1;
            System.out.println("\nNew Centroids");
            for(i=0;i<2;i++)
            {
                System.out.print("C"+(i+1)+" = "+"\t");
                for(j=0;j<2;j++)
                {
                    System.out.print(clustercentroid[i][j]+"\t");
                }
                System.out.println();
            }
            for(i=0;i<2;i++)
            {
                float tempx=clustercentroid[i][0];
                float tempy=clustercentroid[i][1];
                for(j=0;j<n;j++)
                {
                    temp[i][j]=(float)Math.sqrt(Math.pow(tempx-input[j][0], 2)+Math.pow(tempy-input[j][1], 2));
                }
            }
            System.out.println("\nDistance MAtrix from Centroid");
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    System.out.print(temp[i][j]+"\t");
                }
                System.out.println();
            }
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    tempgrp[i][j]=grpmat[i][j];
                }
            }
            grpmat=resetmat(grpmat,2,n);
            for(j=0;j<n;j++)
            {
                if(temp[0][j]<=temp[1][j])
                    grpmat[0][j]=1;
                else
                    grpmat[1][j]=1;
            }
            System.out.println("\nGroup Matrix");
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    System.out.print(grpmat[i][j]+"\t");
                }
                System.out.println();
            }
            for(i=0;i<2;i++)
            {
                for(j=0;j<n;j++)
                {
                    if(tempgrp[i][j]!=grpmat[i][j])
                        flag=false;
                }
            }
        }while(!flag);
        cluster1=new int[cnt];
        cluster2=new int[cnt1];
        cnt=cnt1=0;
        for(j=0;j<n;j++)
        {
                if(grpmat[0][j]==1)
                {
                    cluster1[cnt]=j+1;
                    cnt++;
                }
                else if(grpmat[1][j]==1)
                {
                    cluster2[cnt1]=j+1;
                    cnt1++;
                }
        }
        System.out.print("\nCluster1 = ");
        for(i=0;i<cnt;i++)
            System.out.print(cluster1[i]+"\t");
        System.out.print("\nCluster2 = ");
        for(i=0;i<cnt1;i++)
            System.out.print(cluster2[i]+"\t");
    }
    public static float[][] resetmat(float a[][],int m,int n)
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=(float)0.0;
            }
        }
        return a;
    }
}
