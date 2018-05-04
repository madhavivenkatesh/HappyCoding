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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
         if (root == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.val < p.val && root.val < q.val) 
            return lowestCommonAncestor(root.right, p, q);
  
        return root;
    }
}
