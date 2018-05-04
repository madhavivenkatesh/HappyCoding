package Strings;

public class SpreadSheetColumEncode {
	
	public static void encodeCloumn(String str){
		int base = 26;
		int value = 0;
		
		for (int i=0;i<str.length();i++){
			char c = str.charAt(i);
			value = value * base + c -'A'+1;
		}
		
		System.out.println(String.valueOf(value));
		
	}
	
	public static void main(String[] args){
		encodeCloumn("ZZ");
	}

}
