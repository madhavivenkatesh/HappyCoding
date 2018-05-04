package Strings;

public class RemoveAndReplace {
	
	private static String replaceremove(String s, int size) {
		int acount = 0;
		int writeIndex = 0;
		int i;
		char[] str = s.toCharArray();
		
		for (i= 0;i<size;i++){
			if(str[i]!='b'){
				str[writeIndex++] = str[i];
			}
			if(str[i]=='a'){
				++acount;
			}
		}
		System.out.println(writeIndex);
		System.out.println(acount);
		
		int cur = writeIndex - 1;
		writeIndex = writeIndex + acount -1;
		
		
		System.out.println(writeIndex);
		System.out.println(cur);
		
		while(cur>=0){
			if(str[cur]=='a'){
					str[writeIndex--]='b';
					str[writeIndex--]='b';
			}else{
				str[writeIndex--] = str[cur];
			}
			--cur;
		}
		return String.valueOf(str);
	}
	
	public static void main(String[] args){
		System.out.println(replaceremove("aabbccdd",8));
	}



}
