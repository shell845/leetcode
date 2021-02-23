package main.java.geekbang.day05;

/**
 * @author YC (shell845)
 * @date 19/5/2020 12:00 PM
 */

public class SkipList {
    private static final float SKIPLIST_P = 0.5f;
    private static final int MAX_LEVEL = 16;

    class Node {
        private int value = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;
    }

    private int levelCount = 1;
    private Node head = new Node();

    public Node find(int value) {
        Node node = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (node.forwards[i] != null && node.forwards[i].value < value) node = node.forwards[i];
        }

        if (node.forwards[0] != null && node.forwards[0].value == value) return node.forwards[0];
        else return null;
    }

    public void insert(int value) {
        int level = randomLevel();
        Node node = new Node();
        node.value = value;
        node.maxLevel = level;
        Node update[] = new Node[level];
        for (int i = 0; i < level; ++i) update[i] = head;

        // recode nodes in search path
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].value < value) p = p.forwards[i];
            update[i] = p;
        }

        // new node as forward nodes next to search path node
        for (int i = 0; i < level; ++i) {
            node.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = node;
        }

        // update skip list height
        if (levelCount < level) levelCount = level;
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node node = head;
        // record search path
        for (int i = levelCount - 1; i >= 0; --i) {
            while (node.forwards[i] != null && node.forwards[i].value < value) node = node.forwards[i];
            update[i] = node;
        }
        // delete node
        if (node.forwards[0] != null && node.forwards[0].value == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].value == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i]; // remove node
                }
            }
        }

        // shrink level
        while (levelCount > 1 && head.forwards[levelCount] == null) levelCount--;
    }

    // 50% 1, 25% 2, 12.5% 3 ...
    private int randomLevel() {
        int level = 1;
        while (Math.random() < SKIPLIST_P && level < MAX_LEVEL) level++;
        return level;
    }

}
