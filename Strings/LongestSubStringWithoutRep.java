class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int maxlen = Integer.MIN_VALUE;
        int startindex=0;
        int endindex=0,i;
        
        if(s==null||s.length()==0)
            return 0;
        
        for(i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }else{
                if(map.get(ch)>=startindex){
                    maxlen = Math.max(maxlen,i-startindex);
                    startindex = map.get(ch)+1;
                    
                }
                map.put(ch,i);
            }
        }
        
        return Math.max(maxlen,i-startindex);
    }
}
