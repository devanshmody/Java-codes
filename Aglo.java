package anglomeritcluster;

import java.util.*;
import java.lang.Math.*;

class Aglo {

    public static void main(String args[]) {
        int i, j;
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of coordinates");
        n = s.nextInt();
        int adj[][] = new int[n][n];
        Point[] p = new Point[n];
        for (i = 0; i < n; i++) {
            System.out.println("Enter co-ordinates for data set " + (i+1));
            p[i] = new Point();
            p[i].x = s.nextFloat();
            p[i].y = s.nextFloat();
            System.out.println();
        }
        
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                adj[i][j] = (int) euDistance(p[i].x, p[i].y, p[j].x, p[j].y);
                System.out.println();
            }
        }
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 6; j++) {
                System.out.print("\t" + adj[i][j]);
            }
            System.out.println();
        }
    }

    public static float euDistance(float a, float b, float c, float e) {
        float r, s;
        s = (float) (Math.pow((a - c), 2) + Math.pow((b - e), 2));
        r = (float) (Math.sqrt(s));
        return r;
    }
}

class Point {
    float x, y;
}
