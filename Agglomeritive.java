package agglomeritive;

/**
 *
 * @author sakec
 */
public class Agglomeritive {

    /**
     * @param args the command line arguments
     */
    static double ecl[][];
    static String names[];
    public static void main(String[] args) {
        		java.util.Scanner sc=new java.util.Scanner(System.in);
		double a[][]={{0.4,0.53},{0.22,0.38},{0.35,0.32},{0.26,0.19},{0.08,0.41},{0.45,0.30}};
		names=new String[a.length];
                for(int i=0;i<a.length;i++)
		{
			
				System.out.println("P"+i+" "+a[i][0]+" "+a[i][1]);
                                names[i]="P"+i;
			
		}
		ecl=new double[a.length][a.length];
                
                    
		double min=9999;
		int m1=-99,m2=-99;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<ecl.length;j++)
				{
					ecl[i][j]=Math.pow((Math.pow(a[i][0]-a[j][0],2)+Math.pow(a[i][1]-a[j][1],2)),0.5);
					System.out.print(Math.round(ecl[i][j] * 100D) / 100D+" ");
					if(min>ecl[i][j]&&ecl[i][j]!=0)
					{
						min=ecl[i][j];
						m1=i;
						m2=j;
															

					}
				}
                        
			System.out.println();
		}
                System.out.println("MINIMUM="+Math.round(min * 100D) / 100D+" ");
		
                
                for(int t=0;t<5;t++) 
                {
                    System.out.println("--------Iteration "+t+"----------");
                    updateTable(m1,m2,min);
                    printTable(ecl);
                   min=9999;
		//int m1=-99,m2=-99;
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<ecl.length;j++)
				{
					//ecl[i][j]=Math.pow((Math.pow(a[i][0]-a[j][0],2)+Math.pow(a[i][1]-a[j][1],2)),0.5);
					//System.out.print(Math.round(ecl[i][j] * 100D) / 100D+" ");
					if(min>ecl[i][j]&&ecl[i][j]!=0)
					{
						min=ecl[i][j];
						m1=i;
						m2=j;
															

					}
				}
                        
			//System.out.println();
		}
                    System.out.println("MINIMUM="+Math.round(min * 100D) / 100D+" ");
                }
                
                
                
                
    }

    private static void updateTable(int m1, int m2, double min) {
            System.out.println(names[m1]+" and "+names[m2]+ " will be merged");
            
            names[m1]=names[m1]+names[m2];
            names[m2]=null;
            ecl[m1][m2]=0;
            for(int i=0;i<ecl.length;i++)
            {
                ecl[m2][i]=0;
                ecl[m1][i]=min(ecl[i][m1],ecl[i][m2]);
            }
            
    
    }

    private static double min(double ecl, double ecl0) {
        if(ecl>ecl0)return ecl0;
        return ecl;
    }

    private static void printTable(double[][] ecl) {
        for(int i=0;i<ecl.length;i++)
		{
                    System.out.print(names[i]+" " );
			for(int j=0;j<=i;j++)
				{
					
					System.out.print(Math.round(ecl[i][j] * 100D) / 100D+" ");
                                }
                        System.out.println();
                }
    }
    
}
