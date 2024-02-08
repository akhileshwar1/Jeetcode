import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class LongPalin{

    HashMap<List<Integer>, String> resultMap; //for memoization.

    public boolean isPalin(String s){
        String res = "";
        for(int i = s.length() -1; i>=0; i--){
            res = res + s.charAt(i);
        }
        if(res.equals(s)){
            return true;
        }
        else{
            return false;
        }
    }

    public String dp(String s, int start, int end){
        if(isPalin(s.substring(start, end))){
            System.out.println("" + start + end);
            resultMap.put(new ArrayList<>(Arrays.asList(start, end)), s.substring(start, end));
            return s.substring(start, end);
        }
        else{
            String res1 = dp(s, start + 1, end);
            String res2 = dp(s, start, end - 1);
            if(res1.length() >= res2.length()){
                resultMap.put(new ArrayList<>(Arrays.asList(start, end)), res1);
                return res1;
            }
            else{
                resultMap.put(new ArrayList<>(Arrays.asList(start, end)), res2);
                return res2;
            }

        }
    }


    public String longestPalindrome(String s) {
        resultMap = new HashMap<>();
        String result = dp(s, 0, s.length()); 
        return result;
    }

    public static void main(String args[]){
        String str = "cbbd";
        LongPalin sub = new LongPalin();
        boolean flag = sub.isPalin(str);
        String res = sub.longestPalindrome(str);
        System.out.println(res);
    }
}
