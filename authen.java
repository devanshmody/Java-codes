import java.util.*;
class authen
{
	public static void main(String args[])
	{
		Boolean valid=true;
		Scanner sc=new Scanner(System.in);
		System.out.println("LoginID");
		String login=sc.nextLine();
		System.out.println("");
		System.out.println("Password");
		String password=sc.nextLine();
		if(password.length() < 8)
		{
			System.out.println("Password should be greater than 8 characters");
			valid=false;
		}
			if(valid)
			{
				String upper="(.*[A-Z].*)";
				String lower="(.*[a-z].*)";
				String number="(.*[0-9].*)";
				if(password.length() > 8 && password.matches(lower) && !password.matches(upper) && !password.matches(number))
					System.out.println("Weak password");
				else if(password.length() > 8 && !password.matches(lower) && password.matches(upper) && !password.matches(number))
					System.out.println("Weak password");
				else if(password.length() > 8 && !password.matches(lower) && !password.matches(upper) && password.matches(number))
					System.out.println("Weak password");
				else if(password.length() > 8 && password.matches(lower) && password.matches(upper) && !password.matches(number))
					System.out.println("Medium password");
				else if(password.length() > 8 && !password.matches(lower) && password.matches(upper) && password.matches(number))
					System.out.println("Medium password");
				else if(password.length() > 8 && password.matches(lower) && !password.matches(upper) && password.matches(number))
					System.out.println("Medium password");
				else
					System.out.println("Strong password");
			}
	   }
}