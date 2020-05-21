package geekbang.day06;

import java.util.HashMap;

/**
 * @author YC (shell845)
 * @date 21/5/2020 11:51 AM
 */

public class LRUCache<K, V> {
    class Node {
        private V val;
        private Node prev, next;

        Node() {

        }

        Node(V value) {
            this.val = value;
        }
    }

    private HashMap<K, V> map = new HashMap<>();
    private Node head, tail; // dummy head, pointer tail
    private int capacity, size;

    public LRUCache (int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(K key, V value) {
        if (head == null) {
            head = new Node(value);
            head.next = new Node(value);
            tail = head.next;
            size++;
        } else {
            // if exist --> move to tail
            // if not exist && cache not full --> insert
            // if not exist && cache full --> delete head then insert
        }
    }



}
