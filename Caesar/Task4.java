package Caesar;

import java.util.Scanner;

public class Task4 {
	public static final char[] ALPHABET_NUMS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
			'2',  '3',  '4',  '5',  '6',  '7',  '8', '9'};
	
	private int n;// shift steps (right shift)

	public Task4(int shiftSteps) {
		this.n = shiftSteps;
	}
	
	
	public int getIndex(char c) {
		for (int i = 0; i < ALPHABET_NUMS.length; i++) {
			if (ALPHABET_NUMS[i] == c) {
				return i;
			}
		}
		return -1;
	}
	
	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 62. x represents the index of c in the 
	// ALPHABET
	
	public char encrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET_NUMS[(getIndex(c) + n) % 62];
		}
		else return '?';
	}
	
	public String encrypt(String input) {
		String result = "";
		char[] charArray = input.toCharArray();
		int n = charArray.length;
		for (int i = 0; i < n; i++) {
			result += encrypt(charArray[i]);
		}
		return result;
	}
	
	
	// Decrypt a character according to the given shift steps.
	// Decrypt: Dn(x) = (x – n) mod 62. x represents the index of c in 
	// the ALPHABET ARRAY
	
	public char decrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET_NUMS[Math.abs((getIndex(c) - n)) % 62];
		} else {
			return '?';
		}
	}
	
	
	// Decrypt a encrypted text using the above function for decrypting 
	public String decrypt(String input) {
		String result = "";
		char[] charArray = input.toCharArray();
		int n = input.length();
		for (int i = 0; i < n; i++) {
			result += decrypt(charArray[i]);
		}
		return result;
	}

	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		Task4 t4 = new Task4(5);
		
		String encrypt = t4.encrypt(input);
		String decrypt = t4.decrypt(encrypt);
		
		sc.close();
		
		String condition = "Can't Encrypt And Decrpyt Any Character Isn't A Letter Or Digit";
		
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isLetterOrDigit(input.toCharArray()[i])) {
				System.out.print(condition);
				break;
			}
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("Text And Nums: ");
		System.out.print("Encrypt text: " + input + " --> ");
		System.out.println(encrypt);
		System.out.print("Decrypt text: " + encrypt + " --> ");
		System.out.println(decrypt);
	}
}
