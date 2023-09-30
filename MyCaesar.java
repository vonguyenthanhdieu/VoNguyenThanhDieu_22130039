package Lap1;

public class MyCaesar {
	public static final char[] ALPHABET = {'A', 'B',
			'C', 'D', 'E', 'F', 'G','H', 'I', 'J', 'K'
			, 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	private int n; //shift step (right shift)
	
	public MyCaesar (int shiftSteps) {
		this.n = shiftSteps;
	}
	
	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the 
	//ALPHABET
	public char encryptChar(char c) {
		char result = 0;
		if (searchChar(c) != -1) 
			 return result = ALPHABET[(searchChar(c)+ this.n)%26] ;
		else return 0;
	}
	//Tìm kiếm chữ cái trong mảng
	private int searchChar(char c) {
		for (int i=0; i< ALPHABET.length; i++)
			if (ALPHABET[i] == c) return i;
		return -1;
	}
	
	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String result = "";
		for (int i=0; i< input.length(); i++) {
			String tam = encryptChar(input.charAt(i)) + "";
			result = result.concat(tam); 
		}
		return result;
	}
	
	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in 
	//the ALPHABET array
	public char decryptChar(char c) {
		char result = 0;
		if (searchChar(c) != -1) 
			if (searchChar(c)-this.n < 0)
				return result = ALPHABET[(searchChar(c)+26 - this.n)%26] ;
			else
				return result = ALPHABET[(searchChar(c)- this.n)%26] ;
		return 0;
	}
	
	// Decrypt a encrypted text using the above function for decrypting a 
	//charater.
	public String decrypt(String input) {
		String result = "";
		for (int i=0; i< input.length(); i++) {
			String tam = decryptChar(input.charAt(i)) + "";
			result = result.concat(tam); 
		}
		return result;
	}
	public static void main(String[] args) {
		MyCaesar caesar = new MyCaesar(2);
		System.out.println(caesar.encryptChar('Z'));
		System.out.println(caesar.encrypt("HELLO"));
		
		System.out.println(caesar.decryptChar('b'));
		System.out.println(caesar.decrypt("JGNNQ"));
		
	}
}
