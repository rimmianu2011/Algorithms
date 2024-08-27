/*
 * Filename: LongestKindOfIncrSubseq.java
 */

import java.util.Scanner;

/*
 * This program finds the kinda longest increasing subsequence based on the conditions provided in the
 * assignment pdf.
 * @author : Anushka Yadav (ay4034)
 */

public class LongestKindOfIncrSubseq{

    /**
     * This is the main method which takes the input given on the terminal and creates an array of it.
     * It further calls the increasingSequence() method which takes parameters: lenght of input array and
     * the input array itself.
     * @param args
     */

    public static void main(String[] args){
        Scanner input_num = new Scanner(System.in);
        int length = input_num.nextInt();
        int[] x = new int[length];
        for(int i = 0; i<length; i++){
            int a = input_num.nextInt();
//            input_num.nextLine();

            x[i] = a;
        }
//        for(int i = 0; i<length; i++){
//            System.out.println(x[i]);
//        }
//        System.out.println(x[1]);
        int output = increasingSequence(x, length);
        System.out.println(output);
    }

    /**
     * The method increasingSequence() takes input array and length of the array as parameters.
     * A dynamic array is created which will keep track of all the longest possible sequence at each index. The first(i)
     * for-loop will iterate over all the elements of the input array. The second for-loop will iterate over the elements
     * from i+1 and the third for-loop will check the elements < i.
     * After that, it will check the given condition in the homework pdf [(aji+aji+1)/2<aji+2].
     * In the end it will output the maximum length computed so far to the main function.
     * @param x : this is the input array of numbers
     * @param length : lenght of the input array.
     * @return : returns the final output after computation to the main() method.
     */

    public static int increasingSequence(int[] x, int length){
        int[] num_array = x;
        int lenght_0f_array = length;
//        System.out.println(lenght_0f_array);
        int max_length = 0;
        int[][] dynamic_array = new int[lenght_0f_array][lenght_0f_array];

        for(int y = 0; y < lenght_0f_array; y++){
            dynamic_array[y][y] = 1;
        }

        for(int k = 0; k < lenght_0f_array; k++){
            for(int l = k + 1; l < lenght_0f_array; l++){
                dynamic_array[k][l] = 2;
                dynamic_array = calculateLength(dynamic_array, k, l, num_array);
                max_length = Math.max(max_length, dynamic_array[k][l]);
            }
        }
//        System.out.println(max_length);
        return max_length;
    }

    public static int[][] calculateLength(int[][] dynamic_array, int k, int l, int[] num_array){
        for(int m = 0; m < k; m++) {
//                    dynamic_array[k][l] = 2;
            if ((num_array[k] + num_array[m]) / 2 < num_array[l]) {
                dynamic_array[k][l] = Math.max(dynamic_array[k][l], dynamic_array[m][k] + 1);
            }
        }
//        for(int p = 0; p<dynamic_array.length; p++){
//            System.out.println(dynamic_array[p][p]);
//        }
        return dynamic_array;
    }
}
