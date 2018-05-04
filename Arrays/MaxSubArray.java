class Solution {
    public int maxSubArray(int[] nums) {
        
        if(nums.length==0)
            return 0;
        
        int newsum = nums[0];
        int maxsum = nums[0];
        
        for(int i=1;i<nums.length;i++){
            newsum = Math.max(newsum+nums[i],nums[i]);
            maxsum = Math.max(newsum,maxsum);
        }
        
        return maxsum;
    }
}
