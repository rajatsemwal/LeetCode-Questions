class MyLinkedList {
    
    class ListNode {
        int val;
        ListNode prev, next;
        ListNode(int x) { val = x; }
    }
    
    int size;
    ListNode head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size)
            return -1;
        
        ListNode currhead = head;
        for(int i = 0; i < index; i++) {
            currhead = currhead.next;
        }
        
        return currhead.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode curr = new ListNode(val);
        if(size == 0) {
            head = curr;
        }
        else {
            curr.next = head;
            head.prev = curr;
            head = curr;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode curr = new ListNode(val);
        if(size == 0) {
            head = curr;
        }
        else {
            ListNode currhead = head;
            while(currhead.next != null) {
                currhead = currhead.next;
            }
            currhead.next = curr;
            curr.prev = currhead;
        }
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size)
            return;
        
        else if(index == size) {
            addAtTail(val);
        }   
            
        else if(index == 0) {
            addAtHead(val);
        }
        
        else {
            ListNode currhead = head;
            ListNode newnode = new ListNode(val);
            for(int i = 0; i < index-1; i++) {
                currhead = currhead.next;
            }
            newnode.next = currhead.next;
            newnode.prev = currhead;
            newnode.next.prev = newnode;
            currhead.next = newnode;
            size++;
        } 
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index == size)
            return;
        
        if(index == 0) {
            head = head.next;
            if(head != null) {
                head.prev = null;
            }
        } else {
            ListNode currhead = head;
            for(int i =0; i < index-1; i++)
                currhead = currhead.next;
            
            if(currhead.next.next == null)
                currhead.next = null;
            else {
                currhead.next = currhead.next.next;
                currhead.next.prev = currhead;
            }
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
