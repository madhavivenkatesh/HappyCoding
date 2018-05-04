/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        
         if (head == null || head.next == null) {
          return head;
        }
        ListNode prev=null,slow=head,fast=head;
        
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        return mergeTwoLists(sortList(head),sortList(slow));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = l1!=null?l1:l2;
        return dummyhead.next;
    }
}
