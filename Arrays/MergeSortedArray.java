class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int writeindex = m+n-1;
        int i=m-1;
        int j=n-1;
        
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[writeindex--] = nums1[i--];
            }else if(nums2[j]>nums1[i]){
                nums1[writeindex--] = nums2[j--];
            }else{
                nums1[writeindex--] = nums2[j--];
                //i--;
            }
        }
        
        while(j>=0){
           nums1[writeindex--] = nums2[j--];  
        }
         while(i>=0){
           nums1[writeindex--] = nums1[i--];  
        }
    }
}
