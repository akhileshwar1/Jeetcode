import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Mps{


    public int minPathSum(int[][] grid) {
        int iLen = grid.length;
        int jLen = grid[0].length;
        int[][] sumGrid = new int[iLen][jLen];

       for(int i = 0; i< iLen; i++){
           for(int j =0; j< jLen; j++){
               if(i ==0 && j ==0){
                sumGrid[i][j] = grid [i][j];
               }
               else if(i == 0){
                sumGrid[i][j] = sumGrid[i][j-1] + grid[i][j];
               }
               else if(j == 0){
                sumGrid[i][j] = sumGrid[i-1][j] + grid[i][j];
               }
               else{
               sumGrid[i][j] = Math.min(sumGrid[i-1][j], sumGrid[i][j-1]) + grid[i][j];

           }
       }
       }
       return sumGrid[iLen-1][jLen-1];
    }


    public static void main(String args[]){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        Mps sub = new Mps();
        int minSum = sub.minPathSum(grid);
        System.out.println(minSum);
    }


}
