import java.util.Scanner;
import java.util.StringTokenizer;


public class StringSplit {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
         Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    StringTokenizer st = new StringTokenizer(s,"[!,?.\\_' @]+");
    System.out.println(st.countTokens());
    while (st.hasMoreTokens()) {
        System.out.println(st.nextToken());
    }
    }
}
