package huffmanCoding;

import java.io.File;
import java.util.Scanner;

public class Validation {
	private static final Scanner input = new Scanner(System.in);

	public static String checkString() {
		String check;
		while (true) {
			check = input.nextLine();
			if (check.isEmpty()) {
				System.err.println("Empty!!!");
				System.out.print("Enter again: ");
			} else {
				return check;
			}
		}
	} 
    
    public static String checkFile() {
		String fileName; 
		while (true) {
			fileName = input.nextLine(); 
			File f = new File(fileName); 
			if (f.isFile()) {
				return fileName; 
			}else {
				System.err.println("File "+ fileName+ " does not exist!");
				System.out.print("Enter again: ");
			}
		}
	}
}
