package Lap3;

public class MyArray {
	private int[] array;
	
	public MyArray(int[] array) {
		this.array = array;
	}
	// To find the index of the target in the array. If the target 
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3

	//Lặp
	public int iterativeLinearSearch(int target) {
		for (int i=0; i< array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

	// To find the index of the target in the array. If the target 
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	
	//Đệ quy
	public int recursiveLinearSearch(int target) {
		return recursiveFunctionHelp(target, 0);
	}
	private int recursiveFunctionHelp(int target, int index) {
		if (index == array.length) 
			return -1;
		else 
			if (array[index] == target) 
				return index;
		else
			return recursiveFunctionHelp(target, index+1);
	}
	
	// To find the index of the target in the sorted array. If the 
	//target is not found in the array, then the method returns -1.
	public int iterativeBinarySearch(int target) {
		 int l = 0, r = array.length - 1;
	     while (l <= r) {
	    	 int m = l + (r - l) / 2;
	         if (array[m] == target)
	        	 return m;
	         if (array[m] < target)
	        	 l = m + 1;
	         else
	        	 r = m - 1;
	        }
	     return -1;
	}
	
	public int recursiveBinarySearch(int target) {
        return recursiveBinarySearchHelp(target, 0, array.length-1);
	}
	private int recursiveBinarySearchHelp(int target, int l, int r) {
		if (r >= l) {
            int mid = l + (r - l) / 2;
            if (array[mid] == target)
                return mid;
            if (array[mid] > target)
                return recursiveBinarySearchHelp(target, l, mid -1);
            return recursiveBinarySearchHelp(target, mid+1, r);
        }
        return -1;
	}
	
//	 How to change the implemented methods so that they can be used for the 
//	case in which the array is sorted by descending order.
	
	public int iterativeBinarySearchDescending(int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low+high-1)/2;
			if (target == array[mid]) return mid;
			if (target > array[mid] ) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}

	public int recursiveBinarySearchDescending(int target) {
		return BinarySearchDescendingHelper(target, 0, array.length-1);
	}
	public int BinarySearchDescendingHelper(int target, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high-1)/2;
		if (target == array[mid]) return mid;
		if (target > array[mid]) {
			return BinarySearchDescendingHelper(target, low, mid-1);
		}
		else {
			return BinarySearchDescendingHelper(target, mid+1, high);
		}
	}
	
	public static void main(String[] args) {
		int [] arr = {12, 10, 9, 45, 2, 10, 10, 45};
		MyArray array = new MyArray(arr);
		int target = 45;
		System.out.println(array.iterativeLinearSearch(target));
		System.out.println(array.recursiveLinearSearch(target));
		
		int [] arr2 = {2, 9, 10, 10, 10, 10,12, 45, 45};
		MyArray array2 = new MyArray(arr2);
		int target2 = 45;
		System.out.println(array2.iterativeBinarySearch(target2));
		System.out.println(array2.recursiveBinarySearch(target2));
		
		int [] arr3 = {45, 45, 12, 10, 9 ,9, 3};
		MyArray array3 = new MyArray(arr3);
		int target3 = 45;
		System.out.println(array3.iterativeBinarySearchDescending(target3));
		System.out.println(array3.recursiveBinarySearchDescending(target3));
	}
	
}
