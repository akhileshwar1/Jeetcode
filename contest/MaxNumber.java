import java.util.List;

class MaxNumber{

    public int getPrice(long n, int x){
        String b = Long.toBinaryString(n);
        System.out.println(b);
        int sum = 0;
        int i = (b.length() - 1) - (x - 1);
        
        while(i>=0){
            if(b.charAt(i) == '1'){
                sum++;
            }
            i = i - x;
        }
        System.out.println(sum);
        return sum;
    }

    public long findMaximumNumber(long k, int x) {
        int sum = 0;
        long i = 1;
        while(true){
            int price = getPrice(i, x);
            if((sum + price) <= k){
                sum = sum + price;
                i++;
            }
            else{
                return i - 1;
            }
        }
    }

    public static void main(String args[]){
        long k = 9;
        int x = 1;
        int n = 9;
        MaxNumber obj = new MaxNumber();
        //int ress = obj.getPrice(n, x);
        long res = obj.findMaximumNumber(k, x);
        System.out.println(res);
    }
}
