import java.util.ArrayList;


public class AllPermutations {
public static void main(String args[]){
	ArrayList<String> al=getPerms("bcd");
	
	
}

public static ArrayList<String> getPerms(String str){
	if(str==null){
		return null;
	}
	ArrayList<String> perms=new ArrayList<String>();
	if(str.length()==0){
		perms.add("");
		return perms;
		
	}
	
	char first=str.charAt(0);
	String rem=str.substring(1);
	ArrayList<String> words=getPerms(rem);
	for(String word:words){
		for(int j=0;j<=word.length();j++){
			String s=insertCharAt(word,first,j);
			perms.add(s);
		}
	}
	return perms;
	
}

public static String insertCharAt(String str,char c,int j){
	String start=str.substring(0,j);
	String end=str.substring(j);
	
	
	return start+c+end;
}

}
