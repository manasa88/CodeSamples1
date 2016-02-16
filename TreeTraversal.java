import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {
	
	static MyNode root=null;
	static boolean found;
	static char target;
	public static void main(String[] args) {
		MyNode e1 = new MyNode('a');
		e1.left = new MyNode('b');
		e1.left.left = new MyNode('d');
		e1.left.right = new MyNode('e');
		e1.right = new MyNode('c');
		e1.right.left = new MyNode('f');
		e1.right.right = new MyNode('g');
		e1.left.left.left = new MyNode('i');
		preorder(e1);
		System.out.println();
		inorderTrav(e1);
		/*System.out.println();
		dfs(e1);
		System.out.println();
		printTree(e1);

		System.out.println("rec");
		dfsRec(e1);
		System.out.println();
		System.out.println("lca  "+lca(e1,'i','e').value);*/
		root=e1;
		System.out.println();
		System.out.println(inOrderSucc(e1.right.right).value);
	}

	public static void preorder(MyNode r) {
		if (r == null) {
			return;
		}
		System.out.print(r.value + " ");
		preorder(r.left);
		preorder(r.right);
	}

	public static void inorderTrav(MyNode r) {
		if (r == null) {
			return;
		}
		inorderTrav(r.left);
		System.out.print(r.value + " ");
		inorderTrav(r.right);
	}

	public static void dfs(MyNode root) {
		if (root == null)
			return;
		Stack<MyNode> res = new Stack<MyNode>();
		res.push(root);
		while (!res.isEmpty()) {
			MyNode top = res.pop();
			System.out.print(top.value + " ");

			if (top.right != null)
				res.push(top.right);
			if (top.left != null)
				res.push(top.left);

		}
	}

	public static void dfsSearch(MyNode root, MyNode n1, MyNode n2) {
		if (root == null)
			return;
		Stack<MyNode> res = new Stack<MyNode>();
		res.push(root);
		while (!res.isEmpty()) {
			MyNode top = res.pop();
			// System.out.print(top.value + " ");

			if (top.right != null)
				res.push(top.right);
			if (top.left != null)
				res.push(top.left);

		}
	}

	public static void bfs(MyNode root) {
		Queue<MyNode> res = new LinkedList<MyNode>();
		if (root == null)
			return;

		res.add(root);
		while (!res.isEmpty()) {
			MyNode top = res.poll();
			System.out.print(top.value + " ");
			if (top.left != null)
				res.add(top.left);
			if (top.right != null)
				res.add(top.right);

		}
	}

	public static void dfsRec(MyNode root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		dfs(root.left);
		dfs(root.right);
	}

	public static void printTree(MyNode tmpRoot) {

		Queue<MyNode> currentLevel = new LinkedList<MyNode>();
		Queue<MyNode> nextLevel = new LinkedList<MyNode>();

		currentLevel.add(tmpRoot);

		while (!currentLevel.isEmpty()) {
			Iterator<MyNode> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				MyNode currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				System.out.print(currentNode.value + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<MyNode>();

		}

	}

	static MyNode lca(MyNode root, char v1, char v2) {
		Stack<MyNode> s = new Stack<MyNode>();
		Stack<MyNode> parent = new Stack<MyNode>();
		if (root != null) {
			s.push(root);

		}
		while (!s.isEmpty()) {
			MyNode n1 = s.pop();

			if (n1.value == v1) {
				break;
			}
			if (n1.left == null && n1.right == null) {
				parent = new Stack<MyNode>();
			} else {
				parent.push(n1);
			}
			if (n1.right != null) {
				s.push(n1.right);

			}

			if (n1.left != null) {

				s.push(n1.left);

			}

		}
		while (!parent.isEmpty()) {
			MyNode newNode = parent.pop();
			if (!isSubtree(newNode, v1, v2)) {
				continue;
			}
			return newNode;
		}
		return root;

	}

	public static boolean isSubtree(MyNode newNode, char v1, char v2) {
		boolean hasN1 = false, hasN2 = false;

		if (newNode == null)
			return false;
		Stack<MyNode> res = new Stack<MyNode>();
		res.push(newNode);
		while (!res.isEmpty()) {
			MyNode top = res.pop();
			// System.out.print(top.value + " ");
			if (top.value == v1) {
				hasN1 = true;

			}
			if (top.value == v2) {
				hasN2 = true;

			}
			if (top.right != null)
				res.push(top.right);
			if (top.left != null)
				res.push(top.left);

		}

		return hasN1 && hasN2;

	}
	public static MyNode inOrderSucc(MyNode n){
		
		if(n==null) return null;
		if(n.right!=null){
			return lefmostNode(n.right);
		}else{
			MyNode q=n;
			MyNode x=findParent(q.value);
			while(x!=null && x.left!=q){
				q=x;
				x=findParent(x.value);
			}
			return x;
			
		}
		
	}
	
	public static MyNode lefmostNode(MyNode n){
		if(n==null){
			return null;
		}
		while(n.left!=null){
			n=n.left;
		}
		return n;
		
	}
	
	private static MyNode internalFindParent(MyNode node, MyNode parent,char target){
		  if (found) return parent;
		  if (node.value == target) {
		    found = true;
		    return parent;
		  }
		  if (node.left == null) return null;
		  MyNode temp = internalFindParent(node.left, node,target);
		  if(temp != null)
		    return temp;
		  if (node.right == null) return null;
		  temp = internalFindParent(node.right, node,target);
		  if(temp != null)
		    return temp;
		  return null;
		}
	public static MyNode findParent(char target){
		  found = false;
		  //this.target = target;
		  return internalFindParent(root, null,target);
		}

}

class MyNode {
	char value;
	MyNode left, right;

	public MyNode(char v) {
		this.value = v;
		left = right = null;

	}
}