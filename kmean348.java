/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kmean348;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Tak
 */
public class Main {

    private static final Scanner scannerObject = new Scanner(System.in);
    private static int k;
    private static int noOfInputPoints;
    private static List<Point2D.Double> inputPoints;
    private static int noOfClusterPoints;
    private static List<Point2D.Double> clusterPoints;
    private static int[] groupOfElement;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Enter the value of k: ");
        k = scannerObject.nextInt();
        System.out.print("Enter the number of inputs: ");
        noOfInputPoints = scannerObject.nextInt();
        groupOfElement = new int[noOfInputPoints];
        inputPoints = new ArrayList<Point2D.Double>();

        //get the input points
        for (int i=0; i<noOfInputPoints; i++) {
            System.out.printf("for Point: %d\n" , i);
            System.out.print("Enter x: ");
            double x = scannerObject.nextDouble();
            System.out.print("Enter y: ");
            double y = scannerObject.nextDouble();
            Point2D.Double point = new Point2D.Double(x,y);
            inputPoints.add(point);
        }

        //instanstiate the initial cluster points i.e initial mean values
        //Assuming a value of 2
        //System.out.print("Enter the no. of cluster points: ");
        //noOfClusterPoints = scannerObject.nextInt();
        noOfClusterPoints= 2;
        clusterPoints = new ArrayList<Point2D.Double>();
        for (int i=0; i<noOfClusterPoints; i++) {
            clusterPoints.add(inputPoints.get(i));
        }

        for (int i=0; i<k; i++) {
            //for each instance of k
            for (int j=0; j<noOfInputPoints; j++) {
                int index = 0;
                //calculate the euclidean distance of the point with each group
                double group1 = findEuclideanDistance(inputPoints.get(j), clusterPoints.get(0));
                double group2 = findEuclideanDistance(inputPoints.get(j), clusterPoints.get(1));
                if(Double.compare(group2, group1) < 0 ) {
                    index = 1;
                }
                groupOfElement[j] = index;
                System.out.printf("Logging===k = %d, j= %d, index= %d\n", k, j, index);
                Point2D.Double newMeanPoint = findMean(inputPoints.get(j), clusterPoints.get(index));
                clusterPoints.set(index, newMeanPoint);
            }
        }

        for (int i=0;i<noOfClusterPoints; i++){
            System.out.printf("Group %d\n", noOfClusterPoints);
            System.out.println(clusterPoints.get(i).toString());
        }

        for (int i=0; i<noOfInputPoints; i++) {
            System.out.printf("cluster of point %d = %d\n", i, groupOfElement[i]);
        }
    }
for(int)
  