import java.util.List;

class Equal{
    public int minimumOperationsToMakeEqual(int x, int y) {
        int count = 0;
        if(y>x){
            return y - x;
        }
        else{
        int dp[] = new int[x];
        for(int i = 0; i<x; i++){
           int no = i+1;
           if(no<=y){
               dp[i] = y-no;
           }
           else{
               int ibye = (no%11 == 0)? (dp[(no/11) - 1] + 1) : Integer.MAX_VALUE;
               int ifive = (no%5 == 0)? (dp[(no/5) - 1] + 1) : Integer.MAX_VALUE;
               dp[i] =  Math.min(Math.min(ibye, ifive), dp[i -1] + 1);
           }
        }
        System.out.println("six is" + dp[53]);
        return dp[x-1];
        }
    }

    public static void main(String args[]){
        int x = 54;
        int y = 2;
        Equal obj = new Equal();
        int result = obj.minimumOperationsToMakeEqual(x, y);
        System.out.println("res is" + result);
    }
}
