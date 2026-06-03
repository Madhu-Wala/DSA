class Solution {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxArea=0;
        int h,w;
        while(l<r){
            h=Math.min(height[l],height[r]);
            w=Math.abs(l-r);
            maxArea=Math.max(maxArea,h*w);
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxArea;
    }
}
