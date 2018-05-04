package Strings;

public class EncodeDecode {
	
	public static String encode(String str){
		StringBuilder res = new StringBuilder();
		int count=0;
		
		for(int i=0;i<str.length();i++){
		    count = 1;
			while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
				++count;
				++i;
			}
			res.append(count);
			res.append(str.charAt(i));
		}
		
		return res.toString();
	}
	
	public static String decode(String str){
		StringBuilder sb = new StringBuilder();
		int count=0;
		for(int i=0;i<str.length();i++){
			if(Character.isDigit(str.charAt(i))){
				count = Integer.valueOf(str.charAt(i)-'0');
			}else if(Character.isAlphabetic(str.charAt(i))){
				while(count>0){
					sb.append(str.charAt(i));
					--count;
				}
			}
			
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		String encodedstring = encode("aaabbcdee");
		System.out.println(encodedstring);
		System.out.println(decode(encodedstring));
	}

}
