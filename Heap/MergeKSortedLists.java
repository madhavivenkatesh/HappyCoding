/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
public ListNode mergeKLists(ListNode[] lists) {
    // edge case - empty list
    ListNode nodes = null;
    if(lists.length == 0){
        return nodes;
    }
    // edge case - single entry in list
    if(lists.length==1){
        return lists[0];
    }
    
    //merge k-sorted linked lists - use priority queue
    Comparator<ListNode> lnvc = new ListNodeValueComparator();
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, lnvc);
    
    for(ListNode listNode: lists){
        //add a list node to a priority queue.
        if(listNode !=null){
            priorityQueue.offer(listNode); //adds to the priority queue
        }
    }
    
    ListNode head = null;
    while(priorityQueue.size()>0){
        //poll() element from Queue
        ListNode smallestNow = priorityQueue.poll();
        if(smallestNow.next!=null){ // if linked list is not empty, offer next node to the heap
            priorityQueue.offer(smallestNow.next);
            smallestNow.next = null;
        }
        
        //get smallest node from list
        if(nodes == null){
            nodes = smallestNow;
            //head becomes the first smallest element
            head = smallestNow; 
        } else {
            nodes.next = smallestNow;
            nodes = nodes.next;
        }
    }
    
    return head;
}
//declare a custom comparator
private class ListNodeValueComparator implements Comparator<ListNode>{
     @Override
     public int compare(ListNode listNode1, ListNode listNode2){
        //compares integer values of both nodes 
        return Integer.compare(listNode1.val, listNode2.val);   
        }
    } 
    
}
