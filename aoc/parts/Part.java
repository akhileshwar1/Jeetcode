import java.net.URL;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Part{

    private static String readFileToString(String filePath) throws IOException {
        // Use Paths.get to obtain a Path object from the file path
        Path path = Paths.get(filePath);

        // Use Files.readString to read the contents of the file into a string
        return Files.readString(path);
    }

    public int check(String s){
     int i = 0;
     int sum = 0;
     int length = s.length();
     while (i< s.length()){
         String no = "";
         char c = s.charAt(i);
         if(c == '\n'){
             System.out.println(" line break!" + c);
         }

         int j = i;
         if(Character.isDigit(c)){
             while(Character.isDigit(s.charAt(j))){
                 no = no + s.charAt(j);
                 j++; //double hora.
             }
         
         //System.out.println("n is " + no);
         // at this point you have your i and j.
         // the places to check for symbols are --
         // i-1-len to j+1+len (top left to bottom right), any one should tick.
         int row = -141; //used to switch rows, starts from the prev row.
         outerloop:
         while(row <= 141 && (j+row < length)){
             int st;
             if(i-1+row>0){
                 st = i-1+row;
             }
             else{
                 st = i;
             }
             for (int start = st; start<= j+row; start++){
                 char sym = s.charAt(start);
                 if(!(Character.isDigit(sym) || sym == '.' || sym == '\n'
                             || sym == ' ')){
                 System.out.println("no is " + no);
                     sum = sum + Integer.parseInt(no);
                     break outerloop;
                 }
             }
             row = row + 141; //to the next row.
         }
         }
         i = j+1;
    }
    return sum;
    }


    public static void main(String args[]) throws IOException{
        Part pt = new Part();
        //String str =  "467..114..\n" +
         //             "...*......\n" +
          //            "..35..633.\n";
        String str = readFileToString("parts.txt");
        int sum = pt.check(str);
        System.out.println(sum);
    }
}
