/**

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.


 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    
    private static class compareInterval implements Comparator<Interval>{
        
        public int compare(Interval a,Interval b){
          return Integer.compare(a.start,b.start);
        }
    }
    
    public compareInterval compare = new compareInterval();
    
    public boolean canAttendMeetings(Interval[] intervals) {
        
        Arrays.sort(intervals,compare);
        
        for(Interval i:intervals)
            System.out.println(i.start+" "+i.end);
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i-1].end>intervals[i].start){
                //if(intervals[i-1].end >= intervals[i].end)
                    return false;
            }
        }
        
        return true;
    }
}
