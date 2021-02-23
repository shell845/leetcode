package main.java.geekbang.day03;

/**
 * @author YC (shell845)
 * @date 14/5/2020 1:18 PM
 */

public class MyQueue {
    public static void main(String[] args) {
        LinkedListQueue<Integer> test = new LinkedListQueue();
        System.out.println(test.add(0));
        System.out.println(test.add(1));
        System.out.println(test.add(2));
        System.out.println(test.add(3));
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.add(4));
        System.out.println(test.poll());
        System.out.println(test.poll());
        System.out.println(test.poll());
        System.out.println(test.poll());
    }
}

/** Circular queue implemented by Array */
class ArrayQueue<T> {
    private T[] queue;
    private int capacity, head, tail;
    private boolean full = false;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int n) {
        this.queue = (T[]) new Object[n];
        this.capacity = n;
        this.head = 0;
        this.tail = 0;
    }

    public boolean add(T t) {
        if (full) return false;
        if ((tail + 1) % capacity == head) {
            full = true;
        }
        queue[tail] = t;
        tail = (tail + 1) % capacity;
        return true;
    }

    public T poll() {
        if (!full && head == tail) return null;
        full = false;
        T t = queue[head];
        head = (head + 1) % capacity;
        return t;
    }

    public T peek() {
        if (!full && head == tail) return null;
        return queue[head];
    }
}

/** Circular queue implemented by LinkedList */
class LinkedListQueue<T> {
    class Node {
        T value;
        Node next;

        public Node(T t) {
            this.value = t;
        }
    }

    private Node head, tail;

    LinkedListQueue() { }

    public boolean add(T t) {
        if (head == null) {
            head = new Node(t);
            tail = head;
        } else {
            Node temp = new Node(t);
            tail.next = temp;
            tail = temp;
        }
        return true;
    }

    public T peek() {
        if (head == null) return null;
        return head.value;
    }

    public T poll() {
        if (head == null) return null;
        T result = head.value;
        head = head.next;
        return result;
    }
}
