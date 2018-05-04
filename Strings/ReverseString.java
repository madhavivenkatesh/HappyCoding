/*Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh"*/

class Solution {
    public String reverseString(String s) {
        char[] chararr = s.toCharArray();
        int i=0,j=chararr.length-1;
        
        while(i<j){
            char temp = chararr[i];
            chararr[i] = chararr[j];
            chararr[j] = temp;
            ++i;
            --j;
        }
        
        return String.valueOf(chararr);
        
    }
}
