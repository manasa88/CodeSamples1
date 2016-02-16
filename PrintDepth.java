import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class PrintDepth {

	public static void main(String args[]) {
		TreeNode n = new TreeNode(1);
		n.left = new TreeNode(2);
		n.right = new TreeNode(3);
		n.left.left = new TreeNode(4);
		n.left.right = new TreeNode(5);
		n.right.left = new TreeNode(6);
		depthOrder(n);
	}

	public static void depthOrder(TreeNode r) {
		Queue<TreeNode> currlist = new LinkedList<TreeNode>();
		Queue<TreeNode> nextlist = new LinkedList<TreeNode>();

		if (r == null)
			return;

		currlist.add(r);
		while (!currlist.isEmpty()) {
			Iterator<TreeNode> itr = currlist.iterator();
			while (itr.hasNext()) {
				TreeNode tn = itr.next();
				if (tn.left != null)
					nextlist.add(tn.left);
				if (tn.right != null)
					nextlist.add(tn.right);
				System.out.print(tn.value + " ");
			}
			currlist = nextlist;
			nextlist = new LinkedList<TreeNode>();
			System.out.println();
		}

	}
}