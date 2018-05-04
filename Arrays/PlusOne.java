class Solution {
    public int[] plusOne(int[] digits) {
        
        digits[digits.length-1] = digits[digits.length-1]+1;
        int[] result;
        
        for(int i=digits.length-2;i>=0;--i){
            if (digits[i+1]>9){
                digits[i+1]=0;
                digits[i]=digits[i]+1;
            }
        }
        
        if(digits[0]>9) {
            digits[0]=0;
            result = new int[digits.length+1];
            result[0]=1;
            for(int i=1;i<digits.length;i++)
                result[i]=digits[i];
            return result;
        } 
        
        return digits;
    }
}
