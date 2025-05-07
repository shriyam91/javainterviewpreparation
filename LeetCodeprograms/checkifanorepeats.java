import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class checkifanorepeats {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int index = 0; index < num.length; index++) {
            num[index]=scan.nextInt();
        }
        System.out.println("repetion of any number is a "+find(num)+" statement for this array");
    }
    // public static boolean find(int[] num){
    //     List<Integer> lt= new ArrayList<Integer>();
    //     for(int i: num){
    //         if( lt.contains(i)){
    //             return true;
    //         }
    //         else{
    //             lt.add(i);
    //         }
    //     }
    //     return false;
    // }

     public static boolean find(int[] num){
        for(int i=0;i<=num.length-2;i++){
            for(int j=i+1;j<=num.length-1;j++){
                if(num[i]==num[j]){
                    return true;
                }
            }
        }

        return false;
    }
}
