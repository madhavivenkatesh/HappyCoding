class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i=left;i<=right;i++){
            if(isSelfDividing(i)){
                result.add(i);
            }
        }
        
        return result;
    }
    
    public boolean isSelfDividing(int num){
        
        //int n = (int)Math.log10(num)+1;
        //System.out.println(n);
        //int power = (int)Math.pow(10,n-1);
        //System.out.println(power);
        
        int n=num;
        
        if(num%10==0)
            return false;
        
        while(n!=0){
            int lsb = n%10;
            System.out.println(lsb);
            if(lsb==0 || (num%lsb)!=0)
                return false;
            n=n/10;
        }
        return true;
    }
}
