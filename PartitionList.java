import java.util.Arrays;
import java.util.LinkedList;


public class PartitionList {
public static void main(String args[]){
	LinkedList<Integer> ls=new LinkedList<Integer>();
	ls.add(1);
	ls.add(3);
	ls.add(7);
	ls.add(9);
	ls.add(5);
	ls.add(2);

	System.out.println(ls);
	int k=3;
	int st=0;
	int end=ls.size()-1;
	while(end>st){
		while(ls.get(st)<k){
			st++;
		}
		while(ls.get(end)>k){
			end--;
		}
		if(ls.get(st)==k){
			swap(ls,st,ls.size()-1);
			System.out.println(ls);
		}else{
			swap(ls,st,end);
			System.out.println(ls);
		}
	
	}

swap(ls,end,ls.size()-1);
System.out.println(ls);
	
	
}

public static void swap(LinkedList<Integer> ls,int i, int j)
{
	
	int elei=ls.get(i);
	int elej=ls.get(j);
	ls.set(j,elei);
	ls.set(i,elej);
	
}
}
