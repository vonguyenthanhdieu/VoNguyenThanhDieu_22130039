package Lap2;

public class TowersOfHanoi {
	//Task 1.4: Using recursive approach to implement Towers of Hanoi problem. 
	public static void solveTowersOfHanoi(int dick, char source, char dest, char spare) {
		if (dick == 1)
			System.out.println("Move disk 1 from " + source + " to " + spare);
		else {
			solveTowersOfHanoi(dick - 1, source, spare, dest);
		    System.out.println("Move disk " + dick + " from " + source + " to " + spare);
		    solveTowersOfHanoi(dick - 1, dest, source, spare);
		}
	}

	public static void main(String[] args) {
		int numDisks = 3; // Number of disks in the Towers of Hanoi problem
		char source = 'A'; // Source tower
		char dest = 'B'; // Auxiliary tower
		char spare = 'C';
		solveTowersOfHanoi(numDisks, source, dest, spare);
	}	
}
