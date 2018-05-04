class Solution {
    public int maxArea(int[] height) {
        
        int width;
        int maxwatervol = Integer.MIN_VALUE;
        int currwatervol = 0;
        int i=0,j=height.length-1;
        
        while(i<j){
            width = j-i;
            currwatervol = width * Math.min(height[i],height[j]);
            maxwatervol = Math.max(maxwatervol,currwatervol);
            
            if(height[i]>height[j])
                --j;
            else if(height[j]>height[i])
                ++i;
            else
            {
                ++i;
                --j;
            }
        }
        
        return maxwatervol;
    }
}
