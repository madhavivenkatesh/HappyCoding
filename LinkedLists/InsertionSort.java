/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        
        ListNode curr = head;
        ListNode sorted = null;
        
        while(curr!=null){
            
            ListNode newnode = curr;
            ListNode next = curr.next;
            
            if(sorted==null || sorted.val>=newnode.val){
                newnode.next=sorted;
                sorted = newnode;
            }else{
                ListNode current = sorted;
                /* Locate the node before the point of insertion */
                while (current.next != null && current.next.val < newnode.val) 
                {
                    current = current.next;
                }
                newnode.next = current.next;
                current.next = newnode;
            }
            
            curr = next;
        }
        
        return sorted;
        
    }
}
