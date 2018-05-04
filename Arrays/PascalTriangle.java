class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            
        for(int i=0;i<numRows;i++){
            List<Integer> currow = new ArrayList<Integer>();
            for(int j=0;j<=i;j++){
                currow.add((j==0||j==i)?1:result.get(result.size()-1).get(j)+result.get(result.size()-1).get(j-1));
            }
            System.out.println(currow);
            result.add(currow);
            
        }
        
        return result;
    }
}
