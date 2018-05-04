package Strings;

public class InterConversion {
	
	public static Integer convertoInt(String s){
		int base= 10;
		int value = 0;
		
		for(int i=s.charAt(0)=='-'?1:0;i<s.length();i++){
			value = value*base+s.charAt(i)-'0';
		}
		
		return s.charAt(0)=='-'? -value:value;
		
		
	}
	
	public static String convertoString(Integer num){
		StringBuilder res = new StringBuilder();
		int reminder = 0;
		boolean isnagative =false;
		
		 if(num<0){
			 isnagative = true;
		 }
					
		do{
			reminder = ('0'+Math.abs(num %10));
			num = num/10;
			res.append((char)(reminder));
		}while(num!=0);
		
		if(isnagative){
			res.append("-");
		}
		return res.reverse().toString();
	}
	
	public static void main(String[] args){
		System.out.println(convertoInt("-678"));
		System.out.println(convertoString(-589));
		
	}

}
