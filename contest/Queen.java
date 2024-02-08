import java.util.List;

// Min moves to capture the queen.
class Queen{

    public int minRook(int a, int b, int c ,int d, int e, int f){
        int deltaX = a - e;
        int deltaY = b - f;
        int deltaRBX = a - c;
        int deltaRBY = b - d;
        // cannot jump over other pieces.
        if(deltaRBX == 0 && Math.abs(deltaY) > Math.abs(deltaRBY)){
            return -1;
        }
        else if(deltaRBY == 0 && Math.abs(deltaX) > Math.abs(deltaRBX)){
            return -1;
        }
        else if(deltaX == 0 || deltaY == 0){
            return 1;
        }
        else{
            return 2;
        }
    }

    public int minBishop(int c, int d, int e, int f){
        int deltaX = c - e;
        int deltaY = d - f;
        int result;
        // checking if they are not on the same colored squares on the board.
        if(deltaX%2!=0){
            result = -1; //not possible for bishop.
        }
        else{
            result = (deltaX == deltaY)? 1: 2; 
        }
        return result;
    }


    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
    int result;
    int rookSteps = minRook(a, b, c, d, e, f);
    int bishopSteps = minBishop(c, d, e, f);
    if(rookSteps > 0 && bishopSteps > 0){
        result = Math.min(rookSteps, bishopSteps);
    }
    else{
        result = rookSteps > 0 ? rookSteps :bishopSteps;
    }
    return result;
    }

    public static void main(String args[]){
        Queen obj = new Queen();
        int res = obj.minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8);
        System.out.println("res is" + res);
    }

}
