import java.util.*;
import java.io.*;
public class Berkeley {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s_Hours, s_Minutes, c1_Hours, c1_Minutes, c2_Hours, c2_Minutes;
        int s_Time, c1_Time, c2_Time;
        System.out.println("Time Synchronization");

        System.out.println("Server Time:");
        System.out.println("Enter hour:");
        s_Hours = sc.nextInt();
        System.out.println("Enter minutes:");
        s_Minutes = sc.nextInt();
        s_Time = s_Hours  * 60 +  s_Minutes;

        System.out.println("Client1 Time:");
        System.out.println("Enter hour:");
        c1_Hours = sc.nextInt();
        System.out.println("Enter minutes:");
        c1_Minutes = sc.nextInt();
        c1_Time = c1_Hours * 60 + c1_Minutes;

        System.out.println("Cleint2 Time:");
        System.out.println("Enter hour:");
        c2_Hours = sc.nextInt();
        System.out.println("Enter minutes:");
        c2_Minutes = sc.nextInt();
        c2_Time = c2_Hours * 60 + c2_Minutes;

        int time_Average = (s_Time + c1_Time + c2_Time) / 3;

        int difference;
        difference = time_Average - s_Time;
        if (difference == 0) {
            System.out.println("Server time is perfect");
        } else if (difference < 0) {
            System.out.println("Server has to backward clock by " + (-difference) + " mins");
        } else {
            System.out.println("Server has to forward clock by " + difference + " mins");
        }

        difference = time_Average - c1_Time;
        if (difference == 0) {
            System.out.println("Cleint1 time is perfect");
        } else if (difference < 0) {
            System.out.println("Cleint1 has to backward clock by " + (-difference) + " mins");
        } else {
            System.out.println("Cleint1 has to forward clock by " + difference + " mins");
        }

        difference = time_Average - c2_Time;
        if (difference == 0) {
            System.out.println("Cleint2 time is perfect");
        } else if (difference < 0) {
            System.out.println("Cleint2 has to backward clock by " + (-difference) + " mins");
        } else {
            System.out.println("Cleint2 has to forward clock by " + difference + " mins");
        }
        System.out.println("New Time After Synchronizaion is " + (time_Average/60) + " hours and "+ (time_Average%60));
    }	
    	
}

/* OUTPUT
 
Time Synchronization
Server Time:
Enter hour:
5 20
Enter minutes:
Client1 Time:
Enter hour:
5 30 5 40
Enter minutes:
Cleint2 Time:
Enter hour:
Enter minutes:
Server has to forward clock by 10 mins
Cleint1 time is perfect
Cleint2 has to backward clock by 10 mins
 New Time After Synchronizaion is 5 hours and 30
 */





 