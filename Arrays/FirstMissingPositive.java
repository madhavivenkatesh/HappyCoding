/*Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        
       for(int i=0;i<nums.length;i++){
           while(0<nums[i] && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
              // System.out.println(nums[i]+" "+nums[nums[i]-1]);
               int index = nums[i]-1;
               int temp = nums[i];
               nums[i]=nums[index];
               nums[index] = temp;
           }
       }
        
        //int elem = 1;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=j+1){
                return j+1;
                //break;
            }
        }
        
        return nums.length+1;
    }
}
