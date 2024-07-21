/*
 * Filename: Primes.java
 */

import java.util.Scanner;

/*
 * This program prints all the prime numbers from 1-n(entered input via the command line).
 * @author : Anushka Yadav
 */

public class Primes{

    /**
     * This function takes the input n and then creates a boolean array of size n. The value of the boolean array is set
     * to true for all.
     * @param args
     */

    public static void main(String[] args){
//        System.out.println("Enter the number to print all the prime numbers less than the input: ");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        boolean[] primeNum = new boolean[num + 1];

        for(int numAll = 2; numAll <= num; numAll++){
            primeNum[numAll] = true;
        }

        /**
         * This for loop checks for all the prime numbers, for that it takes the square root of the entered input.
         * In the second for loop it sets the boolean value of factors of i to false, and continues to do so until
         * all the factors of the numbers till the square root has been set to false. Now, the remaing true values
         * will be the prime numbers which is then printed in the next for loop.
         */

        for(int i = 2; i<= Math.sqrt(num); i++){
            for(int j = 2*i; j <= num; j+=i){
                primeNum[j] = false;
            }
        }
//        System.out.println("The prime numbers between 1 and " + num + " are as follows:");
        for(int prime = 0; prime <= num; prime++){
            if(primeNum[prime] == true){
                System.out.println(prime);
            }
        }
    }
}
