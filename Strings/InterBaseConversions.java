package Strings;

public class InterBaseConversions {
	
	public static void baseconversions(String s,int b1,int b2){
		
		int base= b1;
		int value = 0;
		
		for(int i=s.charAt(0)=='-'?1:0;i<s.length();i++){
			value = value*base+s.charAt(i)-'0';
		}
		
		value = s.charAt(0)=='-'? -value:value;
		
		System.out.println(value);
		
		StringBuilder res = new StringBuilder();
		int reminder = 0;
		boolean isnagative =false;
		
		 if(value<0){
			 isnagative = true;
		 }
					
		do{
			reminder = Math.abs(value % b2);
			if (reminder >= 10){
				res.append((char)('A'+(value % b2 - 10)));
			}else{
				res.append((char)('0'+(value % b2)));
			}
			value = value/b2;
			
		}while(value!=0);
		
		if(isnagative){
			res.append("-");
		}
		
		System.out.println(res.reverse().toString());
		
	}
	
	public static void main(String[] args){
		baseconversions("615",7,13);
	}

}
