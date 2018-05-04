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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorderlist = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode curr = root;
        
        if(root==null)
            return Collections.emptyList();
        
       stack.addFirst(curr);
        
        while(!stack.isEmpty()){
            
            if(curr.left!=null){
                while(curr.left!=null){
                    stack.addFirst(curr.left);
                    curr = curr.left;
                }
        }
        
        TreeNode removednode = stack.removeFirst();
        inorderlist.add(removednode.val);
        if(removednode.right!=null){
           stack.addFirst(removednode.right); 
           curr = removednode.right;
            }
        }
        
        return inorderlist;
    }
}
