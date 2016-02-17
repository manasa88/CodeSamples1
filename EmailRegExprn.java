import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmailRegExprn {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	/**
	 * Validate hex with regular expression
	 * 
	 * @param hex
	 *            hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public static boolean validate(String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	public static void main(String args[]) {

		System.out.println(validate("mkyong@1.com"));
		System.out.println(validate("mkyong123@gmail.a"));
		/*
		 * int[] arr = { 3, 4, 5, 4, 3, 3, 3 }; int result = 0; for (int i :
		 * arr) { result ^= i; }
		 * 
		 * System.out.println(result);
		 */

		int B[] = { 1, 1, 1, 3, 3, 3, 20, 4, 4, 4 };
		int ones = 0;
		int twos = 0;
		int not_threes;
		int x;

		for (int i = 0; i < 10; i++) {
			x = B[i];
			twos |= ones & x;
			ones ^= x;
			not_threes = ~(ones & twos);
			ones &= not_threes;
			twos &= not_threes;
		}

		System.out.println("unique element " + ones);

	}

}