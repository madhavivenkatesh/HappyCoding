class Solution {
    public void moveZeroes(int[] nums) {
        
        int writeindex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[writeindex++]=nums[i];
            }
        }
        
        if(writeindex<nums.length){
            for(int i=writeindex;i<nums.length;i++){
                nums[i]=0;
            }
        }
        
    }
}
