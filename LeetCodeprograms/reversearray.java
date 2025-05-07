import java.util.Arrays;
import java.util.Scanner;
public class reversearray {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int index = 0; index < num.length; index++) {
            num[index]=scan.nextInt();
        }
        System.out.println(Arrays.toString(num));
        int temp;
        for(int i= 0;i<num.length/2;i++){
            temp=num[i];
            num[i]=num[N-i-1];
            num[N-i-1]=temp;
        }
        System.out.println(Arrays.toString(num));
    }
}
