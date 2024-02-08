import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class WordSearch{

    public static List<int[]> findIndices(char[][] board, char target) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == target) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }
    public static List<int[]> generateCoordinates(int x, int y, int numRows, int numCols, int prev) {
    // -1 is for left, 1 is for right, -2 is for down, 2 is for up.
    // prev here is the previous move direction.
    List<int[]> result = new ArrayList<>();

    if ((x + 1 < numRows) && (prev != -1)) {
        result.add(new int[]{x + 1, y, 1});  // right
    }
    if ((x - 1 >= 0) && (prev != 1)) {
        result.add(new int[]{x - 1, y, -1});  // left
    }
    if ((y + 1 < numCols) && (prev != -2)) {
        result.add(new int[]{x, y + 1, 2});  // up
    }
    if ((y - 1 >= 0) && (prev != 2)) {
        result.add(new int[]{x, y - 1, -2});  // down
    }

    return result;
}

    public boolean backtrack(int x, int y, int i, String word, char[][] board, String target, int prev){
        if(word.equals(target)){
            return true;
        }
        else if(board[x][y] != target.charAt(i)){
            return false;
        }
        else{
            //append to the word, and then check all the possibilities.
            String newWord = word + board[x][y];
            //given x, y iterate over horizontal and vertical possiblities.
            List<int[]> coords = generateCoordinates(x, y, board.length, board[0].length, prev);
            if(coords.isEmpty() && newWord.equals(target)){
                return true;
            }
            for(int[] coord:coords){
                int nx = coord[0];
                int ny = coord[1];
                boolean res = backtrack(nx, ny, i+1, newWord, board, target, coord[2]);
                if (res){
                    return res;
                }

            }
            return false;
            }
    }

    public boolean exist(char[][] board, String word) {
        //get the starting posns for the first letter. 
        List<int[]> inds = findIndices(board, word.charAt(0));
        for(int[] ind: inds){
            int x = ind[0];
            int y = ind[1];
            boolean res = backtrack(x, y, 0, "", board, word, 0);
            if(res){
                return res;
            }
            }
        return false;
    }

    public static void main(String args[]){
        char[][] board =  {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        char[][] board1 = {{'a'}};
        String word = "a";
        WordSearch wr = new WordSearch();
        boolean res = wr.exist(board1, word);
        System.out.println("res is" +res); 
    }
}
