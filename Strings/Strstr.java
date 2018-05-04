class Solution {
    public int strStr(String haystack, String needle) {
        
    int base = 26,hhash=0,thash=0 , power=0;
        
        if(needle.length()>haystack.length())
            return -1;
    
        for(int i=0;i<needle.length();i++){
            power = i==0?1:power*base;
            hhash = hhash*base+haystack.charAt(i);
            thash = thash*base+needle.charAt(i);
        }
        
        for(int i=needle.length();i<haystack.length();i++){
            
            if(hhash==thash && haystack.substring(i-needle.length(),i).equals(needle))
                return i-needle.length();
            
            hhash = hhash-haystack.charAt(i-needle.length())*power;
            hhash = hhash *base+haystack.charAt(i);
        }
        
        if(hhash==thash && haystack.substring(haystack.length()-needle.length(),haystack.length()).equals(needle))
            return haystack.length()-needle.length();
        
        return -1;
        
    }
}
