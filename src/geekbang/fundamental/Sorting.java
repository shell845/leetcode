package geekbang.fundamental;

/**
 * @author YC (shell845)
 * @date 3/2/2021 7:14 PM
 */

public class Sorting {
    // time best O(N), worst O(N^2)
    public static void bubbleSort(int[] t) {
        if (t == null || t.length == 0) return;
        boolean hasChange = false;
        for(int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i] > t[j]) {
                    int temp = t[i];
                    t[i] = t[j];
                    t[j] = temp;
                    hasChange = true;
                }
            }
            if (!hasChange) break;
        }
        for (int i : t) System.out.print(i + " ");
    }

    // Time best O(N) worst O(N^2)
    public static void insertionSort(int[] t) {
        // 2,5j, 9,9i v2,1,6,2,4
        if (t.length <= 1) return;
        for (int i = 1; i < t.length; i++) {
            int value = t[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (t[j] > value) t[j + 1] = t[j];
                else break;
            }
            t[j + 1] = value;
        }
        for (int i : t) System.out.print(i + " ");
    }

    // Time best O(N) worst O(N^2)
    public static void selectionSort(int[] t) {
        // 9,2,5,2,1,6,2,4
        if (t.length <= 1) return;
        for (int i = 0; i < t.length - 1; i++) {
            int min = i;
            int j = i + 1;
            // find min
            while (j < t.length) {
                if (t[j] < t[min]) min = j;
                j++;
            }
            // swap
            int tmp = t[i];
            t[i] = t[min];
            t[min] = tmp;
        }
        for (int i : t) System.out.print(i + " ");
    }

    // merge sort
    // time O(NlogN), space O(N)
    public void mergeSort(int[] t) {
        if (t == null || t.length <= 1) return;
        sort(t, 0, t.length - 1);
        for (int i : t) System.out.print(i + " ");
    }

    void sort(int[] t, int l, int r) {
        // merge and sort two arrays
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(t, l, mid);
        sort(t, mid + 1, r);
        merge(t, l, mid, mid + 1, r);
    }

    void merge(int[] t, int l, int lEnd, int r, int rEnd) {
        // 2 3 5
        // 1 2 4
        int[] temp = new int[rEnd - l + 1];
        int startPoint = l;
        int i = 0;
        while (l <= lEnd && r <= rEnd) {
            if (t[l] <= t[r]) {
                temp[i] = t[l];
                l++;
            } else {
                temp[i] = t[r];
                r++;
            }
            i++;
        }
        while (l <= lEnd) {
            temp[i] = t[l];
            l++;
        }
        while (r <= rEnd) {
            temp[i] = t[r];
            r++;
        }
        // copy back to original array
        for (int j = 0; j < temp.length; j++) {
            t[startPoint] = temp[j];
            startPoint++;
        }
    }

    // quick sort
    // time best O(NlogN) worst O(N^2), space O(1)
    public void quickSort(int[] t) {
        if (t == null || t.length <= 1) return;
        quickSortHelper(t, 0, t.length - 1);
        for (int i : t) System.out.print(i + " ");
    }

    void quickSortHelper(int[] t, int l, int r) {
        // pick last element t[r] as pivot point
        if (l >= r) return;
        int i = l, j = l; // j is traveling pointer, i is the pointer for the first num > pivot point
        while (j < r) {
            if (t[j] < t[r]) { // swap i and j
                swap(t, i, j);
                i++;
            }
            j++;
        }
        swap(t, i, r);
        quickSortHelper(t, l, i - 1);
        quickSortHelper(t, i + 1, r);
    }

    // pick first element as pivot point
    private void q_sort(int[] n, int left, int right) {
        if (left >= right) return;
        int pivot = n[left], l = left + 1, h = right;
        while (true) {
            while (l < right && n[l] < pivot) {
                l++;
            }
            while (h > left && n[h] >= pivot) {
                h--;
            }
            if (l >= h) break;
            swap(n, l, h);
        }
        swap(n, left, h);
        q_sort(n, left, l - 1);
        q_sort(n, l + 1, right);
    }

    void swap(int[] t, int a, int b) {
        int tmp = t[a];
        t[a] = t[b];
        t[b] = tmp;
    }

    public static void main(String args[]) {
        Sorting s = new Sorting();
        s.quickSort(new int[]{9,2,5,2,1,6,2,4});
        // selectionSort(new int[]{9,2,5,2,1,6,2,4});
    }

}
