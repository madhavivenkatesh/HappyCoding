/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null || head.next==null)
            return true;
        
        ListNode slow=head,fast=head,prevslow=null;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prevslow = slow;
            slow = slow.next;
        }
        
        prevslow.next = null;
        ListNode secondpart = reverseList(slow);
        ListNode firstpart = head;
        
        while(firstpart!=null && secondpart!=null){
            if(firstpart.val!=secondpart.val)
                return false;
            
            firstpart = firstpart.next;
            secondpart = secondpart.next;
        }
        
        return true;
        
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}
