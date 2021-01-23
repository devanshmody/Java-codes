import java.util.*;
class IPAddress
{
		public static void main(String args[])
		{
			Scanner sc=new Scanner(System.in);
			String address;
                        System.out.println("enter the ip adddress");
			address=sc.next();
			
			int IPVAL=0;
		
		
				String classLevel="";
				for(int i=0;i<3;i++)
				{
					int temp=address.charAt(i);
					if(temp=='.')
						break;
					IPVAL=((IPVAL*10)+(temp-48));
				}
			if(IPVAL<128)
					classLevel="A";
			else if(IPVAL<192)
					classLevel="B";	
			else if(IPVAL<224)
					classLevel="C";
			else if(IPVAL<240)
					classLevel="D";	
			else if(IPVAL<256)
					classLevel="E";	
			else
				classLevel="invalid network ip";
			System.out.print("Class:"+classLevel);	
			
		}
                
}