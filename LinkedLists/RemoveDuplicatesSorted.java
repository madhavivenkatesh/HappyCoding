/**
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode prev = dummyhead,curr=head;
        
        while(curr!=null){
            ListNode nextnode = curr;
            while(curr.next!=null&&curr.next.val==nextnode.val){
                curr = curr.next;
            }
            
            nextnode.next = curr.next;
            curr = curr.next;
            
        }
        
        return prev.next;
    }
}
