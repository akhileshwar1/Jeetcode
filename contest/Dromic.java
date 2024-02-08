import java.util.List;

class Dromic {

    public int convertToPalin(int n){
        String num = n + "";
        int length = num.length();
        StringBuilder sb = new StringBuilder(num);
        for(int i = 0; i<length/2; i++){
            sb.setCharAt(length - 1 - i, sb.charAt(i));
        }
        String updated = sb.toString();
        return Integer.parseInt(updated);
        }

    public long minimumCost(int[] nums) {
        int sum = 0;
        int length = nums.length;
        for(int i = 0; i< length; i++){
            sum = sum + nums[i];
        }
        int mean = sum/length;
        int palin = convertToPalin(mean);
        int cost = 0;
        for(int i= 0; i< length; i++){
            int diff = nums[i] - palin;
            cost = cost + Math.abs(diff);
        }
        return cost;
    }

    public static void main(String args[]){
        int x = 543;
        int y = 5443;
        int z = 54;
        int a = 1;
        Dromic obj = new Dromic();
        int nums[] = {10, 12, 13, 14, 15};
        System.out.println("res is" + 
                obj.minimumCost(nums));

    }
    }

    

