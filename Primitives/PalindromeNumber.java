class Solution {
    public boolean isPalindrome(int x) {
        
         if(x<0)
            return false;
        
       final int numDigits = (int)(Math.floor(Math.log10(x))) + 1;
       int powers = (int)Math.pow(10, numDigits - 1);
        
        while(x!=0){
            int lsb = x%10;
            int msb = Math.abs(x/powers);
            if(lsb!=msb)
                return false;
             x = x%powers;
             x = x/10;
            powers = powers/100;
        }
       return true;
    }
}
