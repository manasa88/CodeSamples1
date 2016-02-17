import java.util.ArrayList;


public class AllSubsets {

	public static void main(String args[]){
		
		ArrayList<Integer> myset=new ArrayList<Integer>();
		myset.add(1);
		myset.add(2);
		myset.add(3);
		
		ArrayList<ArrayList<Integer>> sb=getSubsets(myset,0);
		
	}
	
	
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,int index){
		
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size()==index){
			allsubsets=new ArrayList<ArrayList<Integer>>();
			
			allsubsets.add(new ArrayList<Integer>());
			
			
		}else{
			allsubsets=getSubsets(set, index+1);
			int item=set.get(index);
			
			ArrayList<ArrayList<Integer>> moresubsets=new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset:allsubsets){
				ArrayList<Integer> newsubset=new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
			
		}
		
		return allsubsets;
	}
}
