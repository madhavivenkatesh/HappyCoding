package Strings;

public class LookSay {
	
	public static String generatenth(String s){
		StringBuilder result = new StringBuilder();
		
		for(int i=0;i<s.length();i++){
			int count =1;
		      while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
		          ++i;
		          ++count;
		        }
		        result.append(count);
		        result.append(s.charAt(i));
		      }
		      return result.toString();
	}
	
	public static void main(String[] args){
		String s = "1";
		for(int i=0;i<1;i++){
			s = generatenth(s);
		}
		System.out.println(s);
	}

}

