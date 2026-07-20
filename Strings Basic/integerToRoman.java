class Solution {
    private char getSymbol(int n){
        switch (n){
            case 1000: return 'M';
            case 500:  return 'D';
            case 100:  return 'C';
            case 50:   return 'L';
            case 10:   return 'X';
            case 5:    return 'V';
            case 1:    return 'I';
            default:   return ' ';
        }
    }
    private void processValue(StringBuilder sb,int q,int d){
        if(q==0) return ;
        if(d==1000) {
            for (int i = 0; i < q; i++) sb.append('M');
            return;
        }
        char base=getSymbol(d);
        char five=getSymbol(d*5);
        char ten=getSymbol(d*10);
        if(q<=3){
            for (int i = 0; i < q; i++) sb.append(base);
        }else if(q==4){
            sb.append(base).append(five);
        }else if(q<=8){
            sb.append(five);
            for(int i=0;i<q-5;i++) sb.append(base);
        }else{
            sb.append(base).append(ten);
        }
    }
    public String intToRoman(int num) {
        int d=1000;
        StringBuilder sb=new StringBuilder();
        int q;
        while(d>=1){
            q=num/d;
            processValue(sb,q,d);
            num=num%d;
            d=d/10;
        }
        return sb.toString();
    }
}
