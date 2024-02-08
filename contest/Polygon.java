import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Polygon{

    public long largestPerimeter(int[] nums) {
        // Convert it to an array of Integer
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.valueOf(nums[i]);
        }
        // in descending order.
        Arrays.sort(arr, Collections.reverseOrder());
        int sum = 0;
        for(Integer n: arr){
            sum = sum + n;
        }
        int max = -1;
        int len = arr.length;
        //iterate over the arr and calculate max.
        for(int i = 0; i< len; i++){
          int side = arr[i];
        //  System.out.println(side);
          int otherSum = sum - arr[i];
          int k = (len - 1) - i;
          if(otherSum> side && k >= 2){
              max = Math.max(max, otherSum + side);
          }
        System.out.println(side + " " + max);
        sum = otherSum;
        }
        return max;
    }


    public static void main(String args[]){
        int[] nums = {1,1,2,3,5,12,50};
        int[] numss = {5, 5, 50};
        Polygon obj = new Polygon();
        long res = obj.largestPerimeter(numss);
        System.out.println("res is" + res);
    }
}
