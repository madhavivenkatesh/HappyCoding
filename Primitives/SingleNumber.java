/*Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
class Solution {
    public int singleNumber(int[] nums) {
        
        int[] count = new int[32];
        Arrays.fill(count,0);
        
        for(int num:nums){
            for(int i=0;i<32;i++){
                if(((num>>i)&1)==1){
                    //System.out.println("Yes the bit is 1");
                    count[i]=count[i]+1;
                }
                    
            }
        }
        
       // for(int i=0;i<count.length;i++)
           // System.out.println(count[i]);
        
        int result = 0;
        for(int i=0;i<count.length;i++){
            if(count[i]%3!=0){
                result |= (count[i]%3)<<i;
            }
                
        }
        
        return result;
    }
}
