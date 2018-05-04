package Strings;

public class Palindrome {
	
	private static boolean isPalindrome(String str) {
		int i= 0;
		int j = str.length()-1;
		while(i<j){
			if((!Character.isAlphabetic(str.charAt(i)) && i<j))
				++i;
			if((!Character.isAlphabetic(str.charAt(j)) && j>i))
				--j;
			if(str.charAt(i)!=str.charAt(j))
				return false;
			else{
				++i;
			    --j;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(String.valueOf(isPalindrome("ta b at")));
	}

}
