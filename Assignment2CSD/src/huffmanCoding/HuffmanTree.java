package huffmanCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree {
	private Map<Character, String> huffmanTable ;//To contain (character-code) respectively
	private HuffmanLeaf pseudoLeaf = new HuffmanLeaf(1);//when decoding to this leaf, stop to read file
	private String pseudoCode;
	
	public HuffmanTree() {
		huffmanTable = new HashMap<Character, String>();
	}
	public Node buildTree(int[] charFreqs) {
		PriorityQueue<Node> trees = new PriorityQueue<Node>(); 
		
		//add character and frequency for HuffmanLeave
		for (int i = 0; i < charFreqs.length; i++) {
			if (charFreqs[i]>0) {
				trees.add(new HuffmanLeaf(charFreqs[i], (char)i)); 
			}
		}
		trees.add(pseudoLeaf); 
		if (trees.isEmpty()) {
			System.err.println("Have no character to encode");
			return null; 
		}
		while (trees.size()>1) {
			Node a = trees.poll(); 
			Node b = trees.poll(); //take 2 values of smallest leave(frequency)
			
			trees.offer(new HuffmanNode(a, b)); //give HuffmanNode was created by 2 leaves to queue
		}
		
		return trees.poll(); //return tree root
	}
	
	public Map<Character, String> createTable(Node root, StringBuffer prefix) {
		if (root==null) {
			return null; 
		}
		if(root instanceof HuffmanLeaf) {//if node is a leaf, put its (data+prefix) on table
			HuffmanLeaf leaf = (HuffmanLeaf)root; 
			if (leaf==pseudoLeaf) {
				pseudoCode=prefix.toString(); //add value for pseudoCode
			}
			huffmanTable.put(leaf.data, prefix.toString());
		}else {
			HuffmanNode node = (HuffmanNode) root; 
			//traversal left
			prefix.append('0'); 
			createTable(node.left, prefix);
			prefix.deleteCharAt(prefix.length()-1);
			
			//traversal right
			prefix.append('1');
			createTable(node.right, prefix);
			prefix.deleteCharAt(prefix.length()-1);
		}
		return huffmanTable; 
	}
	public String getPseudoCode() {
		return pseudoCode;
	}
	public void setPseudoCode(String pseudoCode) {
		this.pseudoCode = pseudoCode;
	}
	public HuffmanLeaf getPseudoLeaf() {
		return pseudoLeaf;
	}
	public void setPseudoLeaf(HuffmanLeaf pseudoLeaf) {
		this.pseudoLeaf = pseudoLeaf;
	}
}
