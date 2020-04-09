package huffmanCoding;

public class HuffmanLeaf extends Node{

	public HuffmanLeaf(int frequence, char data) {
		super(frequence);
		this.data=data; 
	}
	public HuffmanLeaf(int freq) {
		super(freq);
	}
}
