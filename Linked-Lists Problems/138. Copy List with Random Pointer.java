/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        dummy.next = head;
        
        while(head != null) {
            Node copynode = new Node(head.val);
            map.put(head, copynode);
            head = head.next;
        }
        head = dummy.next;
        while(head != null) {
            Node copynode = map.get(head);
            copynode.next = map.get(head.next);
            copynode.random = map.get(head.random);
            head = head.next;
        }
        return map.get(dummy.next);
    }
}
