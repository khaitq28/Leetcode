package recursive;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
			
		int[] arr = new int[] {5,1,1,2,0,0 };
			
		arr = quickSort(arr);
		
		print(arr);
	}

	// 1 5 3 2 8 7 6 4
	
	// 1 3 2   4   8 7 6 5
	public static int[]  quickSort(int[] arr) {
		int n = arr.length; if (n <= 1) return arr;
		int p  = arr[n - 1];
		int[] left = part(arr, p, true);
		int[] right = part(arr, p, false);
		
		 int[] l =  quickSort(left);
		 int[] r =  quickSort(right);
		
		arr = Arrays.copyOf(l, l.length + r.length + 1);
		int k = l.length;
		arr[k++] = p;
		for (int i: r) {
			arr[k++] = i;
		}
		return arr;
	}
	
	public static int[] part(int[] arr, int p, boolean left) {
		int[] ret = new int[arr.length]; int k = 0;
		for (int i = 0; i < arr.length - 1; i ++) {
			if ((left && arr[i] <= p) || (!left && arr[i] > p))
				ret[k ++] =  arr[i];

		}
		return Arrays.copyOf(ret, k);
	}
	
	private static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
}
