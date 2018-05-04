/*Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.*/

class Solution {
    public int reverse(int x) {
        
        long res =0;
        
        while(x!=0){
            
            res = res *10 + x %10;
            if((x>0 && res>Integer.MAX_VALUE) || (x<0 && res<Integer.MIN_VALUE)){
                return 0;
            }
            x = x/10;
        }
        
        return (int)res;
    }
}
