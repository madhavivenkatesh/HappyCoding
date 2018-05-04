/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        String[] tokens = str.split(" ");
        Map<Character,String> patternmap = new HashMap<Character,String>();
        
        if(tokens.length!=pattern.length())
            return false;
        
        for(int i=0;i<pattern.length();i++){
            if(!patternmap.containsKey(pattern.charAt(i))){
                if(!patternmap.containsValue(tokens[i]))
                    patternmap.put(pattern.charAt(i),tokens[i]);
                else
                    return false;
            }
                
            else{
                if(!patternmap.get(pattern.charAt(i)).equals(tokens[i]))
                    return false;
                
                //if(patternmap.containsValue(tokens[i]) && pattern.charAt(i)!=patternmap.getKey(tokens[i]))
                    //return false;
            }
        }
        
        for(char key:patternmap.keySet())
            System.out.println(key+" "+patternmap.get(key));
        
    /*    String[] expectedres = new String[tokens.length];
        int index=0;
        for(int i=0;i<pattern.length();i++)
            expectedres[index++]= patternmap.get(pattern.charAt(i));
        
        for(int j=0;j<expectedres.length;j++)
            System.out.println(expectedres[j]);
        
        for(int i=0;i<expectedres.length;i++){
            if(!expectedres[i].equals(tokens[i]))
                return false;
        }*/
        
        return true;
        
    }
}
