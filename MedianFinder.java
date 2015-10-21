class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    boolean isEven = true;
    // Adds a number into the data structure.
    public void addNum(int num) {
        isEven = ! isEven;
        maxHeap.offer(- num);
        if (maxHeap.size() - minHeap.size() > 1 || (!minHeap.isEmpty() && minHeap.peek() < - maxHeap.peek())) {
            minHeap.offer(- maxHeap.poll());
        }
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(- minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (isEven) {
            return (double)(minHeap.peek() - maxHeap.peek()) / 2;
        }
        return (double)(- maxHeap.peek());
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();