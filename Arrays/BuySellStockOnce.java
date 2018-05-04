class Solution {
    public int maxProfit(int[] prices) {
        
        int minpricesofar=Integer.MAX_VALUE , maxprofit=0;
        
        for(int i=0;i<prices.length;i++){
            minpricesofar = Math.min(minpricesofar,prices[i]);
            maxprofit = Math.max(maxprofit,prices[i]-minpricesofar);
        }
        
        return maxprofit;
    }
}
