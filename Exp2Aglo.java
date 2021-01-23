package zxcdwm;

import java.util.*;
import java.lang.Math.*;

class Exp2Aglo {

    public static void main(String args[]) {
        int i, j;
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no of coordinates");
        n = s.nextInt();
        float adj[][] = new float[n][n];
        Point[] p = new Point[n];
        for (i = 0; i < n; i++) {
            System.out.println("Enter co-ordinates for data set " + (i + 1));
            p[i] = new Point();
            p[i].x = s.nextFloat();
            p[i].y = s.nextFloat();
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                adj[i][j] = euDistance(p[i].x, p[i].y, p[j].x, p[j].y);
            }
        }
        int a[2] new int[]= minimum(adj);

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print("\t\t" + adj[i][j]);
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

    public static int[] minimum(float adj[][]) {
        float min = adj[0][0];
        int a[] = new int[2];
        a[0] = 0;
        a[1] = 1;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (adj[i][j] < min) {
                    a[0] = i;
                    a[1] = j;
                }
            }
        }

        return a;
    }
}

class Point {

    float x, y;
}
