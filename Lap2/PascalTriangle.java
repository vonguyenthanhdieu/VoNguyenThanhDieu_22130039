package Lap2;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based 
	//on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		if (row == 1 )
			display(getPascalTriangle(1));
		else {
			printPascalTriangle(row -1);
			display(getPascalTriangle(row));
		}
	}
	private static void display(int[] array) {
		if (array.length == 0) System.out.print("null");
		else
			for (int i = 0; i< array.length; i++)
				System.out.print(array[i] + "\t");
		System.out.println();
	}
	// get the nth row. 
	//For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n==1)
			return new int[] {1};
		else {
			int[] prevRow = getPascalTriangle(n-1);
			return generateNextRow(prevRow);
		}
	}
	// generate the next row based on the previous row
	//Ex. prevRow = {1} ==> nextRow = {1, 1}
	//Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length+1];
		nextRow[0] =1;
		nextRow[nextRow.length-1] = 1;
		for(int i=1; i< prevRow.length; i++) {
			nextRow[i] = prevRow[i-1] + prevRow[i];
		}
		return nextRow;
	}
	public static void main(String[] args) {
		int row = 5;
		printPascalTriangle(row);
	}
}
