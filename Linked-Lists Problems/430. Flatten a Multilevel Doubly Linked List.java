/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
                Stack<Node> stack = new Stack<>();
        Node temp = head;

        while(head != null) {
            if(head.child != null) {
                if(head.next != null)
                    stack.push(head.next);

                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            }
            else if(head.next == null && !stack.isEmpty()) {

                head.next = stack.pop();
                head.next.prev = head;
            }

            head = head.next;
        }
        
        return temp;
    }
}

