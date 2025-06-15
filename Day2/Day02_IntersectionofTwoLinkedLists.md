### Day X - Intersection of Two Linked Lists
### 🔍 Problem Statement:
Given two singly linked lists, head1 and head2, find the intersection of these two lists. Each list contains unique node values and no duplicates.
Return a new linked list that contains only the elements common to both lists, maintaining the order from head1.
If there are no common elements, return null.

### 🧠 Intuition:
Use a HashSet to store all elements of head2 for constant-time lookups.

Traverse head1, and for each node, check if it exists in the set.

If yes, include it in the result list.

This ensures O(N + M) time complexity where N and M are the lengths of head1 and head2.

### 👩‍💻 Code: FindIntersection.java
import java.util.HashSet;

class Solution {
    // Function to find the intersection of two linked lists
    public Node findIntersection(Node head1, Node head2) {
        HashSet<Integer> set = new HashSet<>();

        // Store all values from head2 in a HashSet
        Node curr2 = head2;
        while (curr2 != null) {
            set.add(curr2.data);
            curr2 = curr2.next;
        }

        // Create a dummy node for the result list
        Node dummy = new Node(0);
        Node tail = dummy;

        // Traverse head1 and add common nodes to result
        Node curr1 = head1;
        while (curr1 != null) {
            if (set.contains(curr1.data)) {
                tail.next = new Node(curr1.data);
                tail = tail.next;
            }
            curr1 = curr1.next;
        }

        return dummy.next;
    }
}
### 📦 Node Class (if required)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
### 🧪 Sample Input/Output:
Input:
head1 = 1 -> 2 -> 3 -> 4
head2 =     2 -> 4 -> 6

Output:
2 -> 4
Input:
head1 = 5 -> 10 -> 15
head2 = 7 -> 8 -> 9

Output:
null

### ⏱ Time and Space Complexity:
Time Complexity: O(N + M)

Space Complexity: O(M) (for the HashSet)