class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oc=image[sr][sc];
        if(oc==color){
            return image;
        }
        image=helpFill(image,sr,sc,oc,color);
        return image;
    }
    private int[][] helpFill(int[][] image,int sr,int sc,int oc,int color){
        image[sr][sc]=color;
        if(sr-1>-1 && image[sr-1][sc]==oc){
            image=helpFill(image,sr-1,sc,oc,color);            
        }
        if(sr+1<image.length && image[sr+1][sc]==oc){
            image=helpFill(image,sr+1,sc,oc,color);
            
        }
        if(sc-1>-1 && image[sr][sc-1]==oc){
            image=helpFill(image,sr,sc-1,oc,color);
        }
        if(sc+1<image[0].length && image[sr][sc+1]==oc){
            image=helpFill(image,sr,sc+1,oc,color);
            
        }
        return image;
    }
}
