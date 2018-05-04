/*
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode curr = head;
        ListNode prev = dummyhead;
        
        while(curr!=null){
            if(curr.val==val){
                prev.next = curr.next;
                curr = curr.next;
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummyhead.next;
    }
}
