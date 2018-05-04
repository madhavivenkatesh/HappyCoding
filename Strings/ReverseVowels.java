/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".*/

class Solution {
    public String reverseVowels(String s) {
        
        if(s.length()==0||s.length()==1)
            return s;
        
        char[] chararr = s.toCharArray();
        int i=0,j=s.length()-1;
        
        while(i<j){
            while(i<j && "aeiouAEIOU".indexOf(chararr[i])==-1)
                ++i;
            while(j>i && "aeiouAEIOU".indexOf(chararr[j])==-1)
                --j;
            
            if(i<j){
                char temp = chararr[i];
                chararr[i] = chararr[j];
                chararr[j] =temp;
                i++;
                --j;
            }
        }
        
        return String.valueOf(chararr);
        
    }
}
