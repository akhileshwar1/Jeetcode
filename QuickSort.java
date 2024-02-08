import java.util.Arrays; // Correct the import statement

public class QuickSort {

    public int halve(int[] nums){
        int len = nums.length;
        int result[][] = new int[2][];
        int pivot = nums[len-1];
        int s = -1;
        int temp;

        for(int i = 0; i<len-1; i++){
            if (nums[i] <= pivot){
                s = s + 1;
                temp = nums[s];
                nums[s] = nums[i];
                nums[i] = temp;
            }
        }
        nums[s+1]=nums[len-1];
        return s + 1;
    }

    public int[] quick(int[] nums) {
        int len = nums.length;
        int half = len/2;
        int result[] = new int[len];
       
        int pivot = halve(nums);
        int[] firstHalf = Arrays.copyOfRange(nums, 0, pivot + 1); 
        int[] secondHalf = Arrays.copyOfRange(nums, pivot + 2, len);;

        int[] sortedFirst = quick(firstHalf);
        int[] sortedSecond = quick(secondHalf);
       
        // Merge them directly.
        System.arraycopy(sortedFirst, 0, result, 0, sortedFirst.length);
        System.arraycopy(sortedSecond, 0, result, sortedFirst.length, sortedSecond.length);

        return result; // Add a return statement to return the result array
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = obj.quick(nums);
        System.out.println("result is " + Arrays.toString(result)); // Print the array contents
    }
}
