import java.util.*;

class bayseian
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String age[]={"y","y","m","s","s","s","m","y","y","s","y","m","m","s"};
		String income[]={"h","h","h","me","l","l","l","me","l","me","me","me","h","me"};
		String student[]={"n","n","n","n","y","y","y","n","y","y","y","n","y","n"};
		String credit[]={"f","e","f","f","f","e","e","f","f","f","e","e","f","e"};
		String outcome[]={"no","no","yes","yes","yes","no","yes","no","yes","yes","yes","yes","yes","no"};
		int yes_count=0,countCreditYes=0,countCreditNo=0,no_count=0,countAgeYes=0,countAgeNo=0,countIncomeYes=0,countIncomeNo=0,countStudentYes=0,countStudentNo=0;
		for(int i=0;i<14;i++)
		{
			if(outcome[i].contains("yes"))
				yes_count++;
				
			if(outcome[i].contains("no"))
				no_count++;
			if(age[i].contains("y")&&(outcome[i].contains("yes")))
				countAgeYes++;
			if(age[i].contains("y")&&(outcome[i].contains("no")))
				countAgeNo++;
			if(income[i].contains("y")&&(outcome[i].contains("yes")))
				countIncomeYes++;
			if(income[i].contains("y")&&(outcome[i].contains("no")))
				countIncomeNo++;
			if(student[i].contains("y")&&(outcome[i].contains("yes")))
				countStudentYes++;
			if(student[i].contains("y")&&(outcome[i].contains("yes")))
				countStudentNo++;
			if(credit[i].contains("f")&&(outcome[i].contains("yes")))	
				countCreditYes++;
			if(credit[i].contains("f")&&(outcome[i].contains("no")))
				countCreditNo++;			
		}
		System.out.println("yes count is  "+yes_count+" no count is  "+no_count);
		float buys_compy=(yes_count)/14;
		float buys_compn=(no_count)/14;
		float ageYes= countAgeYes/(yes_count);
		float ageNo=countAgeNo/(no_count);
		float incomeYes=countIncomeYes/(yes_count);
		float incomeNo=countIncomeNo/(no_count);
		float studentYes=countStudentYes/(yes_count);
		float studentNo=countStudentNo/(no_count);
		float creditYes=countCreditYes/(yes_count);
		float creditNo=countCreditNo/(no_count);
	    float ProbabBuysCompY=(ageYes)*(incomeYes)*(studentYes)*(creditYes);
	    float ProbabBuysCompN=(ageNo)*(incomeNo)*(studentNo)*(creditNo);
	    float yes=(buys_compy)*(ProbabBuysCompY);
	    float no=(buys_compn)*(ProbabBuysCompN);
	    if(yes<no)
	    	System.out.println(" Class is NO");
	    	else
	    		System.out.println("Class is YES");
		
		
		
		}
	}
		
