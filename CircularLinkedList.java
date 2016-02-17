
public class CircularLinkedList {

	public static void main(String args[]){
		ListNode n=new ListNode(3);
		n.next =new ListNode(4);
		ListNode p=new ListNode(5);
		n.next.next =p;
		n.next.next.next =new ListNode(6);
		n.next.next.next.next =new ListNode(7);
		n.next.next.next.next.next =new ListNode(8);
		n.next.next.next.next.next.next =new ListNode(9);
		n.next.next.next.next.next.next.next =new ListNode(10);
		n.next.next.next.next.next.next.next.next=p;
		
		ListNode c= findHead(n);
		
		if(c!=null)
		{
			System.out.println(c.data);
		}else{
			System.out.println("no loop");
		}
	}
public static ListNode findHead(ListNode head){
	ListNode slow=head;
	ListNode fast=head;
	while(fast!=null && fast.next!=null){
		fast=fast.next.next;
		slow=slow.next;
		if(fast==slow){
			break;
		}
	}
	if(slow==null|| fast==null){
		return null;
	}
	
	slow=head;
	while(slow!=fast){
		slow=slow.next;
		fast=fast.next;
	}
	
	return fast;
	
}
	
}
class ListNode{
	int data;
	ListNode next;
	public ListNode(int d){
		data=d;
		next=null;
	}
}