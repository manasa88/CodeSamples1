import java.util.Arrays;
import java.util.Random;

public class SegmentTrees {

	/**
	 * Segment tree supporting Sum queries and Set operations
	 * 
	 * @author jjb24
	 *
	 */

	public static boolean TESTING = false;

	public static void main(String[] args) {
		// Test SegmentTree class
		Random prng = new Random(1);

		for (int test = 0; test < 100; test++) {
			int size = prng.nextInt(100_000) + 1;

			int[] values = new int[size];
			for (int i = 0; i < values.length; i++) {
				values[i] = prng.nextInt(10_000);
			}
			int[] copy = null;
			if (TESTING) {
				copy = Arrays.copyOf(values, values.length);
			}
			SegmentTree segmentTree = new SegmentTree(values);
			for (int i = 0; i < 10_000; i++) {
				int start = prng.nextInt(values.length);
				int end = prng.nextInt(values.length - start) + start + 1;
				if (i % 2 == 0) {
					Integer stVal = segmentTree.query(start, end);

					if (TESTING) {
						int testVal = testFindSum(copy, start, end);
						if (stVal != testVal) {
							/*
							 * System.out.println("Actual: "); for (int v = 0; v
							 * < size; v++) { System.out.print(copy[v] + " "); }
							 * System.out.println();
							 * System.out.println("Tree: ");
							 * segmentTree.print(1,""); System.out.println();
							 */
							throw new RuntimeException("Test " + test
									+ " Operation " + i + " start " + start
									+ " to " + end + " Failed: Expected = "
									+ testVal + " (returned val = " + stVal
									+ ")");
						}
					}
				} else {
					int value = prng.nextInt(10_000) + 1;

					segmentTree.modify(start, end, value);

					if (TESTING) {
						for (int n = start; n < end; n++) {
							copy[n] = value;
						}
					}
				}
			}
		}
	}

	static int testFindMin(int[] array, int start, int end) {
		int retVal = array[start];
		for (int n = start + 1; n < end; n++) {
			retVal = Math.min(array[n], retVal);
		}
		return retVal;
	}

	static int testFindMax(int[] array, int start, int end) {
		int retVal = array[start];
		for (int n = start + 1; n < end; n++) {
			retVal = Math.max(array[n], retVal);
		}
		return retVal;
	}

	static int testFindSum(int[] array, int start, int end) {
		int retVal = array[start];
		for (int n = start + 1; n < end; n++) {
			retVal += array[n];
		}
		return retVal;
	}
}

class SegmentTree {

	// --------------------------------------------------------------
	//
	// To support different queries/operations, you must update the following
	// four methods
	//
	// --------------------------------------------------------------

	/**
	 * Specify how values are combined based on the supported query operation
	 * 
	 * @param left
	 *            first operand
	 * @param right
	 *            second operand
	 * @return how the operands are combined
	 */
	private Integer combineValues(Integer left, Integer right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		// For sum queries:
		return left + right;

		// For min queries:
		// return Math.min(left,right);

		// For max queries:
		// return Math.max(left,right);
	}

	/**
	 * Apply a delta value to the value stored for an entire segment depending
	 * on the supported update and query operations
	 * 
	 * @param index
	 *            subscript of segment in Tree
	 * @param segmentStart
	 *            beginning of the range (inclusive)
	 * @param segmentEnd
	 *            end of the range (exclusive)
	 */
	void applyDeltaToSegment(int index) {

		// Apply delta
		if (segmentDeltas[index] != null) {
			// Sum Query / Set Update Operation:
			segmentValues[index] = segmentRanges[index].getSize()
					* segmentDeltas[index];

			// Sum Query / Add Update Operation:
			// segmentValues[index] += segmentRanges[index].getSize() *
			// segmentDeltas[index];

			// Min or Max Query / Add Update Operation:
			// segmentValues[index] += segmentDeltas[index];

			// Min or Max Query / Set Update Operation:
			// segmentValues[index] = segmentDeltas[index];

			segmentDeltas[index] = null;
		}

	}

	/**
	 * Change the delta value at a segment based on a new one
	 * 
	 * @param index
	 *            subscript of segment in Tree
	 * @param delta
	 *            the new delta
	 * @param segmentEnd
	 *            end of the range (exclusive)
	 */
	void addDeltaToSegment(int index, Integer delta) {
		// For Set Updates:
		if (delta != null) {
			segmentDeltas[index] = delta;

			// For Add Updates:
			// if (segmentDelta[index] == null)
			// segmentDelta[index] = delta;
			// else
			// segmentDeltas[index] += delta;

		}

	}

	/**
	 * Apply a delta to a value in the array depending on the supported update
	 * operation
	 * 
	 * @param index
	 *            index in array
	 * @param delta
	 *            change in value
	 */
	private Integer getDeltaEffectOnSegment(int index) {

		if (segmentDeltas[index] == null)
			return segmentValues[index];

		// Sum Query / Set Update Operation:
		return segmentRanges[index].getSize() * segmentDeltas[index];

		// Sum Query / Add Update Operation:
		// return segmentValues[index] + segmentRanges[index].getSize() *
		// segmentDeltas[index];

		// Min or Max Query / Add Update Operation:
		// return segmentValues[index] + segmentDeltas[index];

		// Min or Max Query / Set Update Operation:
		// return segmentDeltas[index];
	}

