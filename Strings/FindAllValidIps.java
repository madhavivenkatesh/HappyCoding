package Strings;

import java.util.ArrayList;
import java.util.List;

import sun.org.mozilla.javascript.internal.regexp.SubString;

public class FindAllValidIps {
	
	public static List<String> findvalidips(String str){
		List<String> iplist = new ArrayList<String>();
		for(int i=1;i<str.length() && i<4;i++){
			String firstpart = str.substring(0,i);
			if(isvalidpart(firstpart)){
				for(int j=1;j+i<str.length() && j<4;j++){
					String secondpart = str.substring(i,i+j);
					if(isvalidpart(secondpart)){
						for(int k=1;j+i+k<str.length() && k<4;j++){
							String thirdpart = str.substring(i+j,i+j+k);
							String forthpart = str.substring(i+j+k);
							if(isvalidpart(thirdpart) && isvalidpart(forthpart))
								iplist.add(firstpart+"."+secondpart+"."+thirdpart+"."+forthpart);
					}
				}
			}
		}
	}
		return iplist;
}
	
	public static boolean isvalidpart(String str){
		if(str.length()>3)
			return false;
		
		if(str.startsWith("0") && str.length()>1)
			return false;
		

		int val = Integer.parseInt(str);
	    return val <= 255 && val >= 0;
		
	}
	
	public static void main(String[] args){
		List<String> iplist = new ArrayList<String>();
		iplist = findvalidips("255255255255");
		for(String str:iplist)
			System.out.println(str);
		
	}

}
