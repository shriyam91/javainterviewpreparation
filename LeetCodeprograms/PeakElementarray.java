import java.util.Scanner;

public class PeakElementarray {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
    }
    System.out.println("the peak element of the array is "+ findPeak(num));
    }
    public static int findPeak(int[] num){
        if (num[0] >= num[1])
            return 0;
        if (num[num.length - 1] >= num[num.length - 2])
            return num.length - 1;
        for(int i=1;i<=num.length-2;i++){
            
            if(num[i]>num[i-1]&& num[i]>num[i+1]){
                return i;
            }
        }
        return -1;
    }
}
