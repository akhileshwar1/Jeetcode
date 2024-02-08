import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Subsets{
    
    public void backtrack(List<Integer> lst, HashSet<Integer> set,
            HashMap<HashSet<Integer>, Integer> hMap, Integer n){
        if(set.size() == n){
            hMap.put(set, 1);
        }
        else{
            int i = 0;
            while(i < lst.size()){
                HashSet<Integer> copySet = new HashSet<>(set);
                copySet.add(lst.get(i));
                List<Integer> copy = new ArrayList<>(lst);
                copy.remove(i);
                backtrack(copy, copySet, hMap, n);
                i++;
            }
        }
    }

    public void subsets(Integer[] nums, HashMap<HashSet<Integer>, Integer> hMap){
        int n = nums.length;
        List<Integer> lst = new ArrayList<>(Arrays.asList(nums));
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while(i <= lst.size()){
            HashSet<Integer> copy = new HashSet<>(set);
            backtrack(lst, copy, hMap, i);
            i++;
        }
    }

    public static void main(String args[]){
        Integer[] nums = {1, 2, 3};
        Subsets sub = new Subsets();
        HashMap<HashSet<Integer>, Integer> hMap = new HashMap<>(); 
        sub.subsets(nums, hMap);
        List<HashSet<Integer>> list = new ArrayList<>(hMap.keySet());
        List<List<Integer>> resultList = new ArrayList<>();
        for(HashSet<Integer> set : list){
            List<Integer> subset = new ArrayList<>(set);
            resultList.add(subset);
        }

        System.out.println(resultList);
    }

}
