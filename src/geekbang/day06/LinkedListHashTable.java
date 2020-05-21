package geekbang.day06;

/**
 * @author YC (shell845)
 * @date 21/5/2020 11:04 AM
 */

// for integer only
public class LinkedListHashTable {
    public static void main(String[] args) {
        LinkedListHashTable test = new LinkedListHashTable();
        test.insert(2);
        test.insert(12);
        test.insert(5);
        test.insert(6);
        test.insert(7);
        test.insert(77);
        test.insert(72);
        test.print();
        test.delete(6);
        test.delete(12);
        test.print();
    }

    public class Node {
        int val;
        Node next;

        public Node(int value) {
            this.val = value;
        }
    }

    private Node[] hashtable;
    private int capacity;

    public LinkedListHashTable() {
        this(10);
    }

    public LinkedListHashTable(int capacity) {
        this.capacity = capacity;
        this.hashtable = new Node[capacity];
    }

    public boolean insert(int value) {
        int index = hash(value);
        if (hashtable[index] == null) {
            hashtable[index] = new Node(value);
        } else {
            Node node = hashtable[index];
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(value);
        }
        return true;
    }

    public boolean delete(int value) {
        int index = hash(value);
        Node curr = hashtable[index];
        Node prev = curr;
        while (curr != null) {
            if (curr.val == value) {
                // delete
                if (prev == curr) {
                    // delete head
                    hashtable[index] = curr.next;
                } else {
                    // delete none head
                    prev.next = curr.next;
                }
                return true;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return false;
    }

    private int hash(int value) {
        return value % capacity;
    }

    private void print() {
        for (Node n : hashtable) {
            while (n != null) {
                System.out.print(n.val + " ");
                n = n.next;
            }
            System.out.println();
        }
    }

}
