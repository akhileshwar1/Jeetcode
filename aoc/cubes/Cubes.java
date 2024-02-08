//import aoc.cubes.download.Download;

import java.net.URL;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Cubes{

    public int getGameNo(String s){
        String[] parts = s.split(" ");
        int no = Integer.parseInt(parts[1]);
        return no;
    }

    public int isPossible(String s){
     String[] main = s.split(":");
     int gameNo = getGameNo(main[0]);
     //System.out.println("gameno" + " " + gameNo);
     String sets = main[1];
     String[] subsets = sets.split(";");
     for(String sub : subsets){
         int set[] = {12, 13, 14};
         String[] cubes = sub.split(",");
         for(String c: cubes){
             String cube = c.trim(); 
             String[] colors = cube.split(" ");
             //System.out.println(colors[1] + colors[0]);
             int n = Integer.parseInt(colors[0]);
             String color = colors[1];
             if (color.equals("red")){
                 int r = set[0];
                 if((r - n) >= 0){
                     set[0] = r-n;
                 }
                 else{
                     return 0;
                 }
             }
            if (color.equals("green")){
                 int g = set[1];
                 if((g - n) >= 0){
                     set[1] = g-n;
                 }
                 else{
                     return 0;
                 }
             }
            else if (color.equals("blue")){
                 int b = set[2];
                 if((b - n) >= 0){
                     set[2] = b-n;
                 }
                 else{
                     return 0;
                 }
             }
            else{
                continue;
            }
     }
    }
    // all passed return true
    return gameNo;
    }

  public int powerCubes(String s){
     String[] main = s.split(":");
     int gameNo = getGameNo(main[0]);
     //System.out.println("gameno" + " " + gameNo);
     String sets = main[1];
     String[] subsets = sets.split(";");
     int R = 0;
     int G = 0;
     int B = 0;

     for(String sub : subsets){
         int set[] = {12, 13, 14};
         String[] cubes = sub.split(",");
         for(String c: cubes){
             String cube = c.trim(); 
             String[] colors = cube.split(" ");
             //System.out.println(colors[1] + colors[0]);
             int n = Integer.parseInt(colors[0]);
             String color = colors[1];
             if (color.equals("red")){
                 if(n > R){
                    R = n; 
                 }
             }
            if (color.equals("green")){
                 if(n  > G){
                     G = n;
                 }
             }
            else if (color.equals("blue")){
                 if(n  > B){
                     B = n;
                 }
             }
            else{
                continue;
            }
     }
    }
    // all passed return true
    return R*G*B;
    }



    public static void main(String args[]) throws IOException{
        String str = "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green";
        Cubes sub = new Cubes();
        String filePath = "input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int sum = 0;

        //process each line.
        while((line = reader.readLine()) != null){
            System.out.println(line);
            int res = sub.powerCubes(line);
            System.out.println(res);
            sum = sum + res; 
        }

        System.out.println(sum);
    }

}
