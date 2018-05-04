/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/


class Solution {
    
    private static class ElemWithCount{
        int count;
        int elem;
        
        public ElemWithCount(int elem,int count){
            this.count = count;
            this.elem = elem;
        }
    }
    
        private static class Compare implements Comparator<ElemWithCount> {
        @Override
        public int compare(ElemWithCount e1, ElemWithCount e2) {
          return Integer.compare(e2.count, e1.count);
        }
    }

    public static final Compare COMPARE_VALUEWITHCOUNT= new Compare();
    
    public static List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> elemWithCountmap = new HashMap<Integer,Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<nums.length;i++){
            if(!elemWithCountmap.containsKey(nums[i]))
                elemWithCountmap.put(nums[i],1);
            else
                 elemWithCountmap.put(nums[i],elemWithCountmap.get(nums[i])+1);
        }
            
        PriorityQueue<ElemWithCount> maxheap = new PriorityQueue<ElemWithCount>(nums.length,COMPARE_VALUEWITHCOUNT);
        
        for(Map.Entry<Integer,Integer> entry:elemWithCountmap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            maxheap.add(new ElemWithCount(entry.getKey(),entry.getValue()));
        }
        
        for(int i=0;i<k;i++)
            result.add(maxheap.remove().elem);
        
        return result;
    }
}
