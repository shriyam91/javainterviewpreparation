import java.util.Arrays;
import java.util.Scanner;

public class FreeTestingProgram {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.print("enter the size of array");
        int n= scan.nextInt();
        scan.nextLine();
        char[] arr= new char[n];
        for(int i=0;i< n;i++){
            System.out.println("enter the value for index i");
            arr[i]=scan.next().charAt(0);
        }
        
        System.out.print(Arrays.toString(arr));
        
    }
    
}
