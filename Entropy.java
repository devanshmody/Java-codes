package decision;
import java.lang.*;
import java.util.*;
import java.math.*;

public class Entropy {
 public static void main(String[] args) {
        		String data[][]=new String[100][100];
		int i=0,j=0,n=0,n1=0,nclass=0,k=0;
                double t=0,tl=0,t1=0,tl1=0,ig=0;
                int pc=0,nc=0;
                String parameter[]=new String[10];
                String vclass[]=new String[10];
                String par;
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER THE TOTAL NUMBER OF RECORDS TO BE ENTERED:");
		n=sc.nextInt();
		System.out.println("ENTER THE TOTAL NUMBER OF PARAMETERS TO BE CONSIDERED:");
		n1=sc.nextInt();
                System.out.println("ENTER WHICH PARAMETERS TO BE CONSIDERED:");
                for(i=0;i<n1;i++)
                {
                    parameter[i]=sc.next();

                }
                 System.out.println("FOR WHICH PARAMETER INFORMATION GAIN IS TO BE CONSIDERED:");
                 par=sc.next();
                 //System.out.println("ENTER NUMBER OF UNIQUE CLASS VALUES :");
                // nclass=sc.nextInt();
                 System.out.println("ENTER UNIQUE CLASS VALUES TO BE CONSIDERED :");
                 for(i=0;i<2;i++)
                 {
                     vclass[i]=sc.next();
                 }
                 System.out.println("ENTER DATA SET TO BE CONSIDERED :");
		for(i=0;i<n;i++)
		{
			for(j=0;j<n1;j++)
                        {p
                        	
                           data[i][j]=sc.next();
                        }

		}
                for(i=0;i<n1;i++)
                {
                    if(par.equals(parameter[i]))
                    {
                        for(j=0;j<n;j++)
                        {
                            
                                if((data[j][i]).equals(vclass[0]))
                                {
                                    pc=pc+1;
                                }
                                else
                                    nc=nc+1;
                        }
                    }
                }
                 System.out.println(pc + " "+nc);
                 t=pc/(n);
                 System.out.println(t);
                 tl=Math.log(t);
                 System.out.println(tl);
                 t1=nc/(n);
                 System.out.println(t1);
                 tl1=Math.log(t1);
                 System.out.println(tl1);
                 ig=(-(t*tl)-(tl*tl1));
                 System.out.println("CONSIDERED DATA SET IS:");
                 for(i=0;i<n;i++)
                 {n
                 	
                     for(j=0;j<n1;j++)
                     {
                         System.out.print("\t"+data[i][j]);
                     }
                     System.out.println();
                 }
                 System.out.println("INFORMATION GAIN FOR"+" "+par+" IS:"+ig);



    }

}

