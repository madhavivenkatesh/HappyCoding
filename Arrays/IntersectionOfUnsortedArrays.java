class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int m = nums1.length , n=nums2.length,i=0,j=0,k=0;
        int[] intersection = new int[m+n];
        
        if(nums1.length==0 || nums2.length==0)
            return new int[0];
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while(i<m && j<n){
            
            if(nums1[i]<nums2[j])
                i++;
            else if(nums2[j]<nums1[i])
                j++;
            else{
               intersection[k++] = nums1[i] ;
                i++;
                j++;
            }
        }
        
        int[] result = Arrays.copyOfRange(intersection,0,k);
        return result;
    }
}
