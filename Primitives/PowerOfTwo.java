class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if(n==1)
            return true;
        
        if(n%2!=0 || n==0)
            return false;
        
        int count1bits = 0;
        for(int i=0;i<31;i++){
            if(((n>>i)&1) ==1)
               count1bits +=1; 
        }
        
       //return count1bits==1?true:false;
        return ((n > 0) && ((n & (n - 1)) == 0));
    }
}
