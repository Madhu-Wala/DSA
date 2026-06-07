class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=0,r=nums.length-1,mid=-1;
        while(l<=r){
            mid=l+(r-l)/2;
            if(nums[mid]==target){
                int start=mid;
                int end=mid;
                while(end+1 <nums.length && nums[end+1]==target){
                    end++;
                }
                while(start-1 >=0 && nums[start-1]==target){
                    start--;
                }
                return new int[]{start,end};
            }
            else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
}
