/*
 * Filename: LongestIncreasingSubseqDP.java
 */

import java.util.Scanner;

/*
 * This program finds the longest increasing sub-sequence in the given array of numbers using
 * dynamic programming.
 * @author : Anushka Yadav (ay4034)
 */

public class LongestIncreasingSubseqDP{
    static int[] input_array;
    static int maximum_length;


    /***
     * The main() method takes input from the user, creates an array and stores the input in the array.
     * It then calls the longestSequenceDP() method and passes the array as a parameter.
     * In the end, it prints the length of the longest increasing sub-sequence found.
     * @param args : number of elements, input numbers
     */
    public static void main(String[] args){
        Scanner numbers = new Scanner(System.in);
        int length = numbers.nextInt();
        int[] input_array = new int[length];

        for(int i = 0; i<length; i++){
            int a = numbers.nextInt();
            input_array[i] = a;
        }

        long start = System.nanoTime();
        int maximum_length = longestSequenceDP(input_array);
        System.out.println(maximum_length);

        long end = System.nanoTime();
        float total_time = end-start;
        System.out.println("time-nanoseconds: " + total_time);
    }

    /***
     * This method finds the longest increasing sub-sequence. To do that, two for-loops have been used.
     * The first for loop gives the jth index of the element that we need to check till and in the second
     * for-loop we compare the elements that are before the jth position with the jth value.
     * @param a : input array
     * @return : returns the length of the longest increasing sub-sequence.
     */
    public static int longestSequenceDP(int[] a){
        int n = a.length;
        int[] OPT = new int[n];
        int maximum = 0;

        //initialize the values at all the indexes to 1
        for(int i = 0; i < n; i++){
            OPT[i] = 1;
        }

        for(int j = 1; j < n; j++){
            for(int k = 0; k <= j-1; k++){
                if(a[k] < a[j] && OPT[j] <= OPT[k]){
                    OPT[j] = OPT[k] + 1;
                }
            }
        }

        for(int l = 0; l < OPT.length; l++){
            if(maximum < OPT[l]){
                maximum = OPT[l];
            }
        }
        return maximum;
    }

}
