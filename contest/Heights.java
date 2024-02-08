import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.regex.*;

class Heights{
    public int heightChecker(int[] heights) {
        List<Integer> lst = new ArrayList<>();
        for (int height : heights){
            lst.add(height);
        }
        Collections.sort(lst);
        int counter = 0;
        for(int i = 0; i<lst.size(); i++){
            if(lst.get(i) != heights[i]){
                counter++;
            }
        }
        return counter;
    }

    public boolean isLongPressedName(String name, String typed) {
        String regex = "^";
        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            regex = regex + c + '+';
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(typed);
        return matcher.matches();
    }

    public static void main(String[] args){

        int[] heights = {1, 1, 4, 2, 1, 3};
        String typed = "sakkkhhhiill";
        String name = "akhil";
        Heights h = new Heights();
        int result = h.heightChecker(heights);
        boolean res = h.isLongPressedName(name, typed);
        System.out.println("Heights: " + result + res);
    }
}
