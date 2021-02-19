/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode copyhead = new ListNode(0);
        copyhead.next = head;
        
        ListNode prev = copyhead;
        
        while(head != null) {
            
            if(head.next != null && head.val == head.next.val) {
                while(head.next != null && head.val == head.next.val)
                    head = head.next;
                prev.next = head.next;
            }
            else 
                prev = prev.next;
            
            head = head.next;
        }
        
        return copyhead.next;
    }
}
