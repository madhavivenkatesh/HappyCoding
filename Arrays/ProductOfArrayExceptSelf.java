/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] result = new int[nums.length];
        int temp=1;
        
        for(int i=0;i<result.length;i++)
            result[i]=1;
        
        for(int j=0;j<nums.length;j++){
            result[j]=temp;
            temp*=nums[j];
        }
        temp=1;
        for(int k=result.length-1;k>=0;k--){
            result[k]*=temp;
            temp*=nums[k];
        }
            
        return result;
    }
}
