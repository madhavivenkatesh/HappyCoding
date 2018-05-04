class Solution {
    public int trailingZeroes(int n) {
        
        if(n<5)
            return 0;
        
        int trailzerocount  =0;
        
        for(long i=5;n/i>=1;i*=5){
            trailzerocount +=n/i;
        }
        
        return trailzerocount;
        
    }
}
