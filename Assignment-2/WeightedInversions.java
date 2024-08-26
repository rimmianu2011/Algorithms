/*
 * Filename: WeightedInversions.java
 */

import java.util.Scanner;

/*
 * This program finds the weight of all the inversions.
 * @author : Anushka Yadav (ay4034)
 */

public class WeightedInversions{
	/***
	 * This method computes the weight of all the inversions using the index values of those numbers.
	 * It uses two for-loops to do that.
	 * If the number is greater than the rest of the numbers after it in the array it will count the inversions
	 * and compute the weight for each inversion possible and update the weight.
	 * It will continue to do that until we have traversed through all the nummbers in the array.
	 * In the end it will return the value of weight.
	 * @param arr : array of input numbers
	 * @return : returns the weight to the main function.
	 */
	public static int count(int arr[]){
		long sum=0;
		for(int i = 0; i < arr.length; i++){
			for(int j=i;j<arr.length;j++) {
				if(arr[j] < arr[i]) {
					sum += Math.abs(j-i);
				}
			}
		}
		return sum;
	}

	/***
	 * This is the main method which is executed first. It reads all the inputs and adds it to an array called array_num.
	 * After that we call the count() method which computes the weight and pass the array of numbers as a parameter.
	 * In the end it prints the output.
	 * @param args : Takes arguments from the command line, i.e. takes the set of numbers and adds it to an array.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numbers = sc.nextInt();
		int[] array_num = new int[numbers];

		for(int a = 0; a < n; a++){
			array_num[a] = sc.nextInt();
		}

		long weight = count(array_num);
		System.out.println(weight);

		sc.close();
	}

}
