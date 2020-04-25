package Day30;

import java.util.*;

/**
 * @author ych
 * @date 25/4/2020 11:38 AM
 */
public class Day24LRUCache {
    /** time complexity O(1), space O(N) */
    class LRUCache {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode post;
        }

        private void addNode(DLinkedNode node) {
            node.pre = head;
            node.post = head.post;
            head.post.pre = node;
            head.post = node;
        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;
            DLinkedNode post = node.post;
            pre.post = post;
            post.pre = pre;
        }

        private void moveToHead(DLinkedNode node) {
            this.removeNode(node);
            this.addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            this.removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache;
        private int count;
        private int capacity;
        private DLinkedNode head;
        private DLinkedNode tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            head.pre = null;
            tail = new DLinkedNode();
            tail.post = null;
            head.post = tail;
            tail.pre = head;
            cache = new HashMap<>();
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null) return -1;
            this.moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                this.cache.put(key, newNode);
                this.addNode(newNode);
                count++;
                if(count > capacity) {
                    DLinkedNode tail = this.popTail();
                    this.cache.remove(tail.key);
                    count--;
                }
            } else {
                node.value = value;
                this.moveToHead(node);
            }
        }
    }

    /** Take long run time
     * time complexity O(N), space O(N) */
    class LRUCache_slow {
        private int size;
        private Deque<Integer> deque; // store key
        private Map<Integer, Integer> map; // store key-value pair

        public LRUCache_slow(int capacity) {
            this.size = capacity;
            deque = new LinkedList<>();
            map = new HashMap<>();
        }

        public int get(int key) {
            if (!deque.contains(key)) return -1;
            deque.remove(key);
            deque.add(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (deque.contains(key)) { // record exists
                deque.remove(key);
            } else {                   // record not exist
                if (deque.size() >= size) {           // exceed capacity
                    map.remove(deque.removeFirst()); // remove LRU cache
                }
            }
            deque.add(key);
            map.put(key, value);
        }
    }
}
