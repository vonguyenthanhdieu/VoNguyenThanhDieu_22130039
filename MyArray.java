package Lap1;

import java.lang.reflect.Array;

public class MyArray {
	private int[] arr;
	public MyArray( int[] arr) {
		this.arr = arr;
	}
	
	//Method mirror that outputs the contents of an array in a 
	//reverse order like a mirror 
	//Example: input [1, 2, 3] ==> output: [1, 2, 3, 3, 2, 1]
	public int[] mirror() {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i< arr.length; i++) {
			result[i] = arr[i];
			result[arr.length * 2 -i -1] = arr[i];
		}
		return result;
	}
	// in mang ra mang hinh
	private static void display(int[] array) {
		if (array.length == 0) System.out.print("null");
		else
			for (int i = 0; i< array.length; i++)
				System.out.print(array[i] + "\t");
	}
	
	// removes all duplicate elements from an array and returns a 
	// new array
	//Input: 1 3 5 1 3 7 9 8
	//Output: 1 3 5 7 9 8

	public int[] removeDuplicates() {
		//mang chua su lap cua cac phan tu 
		boolean[] tam = new boolean[arr.length];
		int dem =0;
		for (int i = 0; i< arr.length; i++) {
			tam[i] = isNDuplicates(arr, i);
			if (tam[i]) dem++;
		}
		int[] result = new int[dem];
		int j=0;
		for (int i=0; i< arr.length; i++) {
			if (tam[i]) {
				result[j] = arr[i];
				j++;
			}	
		}
		return result;
	}
	//kiem tra xem trong mang co phan tu i khong
	private boolean isNDuplicates(int[] array, int i) {
		for (int j = 0; j< i; j++) {
			if (arr[j] == arr[i]) 
				return false;
		}
		return true;
	}
	//determine missing values from a sorted array
	// Input: 10 11 12 13 14 16 17 19 20 
	// Output: 15 18
	public int[] getMissingValues() {
		int[] result = new int[countMissing(arr)] ;
		int dem=-1;
		for (int i=0; i< arr.length -1; i++) {
			if (arr[i]+1 !=arr[i+1])
				for (int j= arr[i]+1; j< arr[i+1]; j++) {
					dem++;
					result[dem] = j;
				}	
		}
		return result;
	}
	//đếm số số bị bỏ qua
	private int countMissing(int[] array) {
		int dem =0;
		for (int i=0; i< array.length -1; i++)
			dem += (array[i+1] - array[i] -1);
		return dem;
	}
	//fill missing data by the minimal average of ints k neighbors
	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 16 17 19 20
	public int[] fillMissingValues(int k) {
		int[] result = arr.clone();
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 6};
		MyArray array = new MyArray(arr);
		int[] mi = array.mirror();
		display(mi);
		
		int[] arr2 = {1, 3, 5, 1, 3, 1, 7, 9, 8};
		MyArray array2 = new MyArray(arr2);
		int[] du = array2.removeDuplicates();
		System.out.println();
		display(du);

		int[] arr3 = {10, 11, 12, 13, 14, 16, 17, 19, 20, 25};
		MyArray array3 = new MyArray(arr3);
		int[] miss = array3.getMissingValues();
		System.out.println();
		display(miss);
	}
}
