package main.java.geekbang.day02;

/**
 * @author YC (shell845)
 * @date 13/5/2020 2:46 PM
 */

public class MyStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> test = new LinkedListStack<>();
        test.push(0);
        test.push(1);
        System.out.println(test.peek());
        System.out.println(test.pop());
        test.push(2);
        System.out.println(test.pop());
        test.push(3);
        System.out.println(test.peek());
        test.push(4);
        System.out.println(test.pop());
    }
}

class ArrayStack<T> {
    private T[] stack;
    private int capacity, start, end;

    public ArrayStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
        this.start = 0;
        this.end = -1;
    }

    public boolean push(T t) {
        if (end == capacity - 1) return false;
        stack[++end] = t;
        return true;
    }

    public T peek() {
        return end < 0 ? null : stack[end];
    }

    public T pop() {
        if (end < 0) return null;
        T temp = stack[end];
        end--;
        return temp;
    }

}

class LinkedListStack<T> {
    private class Node{
        T value;
        Node next;

        private Node() { }

        private Node(T t) {
            this.value = t;
        }
    }

    private Node dummyHead, tail;
    private int size;

    public LinkedListStack() {
        dummyHead = new Node();
        tail = dummyHead;
        this.size = 0;
    }

    public void push(T t) {
        Node node = new Node(t);
        tail.next = node;
        tail = tail.next;
        size++;
    }

    public T peek() {
        if (size <= 0) return null;
        return tail.value;
    }

    public T pop() {
        if (size <= 0) return null;
        Node node = dummyHead;
        while (node.next != tail) {
            node = node.next;
        }
        T temp = tail.value;
        tail = node;
        node.next = null;
        return temp;
    }

}
