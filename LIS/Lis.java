import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Lis{
   
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[][] table = new int[length][length];

        //get the diagnols i.e the starts at each row as 1.

        for(int i=0; i<length -1; i++){
            for(int j = i+1; j<length; j++){
                if((j - i) == 1){
                    table[i][j] = 1;
                    break;
                }
            }
        }

        int max = 0; //row wise last max element.
        int smax = 0;
        int tableMax = 0; // LIS length.
        int rowMax = 0;
        for(int i=0; i<length -1; i++){
            for(int j = i+1; j<length; j++){
                if((j - i) == 1){  //initialize max to the first element.
                    max = nums[j-1];
                }
                else if(nums[j - 1] > max){ //where next number increases.
                    table[i][j] = table[i][j-1] + 1;
                    max = nums[j-1];
                }
                else if(nums[j - 1] > smax){ //still bigger than the first, so start new count.
                    table[i][j] = table[i][j-1];
                    max = nums[j-1];
                }
                else{
                    table[i][j] = table[i][j-1]; //forward the previous length.
                }
                rowMax = table[i][j];  //rowmax is always last cell of the row.
            }
            //update entiremax here from table.
            System.out.println("rowmax is" + rowMax);
            if(rowMax > tableMax){
                tableMax = rowMax;
            }
        }
    return tableMax;    
    }


    public static void main(String args[]){
        int[] nums = {0, 1, 0, 3, 2, 3};
        int[] nums1 = {10,9,2,5,3,7,101,18};
        int[] nums3 = {7,7,7,7};
        Lis sub = new Lis();
        Arrays.sort(nums1);
        int res = sub.lengthOfLIS(nums1);
        System.out.println(res);
    }

}
