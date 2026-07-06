class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        ArrayList<Integer> profit=new ArrayList<>();
        int k=0,i=1;
        while(i<prices.length){
            if(prices[i]<=prices[i-1]){
                i++;
                k=i-1;
                profit.add(maxProfit);
                maxProfit=0;
            }else{
                int diff=prices[i]-prices[k];
                maxProfit=Math.max(diff,maxProfit);
                i++;
            }
        }
        profit.add(maxProfit);
        for(int p:profit){
            totalProfit+=p;
        }
        return totalProfit;
    }
}
