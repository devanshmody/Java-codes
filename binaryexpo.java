
package javaapplication1;
import java.util.*;
public class binaryexpo {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, i, c2 = 0, c3 = 0, c4 = 0;
        System.out.println("Enter the no of Stations:");
        n = sc.nextInt();
        int[] a = new int[n];
        int l = pow(c2);
        l = l - 1;
        int[] c1 = new int[100];
        for (i = 0; i < 100; i++) {
            c1[i] = 0;
        }
        while (c3 == 0) {
            c3 = 0;
            c4 = 0;
            System.out.println("Enter input between 0 & " + l);
            for (i = 0; i < n; i++) {
                    System.out.println("Enter stations " + (i + 1) + " time slot");
                    a[i] = sc.nextInt();
                    if (a[i] > l) {
                        i--;
                    } else {
                        c1[a[i]]++;
                    }
            }
            for (i = 0; i < n; i++) {
                if (c1[a[i]] > 1) {
                    c2++;
                    for (int j = 0; j < n; j++) {
                        if (a[j] == a[i]) {
                            System.out.println("Node " + (j + 1) + " has Conflict");
                        }
                    }
                    l = pow(c2);
                    l--;
                    System.out.println("time slots increased to: " + l);
                    c4++;
                    break;
                }
            }
            for (i = 0; i < 100; i++) {
                c1[i] = 0;
            }
            if (c4 == 0) {
                c3 = 1;
            } else {
                c3 = 0;
            }
        }
    }
    static int pow(int a) {
        int b = 1;
        for (int i = 0; i < a; i++) {
            b = b * 2;
        }
        return b;
    }
}


