import java.util.*;
import java.lang.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    // Function to find the intersection of two linked lists
    public Node findIntersection(Node head1, Node head2) {
        // add your code here
        HashSet<Integer> set = new HashSet<>();
        Node temp2 = head2;
        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }

        // Step 2: Traverse head1 and build the intersection list
        Node dummy = new Node(0); // dummy node to ease the construction
        Node tail = dummy;
        Node temp1 = head1;

        while (temp1 != null) {
            if (set.contains(temp1.data)) {
                tail.next = new Node(temp1.data);
                tail = tail.next;
            }
            temp1 = temp1.next;
        }

        // Step 3: Return result list starting from dummy.next
        return dummy.next;
    }
}