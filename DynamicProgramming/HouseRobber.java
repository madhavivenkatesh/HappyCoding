/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will 
automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        
        int prevmax=0 , currmax=0;
        
        for(int num:nums){
            int temp=currmax;
            currmax = Math.max(prevmax+num,currmax);
            prevmax = temp;
        }
        
        return currmax;
        
    }
}
