class Solution {
    /*public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(isStringExsist(board,word,0,i,j))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean isStringExsist(char[][] board,String word,int offset,int i,int j){
        
        if(offset == word.length()){
            return true;
        }
        
        System.out.println(i+" "+j);
        
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(offset)){
            System.out.println("Invalid");
            return false;
        }
        
        System.out.println(offset);
        
        if(isStringExsist(board,word,offset+1,i-1,j) || isStringExsist(board,word,offset+1,i+1,j) ||isStringExsist(board,word,offset+1,i,j-1) ||  isStringExsist(board,word,offset+1,i,j+1))
            return true;
    
        return false;
    }*/
    
    public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
 
    boolean result = false;
    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
           if(dfs(board,word,i,j,0)){
               result = true;
           }
        }
    }
 
    return result;
}
 
    public boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;

        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j]='#';
            if(k==word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
            ||dfs(board, word, i+1, j, k+1)
            ||dfs(board, word, i, j-1, k+1)
            ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            board[i][j]=temp;
        }

        return false;
    }
}
