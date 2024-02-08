import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class LongPalin{

    public String palin;

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

    public String iter(String s){
        int len = s.length();
        if (len == 1){
            palin = s;
        }
        for(int i = 0; i < len; i++){
            for (int j = len; j>i; j--){
                String substr = s.substring(i, j);
                if(isPalin(s.substring(i,j)) && (palin.length() < s.substring(i,j).length())){
                    palin = substr; //only update the longest palin var.
                }
               
            }
            System.out.println("palin" + " " + palin);
        }
        return palin;
    }

    public String longestPalindrome(String s) {
        palin = "";
        String result = iter(s); 
        return result;
    }

    public static void main(String args[]){
        String str = "bacabab";
        LongPalin sub = new LongPalin();
        String res = sub.longestPalindrome(str);
        System.out.println(res);
    }
}
