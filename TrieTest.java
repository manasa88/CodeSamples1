import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class TrieTest {
	static HashMap<String, ArrayList<String>> nodes=new HashMap<String,ArrayList<String>>();
public static void main(String args[])
{
	 Scanner sc = new Scanner(System.in);
	    int i = Integer.parseInt(sc.nextLine());
	    ArrayList<String> al=new ArrayList<String>();
	   int count=0;
	   boolean checkPoss = true;
	       for(int j=0;j<i;j++)
	           {
	al.add(sc.nextLine());
}
	       int m = Integer.parseInt(sc.nextLine()); 
	       for(int j=0;j<m;j++)
           {
	    	  String s=sc.nextLine();
	    	  String[] s1=s.split(" ");
	    	  ArrayList<String> value = nodes.get(s1[0]);
	    	  if (value != null) {
	    		  if(!value.contains(s1[0]))
	    		  {
    			  value.add(s1[0]);    			  
    			  nodes.put(s1[1],value);
	    		  }
	    		  
	    	  } else {
	    		  if(!s1[0].equals(s1[1]))
	    		  {
	    			  ArrayList<String> b=new ArrayList<>();
	    			  b.add(s1[0]);
	    			  nodes.put(s1[1],b );

	    		  }
	    		  else
	    		  {
	    			  checkPoss=false;
	    			  break;
	    		  }
	    		 	    	     
	    	  }
}
	       if(checkPoss)
	       {
	       Iterator it = nodes.entrySet().iterator();
	       while (it.hasNext()) {
	           Map.Entry pair = (Map.Entry)it.next();
	            if(count<((ArrayList<String>) pair.getValue()).size())
	            {
	            	count=((ArrayList<String>) pair.getValue()).size();	            	
	            }
	           it.remove(); // avoids a ConcurrentModificationException
	       }
	       System.out.print(count+1);
	       }
	       else{
	    	   System.out.println("never");
	       }
}
}

