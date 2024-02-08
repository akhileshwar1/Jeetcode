import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Subsets{
    public List<Integer> getList(List<Integer> elem, List<Integer> nums){
        int length = elem.size();
        int last = elem.get(length - 1);
        int index = nums.indexOf(last);
        List<Integer> lst = nums.subList(index+1, nums.size());
        return lst;
    }

    public List<List<Integer>> generate(List<List <Integer>> elems, List<List <Integer>> result, List<Integer> nums, int n)
    {
        List<List <Integer>> newElems = new ArrayList();
        if(elems.get(0).size() == n){
            return result;
        }
        else{
            for(List<Integer> elem: elems){
                List<Integer> lst = getList(elem, nums);
                for(int k: lst){
                    List<Integer> newElem = new ArrayList<>(elem);
                    newElem.add(k);
                    newElems.add(newElem);
                    result.add(newElem);
                }
            }
            return generate(newElems, result, nums, n);
        }                    
    }

    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result = new ArrayList();
       List<Integer> emptyList = new ArrayList();
       result.add(emptyList);
       for(int i = 0; i < nums.length; i++){
           List<Integer> elemArr = new ArrayList();
           elemArr.add(nums[i]);
           result.add(elemArr);
       }
       List<Integer> numss = Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new));
       List<List<Integer>> subListCopy = new ArrayList<>(result.subList(1, result.size()));
       return generate(subListCopy, result, numss, numss.size());
    }

    public static void main(String args[]){
       int[] nums = {1, 2, 3, 4};
       Subsets sub = new Subsets();
       List<List<Integer>> res = sub.subsets(nums);
       System.out.println(res);
     }
}
