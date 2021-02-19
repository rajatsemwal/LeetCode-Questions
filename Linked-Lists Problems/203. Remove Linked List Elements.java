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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) {
            head = head.next;
        }
     
        ListNode currentnode = head;
        while(currentnode != null && currentnode.next != null) {
            if(currentnode.next.val == val) {
                currentnode.next = currentnode.next.next;
            }
            else {
                currentnode = currentnode.next;
            }
        }
        return head;
    }
}
