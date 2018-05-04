/*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character,Integer> uniquemap = new LinkedHashMap<Character,Integer>();
        
        for(int i=0;i<s.length();i++){
            if(!uniquemap.containsKey(s.charAt(i)))
                uniquemap.put(s.charAt(i),1);
            else{
                uniquemap.put(s.charAt(i),uniquemap.get(s.charAt(i))+1);
            }
        }
        
        for(Map.Entry<Character,Integer> entry:uniquemap.entrySet()){
            if(entry.getValue()==1){
                int index = s.indexOf(entry.getKey());
                return index;
            }
        }
        
        return -1;
    }
}
