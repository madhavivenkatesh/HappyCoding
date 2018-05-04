class Solution {
    public String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();
        int start=0,end=s.length();
        
        for(int i=start;i<s.length();i++){
            int index = getindex(start,end,s);
            if(index != -1){
                String revword = reverseWord(s.substring(start,index));
                sb.append(revword);
                sb.append(" "); 
                start = index+1;
            }else
                break;
            
        }
        
        sb.append(reverseWord(s.substring(start,end)));
        return sb.toString();
    }
    
    public int getindex(int start,int end,String str){
        for(int i=start;i<end;i++){
            if(str.charAt(i)==' ')
                return i;
        }
        
        return -1;
    }
    
    public String reverseWord(String str){
        char[] chararr = str.toCharArray();
        int i=0,j=chararr.length-1;
        while(i<j){
            char temp = chararr[i];
            chararr[i] = chararr[j];
            chararr[j] = temp;
            i++;
            --j;
        }
        
        return String.valueOf(chararr);
    }
}
