/*
 * Filename: LongestKindOfIncrSubseq.java
 */

import java.util.Scanner;
/*
 * @author : Anushka Yadav (ay4034)
 */
public class AllWhiteSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char arr[][] = new char [n][n];
		String temp[] = new String[n];
		//n lines follow
		for(int i=0;i<n;i++) {
			temp[i]=sc.next();
		}
		//reassembling the read string array into a double dimention array for our convenience and dp logic
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=temp[i].charAt(j);
			}
		}
		
		System.out.println(findMaxSideLength(arr));
		sc.close();


	}
	public static int findMaxSideLength(char[][] arr) {
		int k = 0;
		int n = arr.length;
		int OPT[][] = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i-1][j-1] == 'w'){
                    OPT[i][j] = 1 + Math.min(Math.min(OPT[i][j - 1], OPT[i - 1][j]), OPT[i - 1][j - 1]);
                    k = Math.max(k, OPT[i][j]);	//finds max side
                }
            }
        }
        return k;
    }

}
