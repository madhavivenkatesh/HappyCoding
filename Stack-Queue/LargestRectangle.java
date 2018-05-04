/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxrectarea = 0;
        Deque<Integer> histogramindexes = new LinkedList<Integer>();
        
        for(int i=0;i<=heights.length;i++){
            
            if(!histogramindexes.isEmpty() && i<heights.length && heights[(int)histogramindexes.peekFirst()]==heights[i]){
                histogramindexes.removeFirst();
                histogramindexes.addFirst(i);
            }
            
            while(!histogramindexes.isEmpty() && (i==heights.length || heights[(int)histogramindexes.peekFirst()]>heights[i])){
                
                int height = heights[(int)histogramindexes.removeFirst()];
                int width = histogramindexes.isEmpty()?i:i-(int)histogramindexes.peekFirst()-1;
                maxrectarea = Math.max(maxrectarea,height*width);
            }
            
            histogramindexes.addFirst(i);
            
        }
        
        return maxrectarea;
        
    }
}
