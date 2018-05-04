class MinStack {

    Stack<Integer> s;
    int minelem;
    
    public MinStack() {
        s = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
            s.push(x);
            minelem = x;
        }else if(x>minelem){
            s.push(x);
        }else{
            int newelem = (2*x) - minelem;
            s.push(newelem);
            minelem = x;
        }
    }
    
    public void pop() {
        
        if(s.isEmpty())
            throw new IllegalStateException("Stack is empty");
        
        int popelem = s.pop();
        
        if(popelem>minelem){
           System.out.println(popelem);
        }else
        {
          minelem = (2*minelem)-popelem;  
          System.out.println(minelem);
        }
            
    }
    
    public int top() {
        Integer t = s.peek();
        if (t < minelem){
            t = minelem;
        }
            
       return t;
    }
    
    public int getMin() {
        
        return minelem;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
