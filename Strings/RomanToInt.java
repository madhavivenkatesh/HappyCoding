package Strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	
	public static int convertRomanToInt(String string) {
		Map<Character,Integer> romanmap = new HashMap<Character,Integer>(){
		{
			put('I',1);
			put('V',5);
			put('X',10);
			put('L',50);
			put('C',100);
			put('D',500);
			put('M',1000);
		}
		};
		
		int value = romanmap.get(string.charAt(string.length()-1));
		for(int i=string.length()-2;i>=0;i--){
			if(romanmap.get(string.charAt(i))>romanmap.get(string.charAt(i+1)))
				value += romanmap.get(string.charAt(i));
			else
				value -= romanmap.get(string.charAt(i));
		}
		return value;
	}
	
	public static void main(String[] args){
		System.out.println(convertRomanToInt("XIV"));
	}
}
