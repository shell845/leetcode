package main.java.geekbang.day04;

import java.util.Arrays;

/**
 * @author YC (shell845)
 * @date 16/5/2020 3:39 PM
 */

public class Sorting {
    public static void main(String[] args) {
        int[] n = new int[] {2, 4, 3, 1, 5, 6};
        Sorting s = new Sorting();
        s.quickSort(n);
        System.out.println(Arrays.toString(n));
    }

    public void quickSort(int[] n) {
        q_sort(n, 0, n.length - 1);
    }

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

    public void mergeSort(int[] n) {
        m_sort(n, 0, n.length - 1);
    }

    private void m_sort(int[] n, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        m_sort(n, left, mid);
        m_sort(n, mid + 1, right);
        m_merge(n, left, mid, mid + 1, right);
    }

    // 0 1 2 3 4
    private void m_merge(int[] n, int li, int lj, int ri, int rj) {
        int[] temp = new int[rj - li + 1];
        int k = 0, p = li;
        while (li <= lj && ri <= rj) {
            if (n[li] <= n[ri]) temp[k++] = n[li++];
            else temp[k++] = n[ri++];
        }
        while (li <= lj) temp[k++] = n[li++];
        while (ri <= rj) temp[k++] = n[ri++];

        for (int i = 0; i < temp.length; ++i) n[p++] = temp[i];
    }

    public void bubbleSort(int[] n) {
        boolean flag = false;
        for (int i = 0; i < n.length; ++i) {
            for (int j = i + 1; j < n.length - i - 1; ++j) {
                if (n[i] > n[j]) {
                    swap(n, i, j);
                    if (!flag) flag = true;
                }
            }
            if (!flag) return;
        }
    }

    public void insertionSort(int[] n) {
        for (int i = 1; i < n.length; ++i) {
            int value = n[i];
            int j = i - 1;
            while (j >= 0) {
                if (n[j] > value) {
                    n[j + 1] = n[j];
                    --j;
                } else break;
            }
            n[j + 1] = value;
        }
    }

    public void selectionSort(int[] n) {
        for (int i = 0; i < n.length - 1; ++i) {
            int max = i;
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] < n[max]) max = j;
            }
            swap(n, i, max);
        }
    }

    private void swap (int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

}
