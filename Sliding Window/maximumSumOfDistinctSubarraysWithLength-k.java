class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int left=0;
        long ans=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            sum+=nums[right];
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            if(right-left+1 > k){
                //reduce window size
                sum-=nums[left];
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left])==0){
                    map.remove(nums[left]);
                }
                left++;
            }
            if(right-left+1 == k){
                if(map.size()==k){
                    ans=Math.max(sum,ans);
                }
            }
        }
        return ans;
    }
}
