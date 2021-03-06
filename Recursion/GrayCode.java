/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.*/

class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> reslist = new ArrayList<Integer>();
        
        if(n==0){
            reslist.add(0);
            return reslist;
        }
           
        
        reslist = grayCode(n-1);
        int leadingbits = 1 << (n-1);
        
        for(int i=reslist.size()-1;i>=0;i--){
            reslist.add(leadingbits|reslist.get(i));
        }
        
        return reslist;
    }
}
