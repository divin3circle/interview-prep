import java.util.*;

class MedianFinder {
    private PriorityQueue<Integer> small; // Max heap
    private PriorityQueue<Integer> large; // Min heap

    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);
        // Balance heaps
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }

        // Handle size difference
        if (small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        if (large.size() > small.size())
            return large.peek();
        return (small.peek() + large.peek()) / 2.0;
    }
}
