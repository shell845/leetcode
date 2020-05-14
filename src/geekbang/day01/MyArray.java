package geekbang.day01;

import java.util.Arrays;

/**
 * @author YC (shell845)
 * @date 12/5/2020 4:24 PM
 */

/** Implement an array which supports auto size adjustment */
public class MyArray<T> implements Comparable{
    private int capacity;
    private T[] arr;
    private int index;

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.index = 0;
    }

    /** add an element */
    public void add(T e) {
        if (index >= capacity) {
            capacity = capacity + Math.max(capacity >> 1, 1);
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[index++] = e;
        System.out.println(e);
    }

    /** delete an element */
    public boolean delete(T e) {
        int i = find(e);
        if (i != -1) {
            System.arraycopy(arr, i + 1, arr, i, index-- - i);
            resize();
            return true;
        }
        return false;
    }

    /** update an element */
    public boolean update(T src, T dest) {
        int i = find(src);
        if (i != -1) {
            arr[i] = dest;
            return true;
        }
        return false;
    }

    /** get array length */
    public int getLength() {
        return index;
    }

    /** get array element */
    public T getElement(int index) {
        if (index < 0 || index >= this.index) throw new IllegalArgumentException();
        return arr[index - 1];
    }


    /** merge two sorted array */
    public boolean merge (MyArray<T> arr2) {
        if (this.getClass() != arr2.getClass()) return false;
        int len1 = this.getLength(), len2 = arr2.getLength();
        MyArray<T> result = new MyArray<>(len1 + len2);
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            // need comparator
        }
        return true;
    }


    private void resize() {
        if (index < (capacity >> 1)) {
            capacity = Math.max(1, capacity >> 1);
            arr = Arrays.copyOf(arr, capacity);
        }
        System.out.println(Arrays.toString(arr));
    }

    private int find(T e) {
        for (int i = 0; i < index; ++i) {
            if (arr[i].equals(e)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        MyArray<Integer> test = new MyArray<>(3);
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.delete(3);
        test.delete(3);
        test.delete(1);
        test.delete(0);
        test.update(0, 7);
        test.update(4, 9);

        MyArray<Character> test1 = new MyArray<>(2);
        test1.add('a');
        test1.add('b');
        test1.add('c');
        test1.add('d');
        test1.add('e');
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
