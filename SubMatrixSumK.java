public class SubMatrixSumK {
	public int maxSum(int input[][], int k) {
		int rows = input.length;
		int cols = input[0].length;
		int temp[] = new int[rows];
		Result result = new Result();
		int c = 0;
		for (int left = 0; left < cols; left++) {
			for (int i = 0; i < rows; i++) {
				temp[i] = 0;
			}
			for (int right = left; right < cols; right++) {
				for (int i = 0; i < rows; i++) {
					temp[i] += input[i][right];
				}

				c += kadane(temp, k);
				/*
				 * if (kadaneResult.maxSum > result.maxSum) { result.maxSum =
				 * kadaneResult.maxSum; result.leftBound = left;
				 * result.rightBound = right; result.upBound =
				 * kadaneResult.start; result.lowBound = kadaneResult.end; }
				 */
			}
		}
		return c;
	}

	private int kadane(int arr[], int k) {

		int maxSoFar = 0;
		int count = 0;
		for (int x = 0; x < arr.length; x++) {
			maxSoFar = 0;
			for (int i = x; i < arr.length; i++) {
				maxSoFar += arr[i];

				if (maxSoFar == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String args[]) {
		int input[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		SubMatrixSumK saw = new SubMatrixSumK();
		int k = 14;
		System.out.println(saw.maxSum(input, k));
	}
}