	/***************************************************************
	 * 
	 * Portion of class that you should not need to change for most problems
	 * 
	 */
	int[] segmentValues; // Values for segments stored in tree
	Integer[] segmentDeltas; // Deltas for segments stored in tree
	Range[] segmentRanges; // Ranges of segments stored in tree

	public SegmentTree(int[] values) {

		// Find largest power of two greater than n
		int indexSize = 1;
		while (indexSize < values.length) {
			indexSize <<= 1;
		}
		indexSize <<= 1;

		segmentValues = new int[indexSize];
		segmentDeltas = new Integer[indexSize];
		segmentRanges = new Range[indexSize];

		initializeSegmentValues(1, new Range(0, values.length), values);
	}

	/**
	 * Fill in the tree at treeIndex with the initial values based on range
	 * [values[startElement]..values[endElement])
	 * 
	 * @param index
	 *            array subscript in the heap
	 * @param startElement
	 *            beginning of the range
	 * @param endElement
	 *            end of the range (not inclusive)
	 */
	private Integer initializeSegmentValues(int index, Range range, int[] values) {
		if (range.getSize() <= 0) {
			return null;
		}

		segmentRanges[index] = range;

		if (range.getSize() == 1) {
			segmentValues[index] = values[range.lbound];
		} else {
			segmentValues[index] = combineValues(
					initializeSegmentValues(getLeftChild(index),
							range.getFirstHalf(), values),
					initializeSegmentValues(getRightChild(index),
							range.getSecondHalf(), values));
		}
		return segmentValues[index];
	}

	/**
	 * Return the query value for the range [queryStart..queryEnd)
	 */
	public Integer query(int queryStart, int queryEnd) {
		Range queryRange = new Range(queryStart, queryEnd);

		pushDeltaDownToRangeFromIndex(null, queryRange, 1);

		return queryOnRangeStartingAtIndex(queryRange, 1);
	}

	private Integer queryOnRangeStartingAtIndex(Range range, int index) {
		// At empty range
		if (index >= segmentRanges.length || segmentRanges[index] == null
				|| range.isOverlapping(segmentRanges[index]) == false) {
			return null;
		}

		// Current value is contained in range
		if (range.isContaining(segmentRanges[index])) {
			return getDeltaEffectOnSegment(index);
		}

		return combineValues(
				queryOnRangeStartingAtIndex(range, getLeftChild(index)),
				queryOnRangeStartingAtIndex(range, getRightChild(index)));
	}

	// Push delta down to this range
	private void pushDeltaDownToRangeFromIndex(Integer delta, Range range,
			int index) {
		if (index >= segmentRanges.length || segmentRanges[index] == null)
			return;

		addDeltaToSegment(index, delta);

		if (!range.isOverlapping(segmentRanges[index])) {
			return;
		} else if (range.isContaining(segmentRanges[index])) {
			return;
		} else {
			pushDeltaDownToRangeFromIndex(segmentDeltas[index], range,
					getLeftChild(index));
			pushDeltaDownToRangeFromIndex(segmentDeltas[index], range,
					getRightChild(index));
		}

		applyDeltaToSegment(index);
	}

	/**
	 * Update the range [queryStart..queryEnd)
	 */
	public void modify(int rangeStart, int rangeEnd, int value) {

		Range range = new Range(rangeStart, rangeEnd);

		pushDeltaDownToRangeFromIndex(null, range, 1);

		modifyRangeWithNewValueStartingAtIndex(range, value, 1);
	}

	private Integer modifyRangeWithNewValueStartingAtIndex(Range range,
			int value, int index) {
		// Empty range or out of bounds...
		if (index >= segmentRanges.length || segmentRanges[index] == null) {
			return null;
		}

		// Within range
		if (range.isContaining(segmentRanges[index])) {
			addDeltaToSegment(index, value);
		} else if (range.isOverlapping(segmentRanges[index])) {
			segmentValues[index] = combineValues(
					modifyRangeWithNewValueStartingAtIndex(range, value,
							getLeftChild(index)),
					modifyRangeWithNewValueStartingAtIndex(range, value,
							getRightChild(index)));
		}
		return getDeltaEffectOnSegment(index);
	}

	int getLeftChild(int parent) {
		return parent << 1;
	}

	int getRightChild(int parent) {
		return (parent << 1) | 0x1;
	}

	void print(int index, String indent) {
		if (index < segmentRanges.length && segmentRanges[index] != null) {
			System.out
					.println(indent + "[" + segmentRanges[index].lbound + ".."
							+ segmentRanges[index].ubound + ") value = "
							+ segmentValues[index] + " delta = "
							+ segmentDeltas[index]);
			print(getLeftChild(index), indent + "  ");
			print(getRightChild(index), indent + "  ");
		}
	}

	static class Range {
		int lbound, ubound;

		public Range(int lbound, int ubound) {
			this.lbound = lbound;
			this.ubound = ubound;
		}

		public int getSize() {
			return ubound - lbound;
		}

		Range getFirstHalf() {
			return new Range(lbound, (lbound + ubound + 1) / 2);
		}

		Range getSecondHalf() {
			return new Range((lbound + ubound + 1) / 2, ubound);
		}

		public boolean isOverlapping(Range that) {
			return ((that.ubound > this.lbound && that.lbound <= this.lbound) || (this.ubound > that.lbound && this.lbound <= that.lbound));
		}

		public boolean isContaining(Range that) {
			return that.ubound <= this.ubound && that.lbound >= this.lbound;
		}
	}
}
