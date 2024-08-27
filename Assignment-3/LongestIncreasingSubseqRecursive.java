/*
 * Filename: LongestIncreasingSubseqRecursive.java
 */

import java.util.Scanner;

/*
 * This program finds the longest increasing sub-sequence in the given array of numbers
 * using recursive approach.
 * @author : Anushka Yadav (ay4034)
 */

public class LongestIncreasingSubseqRecursive{
    static int[] input_array;
    static int maximum_length;

    /***
     * The main method takes the input from the user and stores it in the array.
     * It also calculates the execution time in seconds which is not being printed.
     * It then calls the longestSequence() method and passes the input_array and length as parameters.
     * In the end it outputs the longest increasing subsequence possible in the given array.
     * @param args : user entered input stored in an array
     */
    public static void main(String[] args){
        Scanner numbers = new Scanner(System.in);
        int length = numbers.nextInt();
        int[] input_array = new int[length];

        for(int i = 0; i<length; i++){
            int a = numbers.nextInt();
            input_array[i] = a;
        }

        long start = System.currentTimeMillis();
        int max_length = longestSequence(input_array, length);

        System.out.println(max_length);
        long end = System.currentTimeMillis();
        float total_time = end;
//        System.out.println("time-seconds: " + total_time);
    }


    /***
     * The base case checks to see if the array length is 1, if it is then there won't be any longest increasing
     * sub-sequence possible, therefore return 1 as the length.
     * If the length is greater than 1 then we will go to the for-loop.
     * In the first iteration k=1, we will recursively call the recLongestSequence() method where we will pass the
     * input array and the index till which we need to check. It will then compare the elements at k-1 and length-1
     * and the length will be the value of k that we passed in the recursive call.
     * @param num_array : input array
     * @param len_array : input_array length
     * @return maximum : length of the longest increasing sub-sequence
     */
    public static int recLongestSequence(int[] num_array, int len_array){
        int maximum = 1;
        int rec_call = 1;

        //base case
        if(len_array == 1){
            return 1;
        }

        for(int k = 1; k < len_array; k++){
            rec_call = recLongestSequence(num_array, k);
            if(num_array[k-1] < num_array[len_array-1]){
                if(rec_call + 1 > maximum){
                    maximum = rec_call + 1;
                }
            }
        }

        if(maximum_length < maximum){
            maximum_length = maximum;
        }

        return maximum;
    }

    public static int longestSequence(int[] input_array, int len){
        maximum_length = 1;
        recLongestSequence(input_array, len);
        return maximum_length;
    }
}
