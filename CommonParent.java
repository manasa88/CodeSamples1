
public class CommonParent {
	// A Binary Tree Node

		// Utility function to create a new tree Node

		// This function returns pointer to LCA of two given values n1 and n2.
		// This function assumes that n1 and n2 are present in Binary Tree
		public static Node findLCA(Node root, int n1, int n2) {
			// Base case

			if (root == null)
				return null;
			System.out.println(root.key);
			// If either n1 or n2 matches with root's key, report
			// the presence by returning root (Note that if a key is
			// ancestor of other, then the ancestor key becomes LCA
			if (root.key == n1 || root.key == n2)
				return root;

			// Look for keys in left and right subtrees
			Node left_lca = findLCA(root.left, n1, n2);
			Node right_lca = findLCA(root.right, n1, n2);

			// If both of the above calls return Non-NULL, then one key
			// is present in once subtree and other is present in other,
			// So this node is the LCA
			if (left_lca != null && right_lca != null)
				return root;

			// Otherwise check if left subtree or right subtree is LCA
			return (left_lca != null) ? left_lca : right_lca;
		}

		// Driver program to test above functions
		public static void main(String args[]) {
			// Let us create binary tree given in the above example
			Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
			root.right.left = new Node(6);
			root.right.right = new Node(7);
			// System.out.println("LCA(4, 5) = " + findLCA(root, 4, 5).key);

			System.out.println("LCA(4, 6) = " + findLCA(root, 4, 6).key);
			/*
			 * System.out.println("LCA(3, 4) = " + findLCA(root, 3, 4).key);
			 * System.out.println("LCA(2, 4) = " + findLCA(root, 2, 4).key);
			 */

		}
	}

	class Node {
		Node left, right;
		int key;

		public Node(int key) {
			this.key = key;
			this.left = this.right = null;

		}
	};