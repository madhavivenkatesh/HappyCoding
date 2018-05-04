/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 Invert a binary tree.
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root==null)
            return root;
        
        TreeNode rightsub = invertTree(root.right);
        TreeNode leftsub = invertTree(root.left);
        
        root.left = rightsub;
        root.right = leftsub;
        
        return root;
        
    }
}
