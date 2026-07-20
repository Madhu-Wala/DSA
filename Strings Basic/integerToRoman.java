class Solution {
    private String getSymbol(int n){
        switch (n){
            case 1000: return "M";
            case 500: return "D";
            case 100: return "C";
            case 50: return "L";
            case 10: return "X";
            case 5: return "V";
            case 1: return "I";
            default: return "";
        }
    }
    private String processValue(int q,int d){
        if(q==0) return "";
        if(d==1000) return getSymbol(d).repeat(q);
        String base=getSymbol(d);
        String five=getSymbol(d*5);
        String ten=getSymbol(d*10);
        if(q<=3){
            return base.repeat(q);
        }else if(q==4){
            return base+five;
        }else if(q<=8){
            return five+base.repeat(q-5);
        }else{
            return base+ten;
        }
    }
    public String intToRoman(int num) {
        int d=1000;
        StringBuilder sb=new StringBuilder();
        int q;
        while(d>=1){
            q=num/d;
            sb.append(processValue(q,d));
            num=num%d;
            d=d/10;
        }
        return sb.toString();
    }
}
