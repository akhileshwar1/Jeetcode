import java.util.List;

class Zeros{
    
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        for(int i =0; i< length; i++){
            if(arr[i] == 0 && ((i+1) < length)){
                int prev = arr[i +1];
                //shifting to the right.
                for (int j = i +2; j < length; j++){
                    int temp = arr[j];
                    arr[j] = prev;
                    prev = temp;
                }
               //duplicate the zero.
               arr[i + 1] = 0;
               // next loop should start from here.
               i = i + 2;
            }
    }

    for (int i = 0; i< length; i++){
    System.out.println("arr is" + arr[i]);
    }
    }


       public int getElement(int[] tops, int[] bottoms, char n, int pos){
           if(n == '0'){
               return tops[pos];

           }
           else{
               return bottoms[pos];
           }
       }

       public long minDominoRotations(int[] tops, int[] bottoms) {
           long length = tops.length;
                      long min = -1;  // the loop has to run entirely below as min no of rotations can be in any integer.
           for(long i =0; i < Math.pow(2, length); i++){
               long topCounter = 0;
               long bottomCounter = 0;
               String number = Long.toBinaryString(i);
               System.out.println("binary" + number);
               int element = getElement(tops, bottoms, number.charAt(0), 0);
               System.out.println("element" + element);
               for(int j = 1; j< number.length(); j++){
                   char c = number.charAt(j);
                   int present = getElement(tops, bottoms, c, j);
                   System.out.println("present and prev" + present + element + c);
                   if(present != element){
                       break;
                   }
                   else{
                       if(c == '0'){
                           topCounter++;
                       }
                       else{
                           bottomCounter++;
                       }
                   }
               }

               if(topCounter == 0 && bottomCounter == 0){
                   min = min;
               }
               else if(topCounter < bottomCounter){
                   if(min == -1 || topCounter < min){
                       min = topCounter;
                   }
               }
               else if(bottomCounter < topCounter){
                   if(min == -1 || bottomCounter < min){
                       min = bottomCounter;
                   }
               }

           }

           return min;
       }
           

    public static void main(String[] args){
        int arr[] = {1, 0, 0, 1};
        int tops[] = {2, 1, 2, 4, 2, 2};
        int bottoms[] = {5, 2, 6, 2, 3, 2};
        int topss[] = {2, 1};
        int bss[] = {1, 2};
        Zeros obj = new Zeros();
        obj.duplicateZeros(arr);
        long res = obj.minDominoRotations(topss, bss);
        System.out.println("res is" + res);
    }

}
