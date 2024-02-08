import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class GrayCode{

    static boolean differByOneBit(int num1, int num2) {
        // XOR to find differing bits
        int xorResult = num1 ^ num2;

        // Count set bits in XOR result
        int countSetBits = countSetBits(xorResult);

        // If there is only one set bit, return true
        return countSetBits == 1;
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    public List<Integer> backtrack(List<Integer> lst, List<Integer> rem, List<Integer> og){
        if(lst.size() == og.size()){
            if(differByOneBit(lst.get(0), lst.get(lst.size() - 1))){
                    return lst;
                }
            else{
                return new ArrayList<>();
            }
        }
        for(int j = 0; j < rem.size(); j++){
            if(lst.size()==0 || differByOneBit(lst.get(lst.size() -1), rem.get(j))){
                List<Integer> tempList = new ArrayList<>(lst);
                tempList.add(rem.get(j));
                List<Integer> remList = new ArrayList<>(rem);
                remList.remove(j);
                List<Integer> res = backtrack(tempList, remList, og);
                if (!res.isEmpty()) {
                    return res; // Return the result if it's not an empty list
                }
            }
        }
        return new ArrayList<>();
    }


    public List<Integer> grayCode(int n) {
        List<Integer> og = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
        og.add(i);
        }
        List<Integer> rem = new ArrayList<>(og);
        return backtrack(new ArrayList<>(), rem, og);
    }

    public static void main(String args[]){
       int n = 2;
       GrayCode sub = new GrayCode();
       List<Integer> res = sub.grayCode(n);
       System.out.println(res);
     }
}
