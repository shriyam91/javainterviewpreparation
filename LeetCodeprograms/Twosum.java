import java.util.Arrays;
import java.util.Scanner;

public class Twosum {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
    }
    System.out.println("enter the target");
    int target= scan.nextInt();
    int result[]= findSum(num, target );
    System.out.println(Arrays.toString(result));
    }
    public static int[] findSum(int[] nums, int target){
        int[] result= new int[2];
        int res=0;
        
            for(int i = 0; i < nums.length; i++){
                for(int j = i+1; j < nums.length; j++){
                    if(nums[i] + nums[j] == target){
                        result[0]=i;
                        result[1]=j;
                    }
                }
            }
            return result;
        }
        

    }

