class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length-1;
        int i=0;
        int j = n;
        int[] result=new int[n+1];
        for(int p=n;p>=0;p--){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                result[p]=nums[i]*nums[i];
                i++;
            }else{
                result[p]=nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}
