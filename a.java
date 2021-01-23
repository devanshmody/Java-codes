/*/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dwm;

import java.util.Scanner;

/**
 *
 * @author sakec
 */
public class a
{
    static int loc1,loc2;
    public static void main(String args[])
    {
        float input[][],adjmat[][],temp[][],min;
        int n,i,j,n1;
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the number of inputs=");
        n1=n=sc.nextInt();
        input=new float[n][2];
        adjmat=new float[n][n];
        temp=new float[n][n];
        for(i=0;i<n;i++)
        {
            System.out.print("Enter the input coordinates for point "+(i+1)+"=");
            for(j=0;j<2;j++)
            {
                input[i][j]=sc.nextFloat();
            }
        }
        temp=adjmat=calculateAdjacency(input,n);

        System.out.println("\nInitial Adjacency Matrix");
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.printf("%.2f\t",adjmat[i][j]);
            }
            System.out.println();
        }
        min=findMinLoc(adjmat,n);
        System.out.println(min+"\t"+loc1+"\t"+loc2);
        n1=n1-1;
        temp=resetmat(temp,n);
        for(i=0;i<n1;i++)
        {
            for(j=0;j<n1;j++)
            {
                if(i!=loc1)
                {
                    temp[i][j]=adjmat[i][j];
                }
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.printf("%.2f\t",temp[i][j]);
            }
            System.out.println();
        }
    }
    public static float[][] calculateAdjacency(float input[][],int n)
    {
        int i,j;
        float a[][]=new float[n][n];
        for(i=0;i<n;i++)
        {
            float tempx=input[i][0];
            float tempy=input[i][1];
            for(j=0;j<n;j++)
            {
                a[i][j]=(float)Math.sqrt(Math.pow(tempx-input[j][0], 2)+Math.pow(tempy-input[j][1], 2));
            }
        }
        return a;
    }
    public static float findMinLoc(float a[][],int n)
    {
        int i,j;
        boolean flag=false;
        float min=a[1][2];
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]!=0.0)
                    if(a[i][j]<=min)
                        min=a[i][j];
            }
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]==min)
                {
                    loc1=i;
                    loc2=j;
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
        }
        return min;
    }
    public static float[][] resetmat(float a[][],int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                a[i][j]=(float)0.0;
            }
        }
        return a;
    }
}
