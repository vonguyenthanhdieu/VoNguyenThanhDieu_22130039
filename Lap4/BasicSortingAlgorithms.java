package Lap4;

public class BasicSortingAlgorithms {
	//: Implement selection sort algorithm to sort an array of integers (using 
	//iterative or recursive approach).
	public static void selectionSort(int[] array) {
		for (int i=0; i < array.length -1; i++ ) {
			for (int j = i+1; j< array.length; j++)
				//tim gia tri nho hon
				if (array[i] < array[j])
					//hoan doi vi tri hai phan tu
					swap(array,i,j);
		}
	}
	private static void swap(int[] arr,int i, int j) {
		int tam = arr[i];
		arr[i] = arr[j];
		arr[j] = tam;
	}
	
	//bubble sort
	public static void bubbleSort(int[] array) {
		for (int k =0; k< array.length -1;k++) {
			//các phần tử k cuối đã được sắp xếp
			for (int i = 0; i< array.length -1 -k; i++) {
				if(array[i] < array[i+1])
					swap(array, i, i+1);
			}
		}
	}
	
	//insertionSort
	public static void insertionSort (int[] array) {
		for (int i =0; i< array.length; i++) {
			int j = i;
			int cur = array[i];
			while ( j>0 && array[j-1] < cur) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = cur;
		}
	}
	
	// in mang ra mang hinh
	private static void display(int[] array) {
		if (array.length == 0) System.out.print("null");
		else
			for (int i = 0; i< array.length; i++)
				System.out.print(array[i] + "\t");
	}
	public static void main(String[] args) {
		int[] arr1 = {10, 6, 4, 8, 2, 1};
		selectionSort(arr1);
		display(arr1);
		
		int[] arr2 = {10, 6, 4, 8, 2, 1};
		bubbleSort(arr2);
		System.out.println(); 
		display(arr2);
		
		int[] arr3 = {10, 6, 4, 8, 2, 1};
		insertionSort(arr2);
		System.out.println(); 
		display(arr2);
	}
}
