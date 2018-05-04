package Strings;

public class ReverseWords {
	
	public static void reverseWords(char[] s1){
		System.out.println(reverse(s1,0,s1.length-1));
		
		//System.out.println(s1);
		int begin =0;
		int end =0;
		int spacecount =0;
		
		for(int i=0;i<s1.length;i++)
			if(s1[i] == ' ')
				++spacecount;
		System.out.println(spacecount);
			
		
			for(int i=0;i<s1.length;i++){
				begin =i;
				while(s1[i]!=' '&&i<s1.length-1){
					++i;
				}
				if(spacecount>0){
					--spacecount;
					System.out.println(reverse(s1,begin,i-1));
				}
			}
			System.out.println(reverse(s1,begin,s1.length-1));
	}
	
	public static String reverse(char[] str,int start,int finish){
	
		int  i = start;
		int j = finish;
		
		while(i<j){
			char temp=str[i];
			str[i]=str[j];
			str[j]= temp;
			++i;
			--j;
		}
		
		return new String(str);
		
	}
	
	public static void main(String[] args){
		String s1 = "Bob tells story";
		reverseWords(s1.toCharArray());
	}

}
