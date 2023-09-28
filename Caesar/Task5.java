package Caesar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Task5 {
	public static final char[] ALPHABET_NUMS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','a', 'b', 'c',
			'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1',
			'2',  '3',  '4',  '5',  '6',  '7',  '8', '9'};
	
	private int n;// shift steps (right shift)

	public Task5(int shiftSteps) {
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
	
	
	public void encrypt(String scrFile, String desFile) {

		try {
			File f = new File("E:\\eclipse-workspace(1)\\CauTrucDuLieuLab\\src\\Caesar\\desFile.txt");
			BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
			OutputStream os = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			String line = null;
			while (true) {
				line = br.readLine();
				String encrypt = encrypt(line);	
//				String decrypt = decrypt(encrypt);
				if (line == null) {
					break;	
				} else {
					System.out.println();
					oos.writeObject(encrypt);
					oos.flush();
					oos.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void encrypt1(String scrFile, String desFile) {
		// ghi du lieu
		try {
			OutputStream os = new FileOutputStream(desFile);
			
		} catch(Exception e) {
			
		}
		
		// doc du lieu
		try {
			InputStream is = new FileInputStream(scrFile);
			ObjectInputStream ois = new ObjectInputStream(is);
			String line = null;
			while (true) {
				String encrpyt = (String) ois.readObject();
				if (encrpyt != null) {
					
				}
			}
			
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static void main(String[] args) {
		
		
		

     
	}

}
