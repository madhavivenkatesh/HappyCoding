class MyQueue {

    /** Initialize your data structure here. */
    
    Stack<Integer> mainstk = new Stack<Integer>();
    Stack<Integer> auxstack = new Stack<Integer>();
    int front;
    
    public MyQueue() {
        mainstk = new Stack<Integer>();
        auxstack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        if(mainstk.isEmpty())
            front=x;
        
        mainstk.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(auxstack.isEmpty()){
            while(!mainstk.isEmpty()){
                auxstack.push(mainstk.pop());
            }
        }
        
        return auxstack.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(!auxstack.isEmpty()){
            return auxstack.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainstk.isEmpty() && auxstack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
