/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums,0,nums.length-1);
    }
    
    public TreeNode sortedArrayToBSTHelper(int[] nums,int low,int high){
        
        TreeNode newNode =null;
        
        if(low<=high){
            int mid = low +(high-low)/2;
            newNode = new TreeNode(nums[mid]);
            newNode.left = sortedArrayToBSTHelper(nums,low,mid-1);;
            newNode.right = sortedArrayToBSTHelper(nums,mid+1,high);
        }
         return  newNode;
    }
}
