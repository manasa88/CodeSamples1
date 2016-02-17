public class GraphDFS {

	public static void main(String[] args) {
		NewNode e1 = new NewNode(10);
		e1.left = new NewNode(5);
		e1.left.left = new NewNode(4);
		e1.left.right = new NewNode(6);
		e1.right = new NewNode(13);
		e1.right.left = new NewNode(12);
		e1.right.right = new NewNode(14);
		GraphDFS g = new GraphDFS();
		System.out.println("rec" + g.longestConsecutive(e1));

	}

	/*
	 * public static void dfsRec(node root) { if (root == null) return;
	 * System.out.print(root.value + " "); dfsRec(root.left);
	 * dfsRec(root.right); }
	 */

	public int longestConsecutive(NewNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(longest(root.left, 1, 1, root.value),
				longest(root.right, 1, 1, root.value));
	}

	public int longest(NewNode root, int localLen, int retLen, int preVal) {
		if (root == null) {
			return retLen;
		}

		if (root.value == preVal + 1) {
			localLen++;
			retLen = Math.max(localLen, retLen);
		} else {
			localLen = 1;
		}

		return Math.max(longest(root.left, localLen, retLen, root.value),
				longest(root.right, localLen, retLen, root.value));
	}

}

class NewNode {
	int value;
	NewNode left, right;

	public NewNode(int v) {
		this.value = v;
		left = right = null;

	}
}
