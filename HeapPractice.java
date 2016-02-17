
public class HeapPractice {

	 static int[] harr;     // pointer to array of elements in heap
	    int capacity; // maximum possible size of min heap
	    int heap_size; // Current number of elements in min heap
//To minheapify subtree rooted with index i
	    int parent(int i) { return (i-1)/2; }
	    int left(int i) { return (2*i + 1); }
	    int right(int i) { return (2*i + 2); }
	 
	    // extracts root (minimum) element
	    int getMin() { return harr[0]; } // Returns minimum
	
	 
	public HeapPractice(int a[], int size)
	{
	    heap_size = size;
	    harr = a;  // store address of array
	    int i = (heap_size - 1)/2;
	    while (i >= 0)
	    {
	        MinHeapify(i);
	        i--;
	    }
	}
	 
	// Method to remove minimum element (or root) from min heap
	public int extractMin()
	{
	    if (heap_size == 0)
	        return Integer.MAX_VALUE;
	 
	    // Store the minimum vakue.
	    int root = harr[0];
	 
	    // If there are more than 1 items, move the last item to root
	    // and call heapify.
	    if (heap_size > 1)
	    {
	        harr[0] = harr[heap_size-1];
	        MinHeapify(0);
	    }
	    heap_size--;
	 
	    return root;
	}
	 
	// A recursive method to heapify a subtree with root at given index
	// This method assumes that the subtrees are already heapified
	public void MinHeapify(int i)
	{
	    int l = left(i);
	    int r = right(i);
	    int smallest = i;
	    if (l < heap_size && harr[l] < harr[i])
	        smallest = l;
	    if (r < heap_size && harr[r] < harr[smallest])
	        smallest = r;
	    if (smallest != i)
	    {
	        swap(i,smallest);
	        MinHeapify(smallest);
	    }
	}
	 
	// A utility function to swap two elements
	public static void swap(int x, int y)
	{
	    int temp = harr[x];
	    harr[x] = harr[y];
	    harr[y] = temp;
	}
	 
	// Function to return k'th smallest element in a given array
	public static int kthSmallest(int arr[], int n, int k)
	{
	    // Build a heap of n elements: O(n) time
		HeapPractice mh=new HeapPractice(arr, n);
	 
	    // Do extract min (k-1) times
	    for (int i=0; i<k-1; i++)
	        mh.extractMin();
	 
	    // Return root
	    return mh.getMin();
	}
	 
	// Driver program to test above methods
	public static void main(String[] args)
	{
	    int arr[] = {12, 3, 5, 7, 19};
	    int n =5, k = 2;
	    System.out.println(kthSmallest(arr, n, k));
	    
	  
	  
	}
}
