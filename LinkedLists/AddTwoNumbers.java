/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        
        if(l2==null)
            return l1;
        
        return addTwoNumbershelper(l1,l2,0);
        
    }
    
    public ListNode addTwoNumbershelper(ListNode l1, ListNode l2,int carry){
        int sum = carry;
        
        if(l1==null && l2==null && carry==0)
            return null;
        
        if(l1!=null){
            sum +=l1.val;
        }
        if(l2!=null){
            sum +=l2.val;
        }
        
        ListNode newnode = new ListNode(sum%10);
        carry = sum/10;
        ListNode more = addTwoNumbershelper(l1==null?null:l1.next,l2==null?null:l2.next,carry);
        newnode.next=more;
        
        return newnode;
    }
}
