package Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputeAlternation {
	
	public static List<Integer> alternation(List<Integer> list){
		for(int i=0;i+1<list.size();i++){
			if(i%2==0 && list.get(i)>list.get(i+1) && i+1<list.size() || 
					i%2!=0 && list.get(i)<list.get(i+1) && i+1<list.size() ){
				Collections.swap(list,i,i+1);
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		List<Integer> res = alternation(Arrays.asList(2,3,1,5,6,11,12,13,14));
		for(int i:res)
			System.out.println(i);
	}

}
