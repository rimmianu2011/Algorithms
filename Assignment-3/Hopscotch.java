/*
 * Filename: Hopscotch.java
 */

import java.util.Scanner;

/*
 * This program finds the maximum sum possible in a given array by either going 2 steps forward or 3 steps forward
 * using dynamic programming approach.
 * @author : Anushka Yadav (ay4034)
 */

public class Hopscotch {
    static int[] input_array;

    /***
     * This method takes the input from the user stores it in the array and then calls the MaximumSum()
     * method which takes the created array as a parameter.
     * @param args : takes the input values from the user
     */
    public static void main(String[] args){
        Scanner numbers = new Scanner(System.in);
        int length = numbers.nextInt();
        int[] input_array = new int[length];


        for(int i = 0; i<length; i++){
            int a = numbers.nextInt();
            input_array[i] = a;
        }


        int output = MaximumSum(input_array);
        System.out.println(output);
    }

    /***
     * In this method we find the maximum sum possible by either considering the element at i+2
     * position or i+3 position.
     * @param input_array : array of input values
     * @return OPT : returns the maximum sum computed.
     */
    public static int MaximumSum(int[] input_array){
        int len = input_array.length;
        int[] OPT = new int[len];

        for(int i = 0; i < len; i++){
            OPT[i] = 0;
        }

        //if the number of elements in the array is less than 3 then the element at 0th position will be the output.
        if(len < 3){
            return input_array[0];
        }

        //here we store the values for length, length-1 and length-2(this is i+2) in the OPT[] array.
        OPT[len-1] = input_array[len-1];
        OPT[len-2] = input_array[len-2];
        OPT[len-3] = input_array[len-3] + input_array[len-1];


        /***
         * In this for-loop we'll start checking the values from len-4 position till the starting postion.
         * It will get the element at the jth position from the input_array and from the OPT[] it will get the
         * values at the j+2 and j+3 position. It will get the maximum of the two values and add that to the jth value
         * of the input_array and decerement j.
         * OPT[] keeps track of the maximum sum possible considering the different possible positions that we can get
         * the values at.
         * It will continue to do that until all the elements have been considered of the input_array and the value
         * at the OPT[0] will be the maximum sum that we can compute.
         */
        for(int j = len-4; j>=0; j--){
            int max_val = Math.max(OPT[j+2], OPT[j+3]);
            OPT[j] = input_array[j] + max_val;
        }

        return OPT[0];
    }
}
