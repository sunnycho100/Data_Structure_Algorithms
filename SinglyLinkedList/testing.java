package SinglyLinkedList;
import java.util.ArrayList;

public class testing {
    public static void main(String[] args) {
        // CREATE YOUR TESTBENCH
        LinkedList list = new LinkedList();
        list.insertHead(1);
        list.remove(0);
        System.out.println(list.getValues());
    }
}
class ListNode {
    // direct access avilable
    public ListNode next;
    public int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }
    
    public ListNode(int val) {
        this.val = val;
    }
}

class LinkedList {
    ListNode head;
    ListNode tail;
    int size;

    public LinkedList() {
        size = 0;
    }

    public int get(int index) {
        ListNode refNode = head;
        if (index >= size) {
            return -1;
        } // otherwise
        for (int i = 0; i < index; i++) {
            refNode = refNode.next;
        }
        return refNode.val;
    }

    public void insertHead(int val) {
        if (head != null) {
            // create a new head first that points the previous head
            ListNode newHead = new ListNode(head, val);
            // move head pointer to new head
            head = newHead;
        }
        else { // if no nodes exist
            ListNode newNode = new ListNode(val);
            head = newNode;
            tail = newNode; // cross ref
            // what about the future appends... 
        }
        size++;
    }

    public void insertTail(int val) {
        if (tail != null) {
            // create new tail
            ListNode newTail = new ListNode(val);
            // move prev tail nxt to newTail
            tail.next = newTail; // here we wanna refer to the node itself..
            // newTail becomes the tail ref
            tail = newTail;
        }
        else {
            ListNode newNode = new ListNode(val);
            tail = newNode;
            head = newNode; // cross ref
        }
        size++;
    }

    public boolean remove(int index) {
        ListNode prevNode = head;
        if (index >= size) {
            return false;
        } // otherwise
        // size 1 case
        if (size == 1) {
            // only head tail points one node
            head = null;
            tail = null;
            size--;
            return true;
        }
        else if (size == 2) {
            // head > n1, n2 < tail
            if (index == 0) {
                head = tail;
            }
            else { // index == 1, removing the tail
                tail = head;
            }
            size--;
            return true;
        }
        else if (index == 0) { // does not have prev. node
            head = head.next;
            size--;
            return true;
        }

        // case where size >= 3, remNode has prev. and next.
        for (int i = 0; i < index - 1; i++) {
            prevNode = prevNode.next;
        }
        // assuming we have prev and next node
        // prev > nodeToRemove > next
        ListNode remNode = prevNode.next;
        prevNode.next = remNode.next; // change pointer
        remNode.next = null; // remove pointer
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        ListNode refNode = head;

        for (int i = 0; i < size; i++) {
            list.add(refNode.val);
            refNode = refNode.next;
        }
        return list;
    }
}

