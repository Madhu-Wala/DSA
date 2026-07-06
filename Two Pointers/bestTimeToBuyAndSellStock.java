class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int k=0,i=1;
        while(i<prices.length){
            if(prices[i]<=prices[k]){
                i++;
                k=i-1;
            }else{
                int diff=prices[i]-prices[k];
                maxProfit=Math.max(diff,maxProfit);
                i++;
            }
        }
        return maxProfit;
    }
}
