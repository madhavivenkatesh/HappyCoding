/*Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/

class Solution {
    
    Map<Character,Integer> magmap = new HashMap<Character,Integer>();
    
    public boolean canConstruct(String ransomNote, String magazine) {
        
        for(int i=0;i<magazine.length();i++){
            Character ch = magazine.charAt(i);
            if(!magmap.containsKey(ch)){
                magmap.put(ch,1);
            }else{
                int count =  magmap.get(ch)+1;
                magmap.put(ch,count);
            }
        }
        for(int j=0;j<ransomNote.length();j++){
            Character rch = ransomNote.charAt(j);
            if(!magmap.containsKey(rch))
                return false;
            else
            {
               magmap.put(rch,magmap.get(rch)-1); 
               if(magmap.get(rch)==0)
                  magmap.remove(rch); 
            }
        }
        
        return true;
        
    }
}
