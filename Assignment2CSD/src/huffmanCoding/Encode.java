package huffmanCoding;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

public class Encode {
	public String encodeText (String text, Node root, Map<Character, String> encodeTable) {//return a encode string
		StringBuffer code = new StringBuffer();//to initialize a code string  
		for (int i = 0; i<text.length(); i++) {
			char c = text.charAt(i); 
			code.append(encodeTable.get(c)); 
		}
		
		return code.toString(); 
	}
	
	public void compressFile(String fileName, String code, String pseudoCode) {
		code+=pseudoCode; 
		char[] arrCode = code.toCharArray(); 
		OutputStream os; 
		try {
			os = new FileOutputStream(fileName);
			for (int i = 0; i < arrCode.length; i++) {
				os.write(arrCode[i]);
			}
			os.close();
		} catch (Exception e) {
		}
	}
}
