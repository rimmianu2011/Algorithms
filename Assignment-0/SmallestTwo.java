/*
 * Filename: SmallestTwo.java
 */

import java.util.Scanner;

/*
 * This program takes input from the command line. The first line of input in the command line states the number of
 * inputs that will be entered which will be followed by the actual inputs. Those inputs are then stored in an int[]
 * array which is further sorted. The sorted array is then used to display the first two smallest numbers.
 * @author : Anushka Yadav (ay4034)
 */

public class SmallestTwo{
    /**
     * In this function we take the input and check if the entered input is greater than 10000, if it is then the
     * program will terminate else it will continue.
     * In the next step the array of the input size is created which is then filled with the entered values using
     * the for loop.
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        if(num>10000){
            System.out.println("Number greater than 10000 not accepted.");
            System.exit(0);
        }

        int[] numbers = new int[num];

        for(int i=0; i<num; i++){
            Scanner inputNum = new Scanner(System.in);
            int x = input.nextInt();
            numbers[i] = x;
        }

        /***
         * This for loop is used for sorting the array in the ascending. Each value is compared with the rest of the
         * values and then swapped if needed.
         */

        for(int i = 0; i<num; i++){
            for(int j = i+1; j<num; j++){
                int a = numbers[i];
                if(a>numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
                else
                    continue;
            }
        }
        int counter = 0;

        /**
         * This for loop is used to print the first two smallest integers. To do that a variable counter is used to
         * keep track of the count. Since no same values can be printed(eg. 1,1) a while loop is used to check if the
         * consecutive values are same and if it is true then it will skip over those values and print the next smallest
         * number in the array and then the program will terminate.
         */

        for(int k = 0; k<num; k++){
            System.out.println(numbers[k]);
            counter++;
            while(numbers[k]==numbers[k+1]){
                k++;
            }
            if(counter==2){
                System.exit(0);
            }
        }
    }
}
