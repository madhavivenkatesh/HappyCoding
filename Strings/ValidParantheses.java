class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
                stack.addFirst(ch);
            else{
                if(!stack.isEmpty()){
                    char peek = stack.peek();
                    if(ch==')' && peek!='(')
                        return false;
                    else if(ch=='}' && peek!='{')
                        return false;
                    else if(ch==']' && peek!='[')
                        return false;
                    else
                        stack.removeFirst();
                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
