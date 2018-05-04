package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneMnemonic {
	
	 private static final String[] MAPPING = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	 
	 public static List<String> phoneMnemonic(String phoneNumber) {
		    char[] partialMnemonic = new char[phoneNumber.length()];
		    List<String> mnemonics = new ArrayList<>();
		    phonemenonicHelper(phoneNumber,mnemonics, 0, partialMnemonic);
		    return mnemonics;
		  }
	 
	 public static void phonemenonicHelper(String phonenum, List<String> list,int digit,char[] partailmnemonic){
		 
		 if(digit == phonenum.length())
			 list.add(new String(partailmnemonic));
		 else{
			 for(int i=0;i<MAPPING[phonenum.charAt(digit)-'0'].length();++i){
				 char c = MAPPING[phonenum.charAt(digit)-'0'].charAt(i);
				 partailmnemonic[digit]=c;
				 phonemenonicHelper(phonenum,list,digit+1,partailmnemonic);
			 }
		 }
		
	 }
	 
	 public static void main(String[] args){
		 String phonenum = "3456789345";
		 List<String> mnemonics = phoneMnemonic(phonenum);
		 for(String str:mnemonics)
			 System.out.println(str);
		 
	 }

}
