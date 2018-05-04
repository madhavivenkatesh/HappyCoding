/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length,n=nums2.length;
        if(m>n){
            int [] temp=nums1 ; nums1=nums2;nums2=temp;
            int templen=m;m=n;n=templen;
        }
        
        int imin=0,imax=m,halflen= (m+n+1)/2;
        
        while(imin<=imax){
            int leftpart = (imin+imax)/2;
            int rightpart = halflen -leftpart;
            
            if(leftpart<imax && nums1[leftpart]<nums2[rightpart-1])
                imin=imin+1;
            else if(leftpart>imin && nums1[leftpart-1]>nums2[rightpart])
                imax=imax-1;
            else{
                int maxleft = 0;
                if(leftpart==0){maxleft=nums2[rightpart-1];}
                else if(rightpart==0){maxleft=nums1[leftpart-1];}
                else {maxleft = Math.max(nums1[leftpart-1],nums2[rightpart-1]);}
                if((m+n)%2==1) {return maxleft;}
                
                int minright=0;
                if(leftpart==m){minright=nums2[rightpart];}
                else if(rightpart==n) {minright=nums1[leftpart];}
                else {minright=Math.min(nums1[leftpart],nums2[rightpart]);}
                
                return (maxleft+minright)/2.0;
                    
            }
        }
        return 0.0;
    }
}
