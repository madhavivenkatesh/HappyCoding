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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        List<Interval> result = new ArrayList<Interval>();
        int i=0;
        
        if(intervals.size()==0){
            result.add(newInterval);
            return result;
        }
            
        
        while(i<intervals.size() && newInterval.start > intervals.get(i).end){
            result.add(intervals.get(i));
            i++;
        }
        
        while(i<intervals.size() && newInterval.end >= intervals.get(i).start){
            int newstart = Math.min(newInterval.start,intervals.get(i).start);
            int newend = Math.max(newInterval.end,intervals.get(i).end);
            newInterval = new Interval(newstart,newend);
            i++;
        }
        
        result.add(newInterval);
        //System.out.println(i);
        result.addAll(intervals.subList(i,intervals.size()));
        return result;
        
    }
}
