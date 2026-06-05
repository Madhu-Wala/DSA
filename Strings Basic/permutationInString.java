class Solution {
    public boolean checkInclusion(String s1, String s2) {
        s1=sort(s1);
        for(int i=0;i<=s2.length()-s1.length();i++){
            String s=s2.substring(i,i+s1.length());
            if(s1.equals(sort(s))){
                return true;
            }
        }
        return false;
    }
    public String sort(String s){
        char[] c=s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
