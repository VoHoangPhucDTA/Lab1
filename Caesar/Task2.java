package Caesar;



public class Task2 {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	
	
	private int n;// shift steps (right shift)

	public Task2(int shiftSteps) {
		this.n = shiftSteps;
	}
	
	
	public int getIndex(char c) {
		for (int i = 0; i < ALPHABET.length; i++) {
			if (ALPHABET[i] == c) {
				return i;
			}
		}
		return -1;
	}
	
	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the 
	// ALPHABET
	
	public char encrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET[(getIndex(c) + n) % 26];
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
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in 
	// the ALPHABET ARRAY
	
	public char decrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET[Math.abs((getIndex(c) - n)) % 26];
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
		String input = "ABC";
		Task2 t2 = new Task2(5);
		String encrypt = t2.encrypt(input);
		String decrypt = t2.decrypt(encrypt);
		
		
		
		
		System.out.println("Only Text");
		System.out.print("Encrypt text: " + input + " --> ");
		System.out.println(encrypt);
		System.out.print("Decrypt text: " + encrypt + " --> ");
		System.out.println(decrypt);
		
		
		
		
	}
	
}
