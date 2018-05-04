class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<board.length;i++){
            if(hasDuplicates(board,i,i+1,0,board[i].length)){
                System.out.println("Row is invalid");
                return false;
            }
                
        }
        
        for(int j=0;j<board.length;j++){
            if(hasDuplicates(board,0,board.length,j,j+1)){
                System.out.println("Column is invalid");
                return false;
            }
                
        }
        
        int numSubSets = (int)Math.sqrt(board.length);
        for(int i=0;i<numSubSets;i++){
            for(int j=0;j<numSubSets;j++){
                 if(hasDuplicates(board,i*3,(i+1)*3,j*3,(j+1)*3))
                    return false;
            }
        }
       
        return true;
    }
    
    public boolean hasDuplicates(char[][] board,int startrow,int endrow,int starcol,int endcol){
        List<Boolean> uniqSet = new ArrayList<Boolean>(Collections.nCopies(board.length+1, false));
        for(int i=startrow;i<endrow;i++){
             for(int j=starcol;j<endcol;j++){
                 if(board[i][j]!='.'){
                    char c = board[i][j];
                    int intc = Character.getNumericValue(c);
                    //System.out.println(uniqSet.get(intc));
                    if(uniqSet.get(intc))
                        return true;
                 uniqSet.set(intc,true);  
                 }
             }
        }
        
        return false;
        
    }
}
