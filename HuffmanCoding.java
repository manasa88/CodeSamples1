import java.util.ArrayList;

public class HuffmanCoding {

	public static void decode(String S, Node root) {
		int len = 0;
		ArrayList<Character> al = new ArrayList<Character>();
		Node temp = root;
		while (len < S.length()) {

			char c = S.charAt(len);
			if (c == '1') {
				root = root.right;
			} else {
				root = root.left;
			}			
			if (root.left == null && root.right == null) {
				al.add(root.data);
				root = temp;
			} 
			len++;
		}
		for (char ch : al) {
			System.out.print(ch);
		}

	}
	public static void main(String[] args){
		Node n=new Node(5,'\0');
		n.left=new Node(2,'\0');
		n.right=new Node(3,'A');
		n.left.left=new Node(1,'B');
		n.left.right=new Node(1,'C');
		decode("1001011",n);
	}
}

class Node {
	public int frequency; // the frequency of this tree
	public char data;
	public Node left, right;
	public Node(int f,char d){
		this.frequency=f;
		this.data=d;
		left=right=null;
	}
}