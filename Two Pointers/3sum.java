class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result=new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        int l,r,sum;
        if(nums==null || n<3)return new ArrayList<>();
        for(int i=0;i<n-2;i++){
            l=i+1;
            r=n-1;
            while(l<r){
                sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                } else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
