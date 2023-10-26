package Lap5;

public class BasicProblems {
	//add 2 matrix
	public static int[][] add(int[][] a, int[][] b){
		int[][] result = new int[a.length][a[1].length];
		for (int i = 0; i< a.length; i++) {
			for (int j=0; j< a[i].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}
	
	//subtract 2 matrix
	public static int[][] subtract(int[][] a, int[][] b){
		int[][] result = new int[a.length][a[1].length];
		for (int i = 0; i< a.length; i++) {
			for (int j=0; j< a[i].length; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}
	
	//multiply 2 matrix
	public static int[][] multiply(int[][] a, int[][] b){
		int[][] result = new int[a.length][b[1].length];
		for (int i=0; i< a.length; i++) {
			for (int j=0; j< b[1].length; j++)
				result[i][j] = multiplyHelp(i,j,a,b);
		}
		return result;
	}
	
	private static int multiplyHelp(int a, int b, int[][]mA, int[][] mB) {
		int result=0;
		for (int i=0; i< mB.length; i++) {
			result += mA[a][i]* mB[i][b];
		}
		return result;
	}
	
	//transpose a matrix
	public static int[][] transpose(int[][] a){
		int[][] result = new int[a[1].length][a.length];
		for (int i=0; i< a.length; i++) {
			for(int j=0; j< a[i].length; j++) 
				result[j][i] = a[i][j];
		}
		return result;
	}
	
	private static void display(int[][] matrix) {
		for (int i = 0; i< matrix.length; i++) {
			for (int j=0; j< matrix[i].length; j++)
				System.out.print(matrix[i][j] + "\t");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] a = {{7, 2},
					{5, 3}};
		int[][] b = {{2, 1},
					{3, 1}};
		display(add(a, b));
		System.out.println();
		display(subtract(a, b));
		
		System.out.println();
		int[][] c = {{1, 2, 3},
					{4, 5, 6}};
		int[][] d = {{1, 2, 3, 4},
					{4, 5, 6, 7},
					{8, 9, 0, 1}};
		display(multiply(c, d));
		display(transpose(c));

	}
}
