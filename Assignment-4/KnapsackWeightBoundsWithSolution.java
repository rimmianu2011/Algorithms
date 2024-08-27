import java.util.Scanner;

public class KnapsackWeightBoundsWithSolution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int W1 = sc.nextInt();
		int W2 = sc.nextInt();
		int val[] = new int[n];
        int wt[] = new int[n];
        
		//n lines follow
		for(int i=0;i<n;i++) {
			wt[i]=sc.nextInt();
			val[i]=sc.nextInt();
		}
		
		knapsack_helper(W1,W2,wt,val,n);
		sc.close();

	}
	public static void knapsack_helper(int W1, int W2, int[] w, int[] v, int n) {
		int max=0;
		int chosenWeight=0;
		for(int i=W1;i<W2;i++) {
			int res = knapsack(i,w,v,n);
			max = Math.max(max, res);
			chosenWeight = i;
			
		}
		System.out.println(max);
		//now lets print the chosen elements using the chosenWeight
		
		if(chosenWeight == 0) {
			System.out.println("-1");
		}
		else {
			print(chosenWeight, w,v,n);
			
		}
		
	}
	public static int knapsack(int W2, int w[], int v[], int n) {
		int res = 0;
		if (n <= 0 || W2 <= 0) {
	        res = 0;
	    }
		int m[][] = new int[n + 1][W2 + 1];
		for (int i = 1; i <= n; i++) {	//for every number
	        for (int j = 1; j <= W2; j++) { 
	        	if(j == 0) {
	        		m[i][j] = 0;
	        	}
	        	else if(w[i-1] <= j) {
	        		m[i][j] = Math.max(v[i-1]+m[i-1][j-w[i-1]], m[i-1][j]);
	        	}
	        	else {
	        		m[i][j] = m[i-1][j]; //skip
	        	}
	        }
		}
		res = m[n][W2];
		return res;
	}
	
	public static void print(int W, int[] w, int[] v, int n) {
		int m[][] = new int[n + 1][W + 1];
		
		for (int i = 1; i <= n; i++) {	//for every number
	        for (int j = 1; j <= W; j++) { 
	        	if(j == 0) {
	        		m[i][j] = 0;
	        	}
	        	else if(w[i-1] <= j) {
	        		m[i][j] = Math.max(v[i-1]+m[i-1][j-w[i-1]], m[i-1][j]);
	        	}
	        	else {
	        		m[i][j] = m[i-1][j]; //skip
	        	}
	        }
		}
		int res = m[n][W];
		int j=W;
		int finalArr[] = new int[n]; int p=0;
		//printing the index
		for (int i = n; i > 0 && res > 0; i--) {
			if (res == m[i - 1][W])
		         continue;
		    else {
		    	finalArr[p] = i;
		    	p++;
		        res = res - v[i - 1];
		        j = j - w[i - 1];
		        }
		}
		
		for(int i=finalArr.length-1;i>=0;i--) {
			if(finalArr[i] != 0) {
				System.out.print(finalArr[i]+" ");;
			}
		}
		
	}
	

}
