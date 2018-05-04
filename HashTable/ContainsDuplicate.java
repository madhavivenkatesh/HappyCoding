class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        if(nums.length==0)
            return false;
        
        Set<Integer> uniqset = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(uniqset.contains(nums[i])){
                return true;
            }else{
               uniqset.add(nums[i]); 
            }
        }
        return false;
    }
}
