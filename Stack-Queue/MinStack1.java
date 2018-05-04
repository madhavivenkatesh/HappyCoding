class MinStack {

    /** initialize your data structure here. */
    private static class MinStack1{
        int val;
        int count;
        public MinStack1(int val,int count) {
        this.val = val;
        this.count = count;
        }
    }
    
    public MinStack() {
       
    }
    
    Deque<MinStack1> auxst = new LinkedList<MinStack1>();
    Deque<Integer> mainst = new LinkedList<Integer>();
    
    public void push(int x) {
        mainst.addFirst(x);
        
        if(!auxst.isEmpty()){
            if(x == auxst.peekFirst().val){
                MinStack1 temp = auxst.removeFirst();
                auxst.addFirst(new MinStack1(temp.val,temp.count+1));
            }else {
                if(x < auxst.peek().val)
                     auxst.addFirst(new MinStack1(x,1));
            }
        }else{
            auxst.addFirst(new MinStack1(x,1));
        }
    }
    
    public void pop() {
        if(!mainst.isEmpty()){
            int temprem = mainst.removeFirst();
            System.out.println(mainst.peekFirst());
            if(temprem == auxst.peekFirst().val){
                MinStack1 temp = auxst.removeFirst();
                if(temp.count!=1)
                    auxst.addFirst(new MinStack1(temp.val,temp.count-1));
            }
        }
    }
    
    public int top() {
        //if(!mainst.isEmpty()){
            return mainst.peekFirst();
        //}
    }
    
    public int getMin() {
        if(!auxst.isEmpty()){
            return auxst.peekFirst().val;
        }
        
        return -1;
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
