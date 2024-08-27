/*
 * Filename: MatrixChainParenthesize.java
 */
import java.util.Scanner;

/*
 * @author : Anushka Yadav (ay4034)
 */

public class MatrixChainParenthesize {
	static int num=1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n+1];
		for(int i=0;i<=n;i++) {
			arr[i]=sc.nextInt();
		}
		matrixChainMultiplication(arr,n+1);
		sc.close();

	}
	
	public static void matrixChainMultiplication(int A[],int n){
		//n=n+1;	//because we go from 0 to n so n+1 elements
		int[][] OPT = new int[n][n];
		int[][] parenthesis = new int[n][n];
		for (int i = 1; i < n; i++)
			OPT[i][i] = 0;
		for (int d = 1; d < n-1; d++){
	      for (int i = 1; i < n - d; i++){
	        int j = i + d;
	        OPT[i][j] = Integer.MAX_VALUE; //infinity 
	        for (int k = i; k <= j - 1; k++){
	          int tmp = OPT[i][k] + OPT[k + 1][j] + A[i - 1] * A[k] * A[j];
	          if (OPT[i][j]>tmp){
	        	  OPT[i][j] = tmp;
	        	  parenthesis[i][j] = k;
	          }
	        }
	      }
	    }
		System.out.print(OPT[1][n-1]);
		System.out.println();
	    printParenthesis(1, n - 1, n, parenthesis);
	    
	}

	public static void printParenthesis(int i, int j, int n, int[][] parenthesis){
		// If only one matrix left in current segment
		if (i == j){
			System.out.print(" A"+num);
			num++;
			return;
		}
		System.out.print("(");

		printParenthesis(i, parenthesis[i][j], n, parenthesis);
		System.out.print(" x ");
		printParenthesis(parenthesis[i][j] + 1, j, n, parenthesis);
		System.out.print(")");
	}
}
