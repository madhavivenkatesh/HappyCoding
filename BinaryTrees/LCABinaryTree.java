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
    
    private class LCANode{
        int children;
        TreeNode root;
        public LCANode(int children,TreeNode root){
            this.children=children;
            this.root=root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        LCANode res = helper(root,p,q);
        return res.root;
            
    }
    
    public LCANode helper(TreeNode root, TreeNode p, TreeNode q){
         if(root==null)
            return new LCANode(0,null);
        
        LCANode left = helper(root.left,p,q);
        if(left.children==2)
            return left;
        
        LCANode right = helper(root.right,p,q);
        if(right.children==2)
            return right;
        
        int numchildren = left.children+right.children+(root==p?1:0)+(root==q?1:0);
        return new LCANode(numchildren,numchildren==2?root:null);
    }
}
