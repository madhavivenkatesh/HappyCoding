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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> preorderlist = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        
        if(root==null)
            return Collections.emptyList();
        
        stack.add(curr);
        
        while(!stack.isEmpty()){
            TreeNode removednode = stack.removeFirst();
            preorderlist.add(removednode.val);
            if(removednode.right!=null)
                stack.addFirst(removednode.right);
              if(removednode.left!=null)
                stack.addFirst(removednode.left);
        }
        
        return preorderlist;
   
