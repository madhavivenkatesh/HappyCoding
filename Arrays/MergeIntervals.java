\*Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                if(a.start==b.start){
                    return a.end - b.end;
                }
                
                return a.start - b.start;
                
            }
        } );
        
        for(Interval inter:intervals)
            System.out.println(inter.start+" "+inter.end);
        
        if(intervals.size()==0 || intervals.size()==1)
            return intervals;
        
        LinkedList<Interval> result = new LinkedList<Interval>();
        
        for(Interval interval:intervals){
            if (result.isEmpty() || result.getLast().end < interval.start) {
                result.add(interval);
            }
            else {
                result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
        }
         return result;
       }
}
