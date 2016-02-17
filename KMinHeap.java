import java.util.PriorityQueue;


public class KMinHeap {
	static int maxSize=2;
	static PriorityQueue<Integer> minHeap= new PriorityQueue<Integer>();
	// Driver program to test above methods
	 
	 public static void add(int data)
	 {
		 if(minHeap.size() < maxSize){
			 minHeap.offer(data);
		 }
		 else if(minHeap.peek()<data){
			 minHeap.poll();
			 minHeap.offer(data);
			 
		 }
	 }
	public static void main(String[] args)
	{
		int arr[] = {12, 3, 5, 7, 19};
		for(int a:arr){
			add(a);
		}
		System.out.println(minHeap.peek());
	    //System.out.println(kthSmallest(arr, n, k));
	    
	  
	  
	}
}
