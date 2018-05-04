class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> powerSet = new ArrayList<>();
        powerSetGeneratorHelper(nums,powerSet,new ArrayList<Integer>(),0);
        return powerSet;
    }
    
    public void powerSetGeneratorHelper(int[] nums,List<List<Integer>> powerSet,ArrayList<Integer> partiallist,int tobeselected){
        
        if(tobeselected==nums.length){
            powerSet.add(new ArrayList<Integer>(partiallist));
            return ;
        }
        
        partiallist.add(nums[tobeselected]);
        powerSetGeneratorHelper(nums,powerSet,partiallist,tobeselected+1);
        partiallist.remove(partiallist.size()-1);
        powerSetGeneratorHelper(nums,powerSet,partiallist,tobeselected+1);
    }
}
