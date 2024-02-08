import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class CombSum{

    public HashMap<List<Integer>, Integer> resultMap;

    public void backtrack(List<Integer> lst, HashMap<List<Integer>, Integer> resultMap, List<Integer> candidates, int target){

       int sum = lst.stream().mapToInt(Integer::intValue).sum();
       int i = 0;
       while(i < candidates.size()){
            List<Integer> temp = new ArrayList<>(lst);
            int tempSum = temp.stream().mapToInt(Integer::intValue).sum() +
                          candidates.get(i);
            if(tempSum < target){
            temp.add(candidates.get(i));
            backtrack(temp, resultMap, candidates, target);
            }
            else if(tempSum == target){
            temp.add(candidates.get(i));
            Collections.sort(temp);
            resultMap.put(temp, 1);
            }
            else{
                //do nothing
            }
            i++;
       }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> lst = new ArrayList<>();
        List<Integer> cands = Arrays.asList(Arrays.stream(candidates).boxed().toArray(Integer[]::new));
        resultMap = new HashMap<>();
        backtrack(lst, resultMap, cands, target);
        List<List<Integer>> list = new ArrayList<>(resultMap.keySet());
        List<List<Integer>> resultList = new ArrayList<>();
        for(List<Integer> set : list){
            List<Integer> subset = new ArrayList<>(set);
            resultList.add(subset);
        }
        return resultList;
    }

    public static void main(String args[]){
       int[] nums = {2, 3, 5};
       int target = 8;
       CombSum sub = new CombSum();
       List<List<Integer>> res = sub.combinationSum(nums, target);
       System.out.println(res);
     }
}
