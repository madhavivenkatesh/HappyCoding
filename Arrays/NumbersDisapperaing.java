/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6] */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>(Collections.nCopies(n, 0));
        for(int i=0;i<nums.length;i++){
            if(result.get(nums[i]-1)==0){
                result.set(nums[i]-1,nums[i]);
            }
        }
        
        List<Integer> finalresult = new ArrayList<Integer>();
        for(int i=0;i<result.size();i++){
            if(result.get(i)==0)
                finalresult.add(i+1);
        }
        
        return finalresult;
    }
}
