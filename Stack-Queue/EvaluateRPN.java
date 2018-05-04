class Solution {
    public int evalRPN(String[] tokens) {
        
        Deque<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        
        for(int i=0;i<tokens.length;i++){
           if(("+-*/").contains(tokens[i])){
                if(!stack.isEmpty()){
                    int num2 = stack.removeFirst();
                    int num1 = stack.removeFirst();
                    switch(tokens[i]){
                    case "+":stack.addFirst(num1+num2);
                             break;
                    case "-":stack.addFirst(num1-num2);
                             break;
                    case "*":stack.addFirst(num1*num2);
                             break;
                    case "/":stack.addFirst(num1/num2);
                             break;
                    default: throw new IllegalArgumentException("No Such operator supported");
                    }  
                }else{
                    return  -1;
                }
            }else{
                stack.addFirst(Integer.valueOf(tokens[i]));
                }
           }
         return stack.size()==1 ?stack.peekFirst():-1;  
        }
    }
