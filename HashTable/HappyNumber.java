class Solution {
    public boolean isHappy(int n) {
        
        int result=0;
        Set<Integer> uniqset = new HashSet<Integer>();
        
        while(result!=1){
            result = 0;
            while(n!=0){
                int lsb = n%10;
                n=n/10;
                result +=lsb*lsb;
            }
            if(!uniqset.contains(result)){
                uniqset.add(result);
                n=result;
            }else{
                return false;
            }
            
        }
        
        return true;
    }
}
