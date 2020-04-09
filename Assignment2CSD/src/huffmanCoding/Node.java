package huffmanCoding;

public abstract class Node implements Comparable<Node>{
	public char data; 
	public int frequence; 
	public Node left, right; 
	
	public Node(int frequence) {
		this.frequence=frequence; 
	}

	@Override
	public int compareTo(Node o) {
		return frequence - o.frequence;
	}
	
}
