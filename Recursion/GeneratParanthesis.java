class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<String>();
        char[] par = new char[n*2];
        generateParenthesisHelper(res,n,0,0,0,par);
        return res;
    }
    
    public void generateParenthesisHelper(List<String> res,int n,int pos,int open,int close,char[] par){
        
        if(close==n){
            res.add(String.valueOf(par));
            return;
        }else{
            if(open<n){
                par[pos] = '(';
                generateParenthesisHelper(res,n,pos+1,open+1,close,par);
            }
            
            if(open>close){
                par[pos] = ')';
                generateParenthesisHelper(res,n,pos+1,open,close+1,par);
            }
        }
    }
}
