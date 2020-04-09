package huffmanCoding;

public class HuffmanNode extends Node{

	public HuffmanNode(Node left, Node right) {
		super(left.frequence + right.frequence);
		this.left=left; 
		this.right=right; 
	}
}
