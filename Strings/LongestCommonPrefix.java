class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length==0)
            return "";
        
        String prefix = strs[0];
        int index;
        
        for(int i=1;i<strs.length;i++){
           while(strs[i].indexOf(prefix)!=0){
               prefix=prefix.substring(0,prefix.length()-1);
               if(prefix.length()==0)
                   return "";
            }
        }
     return prefix;
    }
}

//https://leetcode.com/articles/longest-common-prefix/
