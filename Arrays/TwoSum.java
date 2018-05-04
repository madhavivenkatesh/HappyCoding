class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> table = new HashMap<Integer,Integer>();
        
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        for(int i=0;i<nums.length;i++){
            int remaining = target - nums[i];
            if(table.containsKey(remaining)){
                result[0] = table.get(remaining);
                result[1] = i;
                return result;
            }
            table.put(nums[i],i);
                
        }
        return result;
   }
}
