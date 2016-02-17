import java.io.*;
import java.util.*;

public class HRCities {
	/*
	 * public static void main(String[] args) { Enter your code here. Read input
	 * from STDIN. Print output to STDOUT. Your class should be named Solution.
	 * 
	 * Scanner sc=new Scanner(System.in); String s[]=sc.nextLine().split(" ");
	 * 
	 * int n=Integer.parseInt(s[0]); int m=Integer.parseInt(s[1]); if(n==m){
	 * System.out.println(0); } else{ String str[]=sc.nextLine().split(" "); int
	 * c[]=new int[str.length]; for(int i=0;i<str.length;i++){
	 * c[i]=Integer.parseInt(str[i]); } Arrays.sort(c); int max=0; int index=0;
	 * for(int j=0;j<n;j++){ if(index<m-1){
	 * if(Math.min(Math.abs(j-c[index]),Math.abs(j-c[index+1]))>max){
	 * max=Math.min(Math.abs(j-c[index]),Math.abs(j-c[index+1])); }
	 * if(j==c[index]){ index++; } } else{
	 * 
	 * if(Math.min(Math.abs(j-c[index]),Math.abs(j-c[index-1]))>max){
	 * max=Math.min(Math.abs(j-c[index]),Math.abs(j-c[index-1])); } }
	 * 
	 * 
	 * 
	 * } System.out.println(max);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split(" ");

		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		if (n == m) {
			System.out.println(0);
		} else {
			String str[] = sc.nextLine().split(" ");
			int c[] = new int[str.length];
			for (int i = 0; i < str.length; i++) {
				c[i] = Integer.parseInt(str[i]);
			}

			int max = 0;
			int index = 0;
			for (int j = 0; j < n; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 0; k < m; k++) {

					if (Math.abs(j - c[k]) < min) {
						min = Math.abs(j - c[k]);
					}
				}
				if (min > max) {
					max = min;
				}

			}
			System.out.println(max);
		}
	}
}
