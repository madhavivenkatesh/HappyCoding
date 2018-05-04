/*Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"

*/
class Solution {
    public String longestPalindrome(String s) {
        
        int start =0,end=0;
        
        for(int i=0;i<s.length();i++){
            int len1  = findpalindrome(i,i,s);
            int len2  = findpalindrome(i,i+1,s);
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;
                end = i+len/2;
            }
        }
        
        return s.substring(start,end+1);
    }
    
    public int findpalindrome(int left,int right,String s){
        int l=left,r=right;
        while(l>=0 && r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        
        return r-l-1;
    }
}
