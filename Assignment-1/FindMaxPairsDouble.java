import java.util.Scanner;

/*
 * @author : Anushka Yadav
 */

public class FindMaxPairsDouble {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		double arr[] = new double[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextDouble();
		}
		FindMaxPairsDouble ob = new FindMaxPairsDouble();
		ob.findMaxPairs(n, arr);
		sc.close();

	}

	
	public void findMaxPairs(int n, double [] arr) {
		int max=0; int k=0;
		double t = 0, ogSum = 0;
		double sums[] = new double[(n*(n-1))/2];
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(i!=j) {
					t = arr[i]+arr[j];
					sums[k++] = t; //storing sums in an array
				}
				
			}
		}		
		
		double[] sortarr = new double[sums.length];
		sortarr = sort(sums);
		
		//I have sorted sum array now in sortarr
//		double check = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(i!=j) {
					t = arr[i]+arr[j];
//					System.out.println("t " + t);
					int seenBefore = binarySearch.countOccurrences(sortarr, sortarr.length-1, t);
					//Now I have number of times t was seen
					if(seenBefore>max) {
						max = seenBefore;
						ogSum = t;
					}
					else if(seenBefore == max){
						if(t<ogSum){
							max = seenBefore;
							ogSum = t;
						}
					}

				}
				
			}
		}
		System.out.println(max+" "+String.format("%.6f", ogSum));
		
		
		
	}
		
		public static double[] sort(double[] arr) {
			for(int i=0;i<arr.length-1;i++) {
				int index = i;
				for(int j=i+1;j<arr.length;j++) {
					if(arr[j] < arr[index]) {
						index = j;
					}
				}
				double temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
			return arr;
		}
}
