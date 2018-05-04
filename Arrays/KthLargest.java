class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int low =0,high=nums.length-1,n=nums.length;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            System.out.println("mid "+mid);
            int newindex = findNewPivotIndex(nums,low,mid,high);
            System.out.println("newindex "+newindex);
            if(newindex == (k-1))
                return nums[newindex];
            else if(newindex>(k-1))
                high=newindex-1;
            else
                low=newindex+1;
        }
        
        return -1;
    }
    
    public int findNewPivotIndex(int[] nums,int low,int pivotindex,int high){
        
        int pivotvalue = nums[pivotindex];
        displayArray(nums,low,high);
        swap(nums,high,pivotindex);
        displayArray(nums,low,high);
        for(int i=low;i<=high;i++){
            if(nums[i]>pivotvalue)
                swap(nums,low++,i);
        }
        swap(nums,high,low);
        displayArray(nums,low,high);
        //System.out.println(nums);
        return low;
    }
    
    public void displayArray(int[] nums,int low,int high){
         for(int i=low;i<=high;i++)
             System.out.print(nums[i]);
        System.out.println();
    }
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
