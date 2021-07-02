/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// This approach uses auxilliary space O(n) as HashSet. But if you need to solve it in O(1) space, follow another approach given below
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> seen = new HashSet<>();
        
        while(headA != null) {
            seen.add(headA);
            headA = headA.next;
        }
        
        while(headB != null) {
            if(seen.contains(headB)) {
                 return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}


/*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int len1 = 0, len2 = 0;
        ListNode nodeA = headA; ListNode nodeB = headB;
        
        while(nodeA != null) {
            
            len1++; nodeA = nodeA.next;
        }
        
        while(nodeB != null) {
            
            len2++; nodeB = nodeB.next;
        }
        nodeA = headA; nodeB = headB;
        
        if(len1 > len2) {
            
            int diff = len1 - len2;
            
            while(diff > 0) {
                nodeA = nodeA.next;
                diff--;
            }
        }
        else {
            
            int diff = len2 - len1;
            while(diff > 0) {
                nodeB = nodeB.next;
                diff--;
            }
        }
        
        while(nodeA != null && nodeB != null) {
            
            if(nodeA == nodeB)
                return nodeA;
            
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        
        return null;
    }
}
*/
