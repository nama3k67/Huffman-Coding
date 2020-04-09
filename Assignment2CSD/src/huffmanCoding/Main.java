package huffmanCoding;

import java.util.Map;

public class Main {

	public static void main(String[] args) {	
		HuffmanTree ht = new HuffmanTree(); 
		Encode encode = new Encode(); 
		Decode decode = new Decode(); 
		
 		System.out.println("Enter a string: ");
		String text = Validation.checkString(); 
		
		int[] charfreq = new int[256];//256 ~ number of character in ASCII table
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i); 
			charfreq[c]++; 
		}
		Node root = ht.buildTree(charfreq);//root tree
		Map<Character, String> encodeTable = ht.createTable(root, new StringBuffer());
		String code = encode.encodeText(text, root, encodeTable); 
		
		System.out.println("The encode string:");
		System.out.println(code);//print encode string
		
		System.out.print("Enter file name: ");
		String fileName = Validation.checkFile(); 
		
		encode.compressFile(fileName, code, ht.getPseudoCode());//compress encode string to file
		String decodeText = decode.decompressFile(fileName, ht.getPseudoLeaf(), root);//decompress file and print decode text
		
		System.out.println("The decode text after decompress file: "+ decodeText);
		
	}

}
