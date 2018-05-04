/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/



class Solution {
    public boolean canJump(int[] nums) {
        
        int maxjump = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(i>maxjump)
                return false;
            
            maxjump = Math.max(maxjump,i+nums[i]);
        }
        
        return maxjump>=nums.length-1?true:false;
    }
}
