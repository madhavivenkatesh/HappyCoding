class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> A = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            A.add(nums[i]);
        }
        
        permuteHelper(result,0,A);
        return result;
        
    }
    
    public void permuteHelper( List<List<Integer>> result,int pos,ArrayList<Integer> A){
        
        if(pos == A.size()){
            result.add(new ArrayList<Integer>(A));
            return ;
        }
        
        for(int i=pos;i<A.size();i++){
          Collections.swap(A,i,pos);
          permuteHelper(result,pos+1,A);  
          Collections.swap(A,i,pos);
        }
    }
}
