package Caesar;

public class Task3 {
	public static final char[] ALPHABET_NUMS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1',
			'2',  '3',  '4',  '5',  '6',  '7',  '8', '9'};
	
	private int n;// shift steps (right shift)

	public Task3(int shiftSteps) {
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
	// Encrypt: En(x) = (x + n) mod 36. x represents the index of c in the 
	// ALPHABET
	
	public char encrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET_NUMS[(getIndex(c) + n) % 36];
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
	// Decrypt: Dn(x) = (x – n) mod 36. x represents the index of c in 
	// the ALPHABET ARRAY
	
	public char decrypt(char c) {
		if (getIndex(c) != -1) {
			return ALPHABET_NUMS[Math.abs((getIndex(c) - n)) % 36];
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
		String input = "ABC123";
		Task3 t3 = new Task3(5);
		String encrypt = t3.encrypt(input);
		String decrypt = t3.decrypt(encrypt);
		
		
		
		
		System.out.println("Text And Nums: ");
		System.out.print("Encrypt text: " + input + " --> ");
		System.out.println(encrypt);
		System.out.print("Decrypt text: " + encrypt + " --> ");
		System.out.println(decrypt);
	}
}
