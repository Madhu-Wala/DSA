class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] C=new int[n];
        Set<Integer> setA=new HashSet<>();
        Set<Integer> setB=new HashSet<>();
        int common=0;
        for(int i=0;i<n;i++){
            setA.add(A[i]);
            setB.add(B[i]);
            if(setB.contains(A[i])){
                common++;
            }
            if(setA.contains(B[i]) && A[i]!=B[i]){
                common++;
            }
            C[i]=common;
        }
        return C;
    }
}
