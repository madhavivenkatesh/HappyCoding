class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        int i=0,j=0,k=0;
        
        int[] intersectionarr = new int[nums1.length];
        //if(nums1.length==0 || nums2.length==0)
            //return intersection;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //System.out.println(nums1.length);
        //System.out.println(nums2.length);
            
        while(i<nums1.length && j<nums2.length){
            //intersectionarr = new int[nums1.length];
            //System.out.println(nums1[i]);
            //System.out.println(nums2[j]);
            
            if(nums1[i]==nums2[j] && (i==0 || nums1[i]!=nums1[i-1])){
                intersectionarr[k]=nums1[i];
                System.out.println(intersectionarr[k]);
                 ++k;
                 ++i;
                 ++j;
            }
                
            
            else if(nums1[i]<nums2[j])
                ++i;
            
            else
                ++j;
            
           
        }
        
        int b1[] = Arrays.copyOfRange(intersectionarr, 0, k);
        return b1;
    }
}
