class MedianFinder {

    /** initialize your data structure here. */
     PriorityQueue<Integer> minheap;
     PriorityQueue<Integer> maxheap;
    
    public MedianFinder() {
        minheap = new  PriorityQueue<Integer>();
        maxheap = new  PriorityQueue<Integer>(16,Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minheap.add(num);
        maxheap.add(minheap.remove());
        
        if(maxheap.size() > minheap.size())
            minheap.add(maxheap.remove());
    }
    
    public double findMedian() {
        
        if(minheap.size() == maxheap.size())
            return (minheap.peek()+maxheap.peek())*0.5;
        
        return (double)minheap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
