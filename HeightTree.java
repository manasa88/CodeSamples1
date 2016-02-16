import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class HeightTree {
	
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            MyHNode root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert1(root,data);
            }
            int height=getHeight(root);
           
            System.out.println(height);
            //printTree(root);
        }
	private static int getHeight(MyHNode root) {
		  int maxHeight=0;
	        Stack<MyHNode> sc=new Stack<MyHNode>();
	        sc.push(root);
	        int height=1;
	        while(!sc.isEmpty()){
	            
	        	MyHNode n=sc.pop();
	            if(n.left==null && n.right==null){
	                if(height>maxHeight){
	                    maxHeight=height;
	                   }
	                height=0;
	            }else{
	            	if(n.left!=null){
	            		sc.push(n.left);
	            	}
	            	if(n.right!=null){
	            		sc.push(n.right);
	            	}
	                height++;
	            }
	        }
	        return maxHeight;
	        
	}
	private static MyHNode insert1(MyHNode root, int data) {
		// TODO Auto-generated method stub
		 if(root==null){
	            return new MyHNode(data);
	        }
	        else{
	        	MyHNode cur=new MyHNode(data);
	            if(data<=root.data){
	                cur=insert1(root.left,data);
	                root.left=cur;
	            }
	            else{
	                cur=insert1(root.right,data);
	                root.right=cur;
	            }
	            return root;
	        }
	}
	public static void printTree(MyHNode tmpRoot) {

		Queue<MyHNode> currentLevel = new LinkedList<MyHNode>();
		Queue<MyHNode> nextLevel = new LinkedList<MyHNode>();

		currentLevel.add(tmpRoot);

		while (!currentLevel.isEmpty()) {
			Iterator<MyHNode> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				MyHNode currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				System.out.print(currentNode.data + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<MyHNode>();

		}

	}
	
}
class MyHNode{
	MyHNode left,right;
    int data;
    MyHNode(int data){
        this.data=data;
        left=right=null;
    }
}