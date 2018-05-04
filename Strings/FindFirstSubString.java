package Strings;

public class FindFirstSubString {
	
	public static int findFirstSubString(String s,String t){
		if(s.length()>t.length())
			return -1;
		
		int index =-1;
		int thash = 0;
		int shash = 0;
		int powers =1;
		int base = 26;
		
		for(int i=0;i<s.length();i++){
			powers = i==0?1:powers*base;
			thash = base * thash + t.charAt(i);
			shash = base * shash + s.charAt(i);
		}
		
		for(int i= s.length();i<t.length();i++){
			
			if (thash == shash && t.substring(i - s.length(), i).equals(s))
				return i-s.length();
			
			thash -= t.charAt(i-s.length())*powers;
			thash = thash * base + t.charAt(i);
		}	
		
			if(thash==shash && t.substring(t.length()-s.length()).equals(s))
				return t.length()-s.length();
		
		return index;
		
	}
	
	public static void main(String[] args){
		int subStringIndex = findFirstSubString("RAMA","KSHEERAMADHU");
		System.out.println(Integer.valueOf(subStringIndex));
	}

}
