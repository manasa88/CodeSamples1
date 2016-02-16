import java.util.Stack;

public class ExpressionTree {
	public static boolean isOperator(char c) {

		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	// Utility function to do inorder traversal
	public static void inorder(et t) {
		if (t != null) {
			inorder(t.left);
			System.out.print(t.value);
			inorder(t.right);
		}
	}

	// A utility function to create a new node
	public static et newNode(char v) {
		et temp = new et();
		temp.left = temp.right = null;
		temp.value = v;
		return temp;
	};

	// Returns root of constructed tree for given
	// postfix expression
	public static et constructTree(char postfix[]) {
		Stack<et> st = new Stack<>();
		et t, t1, t2;

		// Traverse through every character of
		// input expression
		for (int i = 0; i < postfix.length; i++) {
			// If operand, simply push into stack
			if (!isOperator(postfix[i])) {
				t = newNode(postfix[i]);
				st.push(t);
			} else // operator
			{
				t = newNode(postfix[i]);

				// Pop two top nodes
				// t1 = (et)st.peek(); // Store top
				t1 = st.pop(); // Remove top
				// t2 = st.peek();
				t2 = st.pop();

				// make them children
				t.right = t1;
				t.left = t2;

				// Add this subexpression to stack
				st.push(t);
			}
		}

		// only element will be root of expression
		// tree
		t = st.peek();
		st.pop();

		return t;
	}

	// Driver program to test above
	public static void main(String[] args) {
		String str = "ab+ef*g*-";

		char postfix[] = str.toCharArray();
		et r = constructTree(postfix);
		System.out.println("infix expression is \n");
		inorder(r);

	}
}

// An expression tree node
class et {
	char value;
	et left, right;

}

// A utility function to check if 'c'
// is an operator

