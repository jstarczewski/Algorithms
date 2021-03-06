import java.util.*;
import java.lang.System;

public class Quicksort {
		
	public static void quicksort(int[] a, int lo, int hi) {

		if (hi <= lo) 
			return;
		int j = split(a, lo, hi);
		quicksort(a, lo, j-1);
		quicksort(a, j+1, hi);
	}

	private static int split(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		int m = a[lo];
		while(true) {
			 while(a[++i] < m) 
				 if (i == hi) 
					 break;
			 while(m < a[--j])
				 if (j == lo)
					 break;
			 if (i >= j)
				 break;
			 int tmp = a[j];
			 a[j]  = a[i];
			 a[i] = tmp;
		}
		int tmp = a[j];
		a[j] = a[lo];
		a[lo] = tmp;
		return j;
	}

	public static void main(String[] args) {
		int[] testArray = new int[10];
		int[] testArrayJavaSort = new int[10];

		Random r = new Random();
		for (int i = 0; i < 10; i++) {
			testArray[i] = r.nextInt(100);
			testArrayJavaSort[i] = r.nextInt(100);
			System.out.print(testArray[i]+ " ");
		}
		long start = System.currentTimeMillis();
		quicksort(testArray, 0, testArray.length-1);
		long end = System.currentTimeMillis() - start;
		System.out.println("Time of sorting = " + end);

		start = System.currentTimeMillis();
		Arrays.sort(testArrayJavaSort, 0, testArrayJavaSort.length-1);
		end = System.currentTimeMillis() - start;
		System.out.println("Time of sorting = " + end);
		
		for (int i = 0; i < 10; i++) 
			System.out.print(testArray[i] + " ");
	}

}
