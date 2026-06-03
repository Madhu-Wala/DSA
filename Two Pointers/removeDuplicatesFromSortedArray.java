class Solution {
    public int removeDuplicates(int[] nums) {
        int s=0;
        for(int f=1;f<nums.length;f++){
            if(nums[s]!=nums[f]){
                s++;
                nums[s]=nums[f];
            }
        }
        return s+1;
    }
}
