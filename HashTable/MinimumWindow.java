/*Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.*/

class Solution {
    
    private class SubArray{
        int start;
        int end;
        public SubArray(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public String minWindow(String s, String t) {
        
        if(t.length()>s.length())
            return "";
        
        Map<Character,Integer> keywordsToCover = new HashMap<Character,Integer>();
        for(int i=0;i<t.length();i++){
            if(!keywordsToCover.containsKey(t.charAt(i)))
                keywordsToCover.put(t.charAt(i),1);
            else
                keywordsToCover.put(t.charAt(i),keywordsToCover.get(t.charAt(i))+1);
        }
        
        SubArray subarry = new SubArray(-1,-1);
        int remtocover = t.length();
        System.out.println(remtocover);
        /*for(char c:keywordsToCover.keySet()){
            System.out.println(c+" "+keywordsToCover.get(c));
        }*/
        
        for(int left=0,right=0;right<s.length();++right){
            Integer keywordcount = keywordsToCover.get(s.charAt(right));
            if(keywordcount!=null){
                keywordsToCover.put(s.charAt(right),--keywordcount);
                if(keywordcount>=0){
                     --remtocover;
                }
            }
            
            while(remtocover==0){
                //System.out.println(left+" "+right);
                if((subarry.start==-1 && subarry.end==-1) || right-left<subarry.end-subarry.start){
                    subarry.start = left;
                    subarry.end = right;
                }
                
                keywordcount = keywordsToCover.get(s.charAt(left));
                if(keywordcount!=null){
                    keywordsToCover.put(s.charAt(left),++keywordcount);
                    if(keywordcount>0){
                       ++remtocover; 
                    }
                }
                 ++left;
            }
           
        }
        
        //System.out.println(subarry.start+" "+subarry.end);
        
        if(subarry.start!=-1 && subarry.end!=-1)
            return s.substring(subarry.start,subarry.end+1);
        
        return "";
    }
}
