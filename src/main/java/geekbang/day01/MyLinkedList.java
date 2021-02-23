package main.java.geekbang.day01;

/**
 * @author YC (shell845)
 * @date 12/5/2020 5:31 PM
 */

public class MyLinkedList<T> {
    public static void main(String[] args) {
        SingleLinkedList<Integer> test = new SingleLinkedList<>();
        test.add(0);
        test.add(1);
        test.add(2);
        test.print();
        test.reverse();
        test.print();
        test.delete(2);
        test.print();
        test.reverse();
        test.print();
        test.delete(0);
        test.print();
        test.reverse();
        test.print();
        test.delete(1);
        test.print();
    }
}

/** single LinkedList */
class SingleLinkedList<T> {
    private Node head;

    class Node {
        T value;
        Node next;

        public Node(T t) {
            this.value = t;
        }
    }

    public SingleLinkedList () {
        head = null;
    }

    public void add(T t) {
        if (head == null) head = new Node(t);
        else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(t);
        }
    }

    public void delete(T t) {
        Node node = head, prev = null;
        while (node != null) {
            if (node.value.equals(t)) {
                if (prev == null) head = head.next;
                else prev.next = node.next;
                return;
            } else {
                prev = node;
                node = node.next;
            }
        }
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        Node node = head;
        while (head.next != null) {  // note: pointer is head.next
            Node temp = head.next.next;
            head.next.next = node;
            node = head.next;
            head.next = temp;
        }
        head = node;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}

/** circular LinkedList */
class CircularLinkedList<T> {
    private Node head, tail;

    class Node {
        T value;
        Node next;

        public Node(T t) {
            this.value = t;
        }
    }

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T t) {
        if (head == null) {
            head = new Node(t);
            tail = head;
            head.next = tail;
        } else {
            Node node = new Node(t);
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    public void delete(T t) {
        Node prev = null, curr = head;
        while (curr != null) {
            if (curr.value.equals(t)) {
                if (prev == null) {
                    if (tail == head) head = null;
                    else {
                        tail.next = head.next;
                        head = head.next;
                    }
                } else {
                    prev.next = curr.next;
                    if (curr == tail) tail = prev;
                }
                return;
            } else {
                if (curr.next == head) return;
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            if (node.next == head) {
                System.out.println();
                return;
            }
            node = node.next;
        }
    }


}

/** double LinkedList - deque */
class DoubleLinkedList<T> {
    private Node head, tail;

    class Node {
        T value;
        Node prev, next;

        public Node(T t) {
            this.value = t;
        }
    }

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T t) {
        if (head == null) {
            head = new Node(t);
            tail = head;
        } else {
            tail.next = new Node(t);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public void delete(T t) {
        System.out.println("delete " + t);
        Node node = head;
        while (node != null) {
            if (node.value.equals(t)) {
                if (node.prev == null) {
                    if (node.next == null) {
                        head = null;
                        tail = null;
                    } else {
                        head = node.next;
                        head.prev = null;
                    }
                } else if (node.next != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                } else {
                    node.prev.next = null;
                }
                return;
            } else node = node.next;
        }
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}
