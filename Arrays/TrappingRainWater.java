/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

class Solution {
    public int trap(int[] height) {
        
        int sum=0,maxH=-1,max=Integer.MIN_VALUE,maxindex=-1;
        
        if(height.length==0 || height.length==1)
            return 0;
        
        for(int i=0;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
                maxindex=i;
            }
        }
        
        
        int left=height[0];
        for(int i=1;i<maxindex;i++){
            if(height[i]>=left)
                left=height[i];
            else
                sum +=left-height[i];
            
        }
        
        int right=height[height.length-1];
        for(int i=height.length-2;i>maxindex;--i){
            if(height[i]>=right)
                right=height[i];
            else
                sum+=right-height[i];
        }
        
        return sum;
    }
}
