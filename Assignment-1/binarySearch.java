
/*
 * @author : Anushka Yadav
 */

public class binarySearch {
	
	static int searchArray(double arr[], int left, int right, double x)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;
 
            //if key == mid
            if (arr[mid] == x)
                return mid;
 
            // If key smaller than mid, check left side
            if (arr[mid] > x)
                return searchArray(arr, left, mid - 1, x);
 
         // If key larger than mid, check right side
            return searchArray(arr, mid + 1, right, x);
        }
 
        // if element not present
        return 0;
    }
	static int countOccurrences(double[] arr, int n, double x) {
		int element = searchArray(arr, 0,n - 1, x);
		// Count elements on left side.
        int count = 1;
        int left = element - 1;
        while (left >= 0 &&
               arr[left] == x)
        {
            count++;
            left--;
        }
        int right = element + 1;
        while (right < n && arr[right] == x)
        {
            count++;
            right++;
        }
        return count;
	}
	
	
	

}
