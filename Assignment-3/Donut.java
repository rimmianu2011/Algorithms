/*
 * Filename: Donut.java
 */

import java.util.Scanner;

/*
 * This program finds the shortest distance that can be travelled to reach the Donut shop.
 * @author : Anushka Yadav (ay4034)
 */

public class Donut{

    /***
     * This is the main method that takes the user entered input and stores it in the arrays.
     * Simultaneously, it calculates the x-best and y-best value for further computation.
     * It calls the MinDistance() method which returns the shortest computed distance value.
     * @param args : takes input x,y value
     */
    public static void main(String[] args){
        Scanner input_num = new Scanner(System.in);
        int length = input_num.nextInt();
        int[] x = new int[length];
        int[] y = new int[length];
        int xAverage = 0;
        int yAverage = 0;

        for(int i = 0; i<length; i++){
            int x_value = input_num.nextInt();
            int y_value = input_num.nextInt();
            xAverage += x_value;
            yAverage += y_value;

            x[i] = x_value;
            y[i] = y_value;
        }

        xAverage = xAverage/length;
        yAverage = yAverage/length;
        int shortest_distance = MinDistance(xAverage, yAverage, x, y);
        System.out.println(shortest_distance);


    }

    /***
     * This method computes the shortest distance that the police department will need to travel
     * to get to the donut shop.
     * @param xAvg : x-best value
     * @param yAvg : y-best value
     * @param x : array with x values
     * @param y : array with y values
     * @return total_sum : returns the smallest distance
     */
    public static int MinDistance(int xAvg, int yAvg, int[] x, int[] y){
        int total_distance = 0;
        for(int i = 0; i < x.length; i++){
            int x_value = Math.abs(xAvg - x[i]);
            int y_value = Math.abs(yAvg - y[i]);
            total_distance += x_value + y_value;
        }
        return total_distance;
    }
}
