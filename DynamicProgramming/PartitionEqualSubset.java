/*Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:
Each of the array element will not exceed 100.
The array size will not exceed 200.
Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.
*/

class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        
        //System.out.println(sum);
        
        if(sum%2!=0)
            return false;
        
        boolean[][] partition =  new boolean[(sum/2)+1][nums.length+1];
        System.out.println(partition.length+" "+partition[0].length);
        
        for(int i=0;i<=nums.length;i++)
            partition[0][i] = true;
        
        for(int j=1;j<=sum/2;j++)
            partition[j][0] = false;
        
        for(int i=1;i<=(sum/2);i++){
            for(int j=1;j<=nums.length;j++){
                partition[i][j] = partition[i][j-1];
                if(i>=nums[j-1]){
                    partition[i][j] = partition[i][j] || partition[i-nums[j-1]][j-1];
                }
            }
        }
        
        return partition[sum/2][nums.length];
    }
}
