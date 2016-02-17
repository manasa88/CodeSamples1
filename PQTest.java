import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQTest {
	static class PQsort implements Comparator<Integer> {

		@Override
		public int compare(Integer one, Integer two) {
			return two - one;
		}
	}

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		PQsort pqs = new PQsort();
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, pqs);

		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		for (int x : ia) {
			pq.offer(x);

		}
		for (int x : ia) {
			pq2.offer(x);

		}
		int size = pq.size();
		System.out.println(pq);
		for (int i = 0; i < size; i++) {
			System.out.println(pq.poll());
		}
		System.out.println(pq2);
		for (int i = 0; i < size; i++) {
			System.out.println(pq2.poll());
		}
		ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
		ad.offer(12);
		ad.offerFirst(13);
		ad.offer(12);
		System.out.println(ad);

	}
}
