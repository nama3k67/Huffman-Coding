package huffmanCoding;

import java.io.FileInputStream;
import java.io.InputStream;

public class Decode {
	public String decompressFile(String fileName, HuffmanLeaf pseudoLeaf, Node root) {
		StringBuffer text = new StringBuffer(); 
		InputStream is; 
		Node p = root; 
		try {
			is = new FileInputStream(fileName); 
			int bits; 
			while (true) {
				if ((bits=is.read())==-1) {
					System.err.println("Should not happen! Trouble reading bits");
				}else {
					if ((bits&1)==0) {
						p=p.left; 
					}else {
						p=p.right; 
					}
					if (p instanceof HuffmanLeaf) {
						if (p==pseudoLeaf) {
							break; 
						}else {
							text.append(p.data); 
							p=root; 
						}
					}
				}
			}
			is.close(); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text.toString(); 
	}	
}
