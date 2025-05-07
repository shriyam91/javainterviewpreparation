import java.util.Arrays;
import java.util.Scanner;

public class MakeAllElementsEqual {
    public static void main(String[] args){
        //you are given an array of n elements, you have to find min no of 
        //operations to make all elements equal where in each operation
//an element can inc by 3 and so  difference b/w any of
//the two elements is a multiple of 3
        System.out.println("enter the size of array");

    int N= new Scanner(System.in).nextInt();
    int arr[]= new int[N];
    for(int i=0;i< arr.length;i++){
    System.out.println("enter the value for index i");
    arr[i]= new Scanner(System.in).nextInt();
       
    }
     int op= equalElements(arr);
     System.out.println(op+" operations are required to make all elements equal");

    }

    private static int equalElements(int[] arr) {
        //first sort the array in asc order so that we can easily get the 
        //maximum value
        Arrays.sort(arr);
        int max= arr[arr.length-1];
        int op=0;
        for(int i=0;i<=arr.length-2;i++){
            op= op+(max-arr[i])/3;
        }
        return op;
        }
    
}
