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
        
        ListNode copyhead = head;
        
        while(copyhead != null && copyhead.next != null) {
            
            if(copyhead.val == copyhead.next.val) {
                copyhead.next = copyhead.next.next;
             //   copyhead = copyhead.next;
            }
            else 
                copyhead = copyhead.next;
        }
        return head;
    }
}
