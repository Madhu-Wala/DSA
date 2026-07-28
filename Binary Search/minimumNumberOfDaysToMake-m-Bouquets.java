class Solution {
    private boolean canMakeBouquets(int[] bloomDay,int m,int k,int days){
        int bouquet=0;
        int countAdjacentFlowers=0;
        for(int day:bloomDay){
            if(day<=days){
                countAdjacentFlowers++;
                if(countAdjacentFlowers==k){
                    bouquet++;
                    countAdjacentFlowers=0;
                }
            }else{
                countAdjacentFlowers=0;
            }
        }
        return bouquet>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k){
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canMakeBouquets(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;

    }
    
}
