import java.util.PriorityQueue;

/**
 * @author YC 04/07/2020
 */

public class _295_FindMedianFromDataStream {

     /** Two heaps, complexity add O(logn) find O(1), space O(n) */
     static class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        /** initialize your data structure here. */
        public MedianFinder() {
            minHeap =  new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            int size = minHeap.size() + maxHeap.size();
            if ((size & 1) == 1) { // odd number, insert to maxHeap
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            } else {               // even number, insert to minHeap
                minHeap.add(num);
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            int size = minHeap.size() + maxHeap.size();
            if ((size & 1) == 1){ // odd number
                return maxHeap.peek();
            } else return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder test = new _295_FindMedianFromDataStream.MedianFinder();
        test.addNum(3);
        test.addNum(1);
        test.addNum(4);
        System.out.println(test.findMedian());
        test.addNum(2);
        System.out.println(test.findMedian());
    }
}
