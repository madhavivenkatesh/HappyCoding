/*Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?*/

class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length <= 1)
            return new int[2];
        int diff = nums[0];
        for(int i = 1; i<nums.length; i++){
            diff ^= nums[i];
        }
        diff &= -diff;
        int res1 = 0, res2 = 0;
        for(int num:nums){
            if((num & diff) == 0){
                res1 ^= num;
            }
            else{
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }
}
