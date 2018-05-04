package Arrays;

import java.util.Arrays;
import java.util.List;

public class AdvanceThroughArray {
	
	public static boolean canAdvance(List<Integer> list){
		int furthersofar = 0;
		for(int i=0;i<furthersofar && furthersofar<list.size();i++){
			furthersofar = Math.max(furthersofar, i+list.get(i));
		}
		
		return furthersofar>=list.size();
	}
	
	public static void main(String[] args){
		System.out.println(canAdvance(Arrays.asList(3,2,0,0,2,01)));
	}

}
