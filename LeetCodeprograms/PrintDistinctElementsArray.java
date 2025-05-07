import java.util.ArrayList;
import java.util.Scanner;

public class PrintDistinctElementsArray {
//     Given an integer array, print all distinct elements in an array. The given array may contain duplicates and the output should print every element only once. The given array is not sorted.
// Examples: 
// Input: arr[] = {12, 10, 9, 45, 2, 10, 10, 45}
// Output: 12, 10, 9, 45, 2
// Input: arr[] = {1, 2, 3, 4, 5}
// Output: 1, 2, 3, 4, 5
// 
public static void main(String[] args) {
    System.out.println("enter the size of array");
    int N= new Scanner(System.in).nextInt();
   int arr[]= new int[N];
    for(int i=0;i<N;i++){
    System.out.println("enter the value for index "+i);
        arr[i]= new Scanner(System.in).nextInt();
    }
    Integer[] Iar= uniqueArray(arr);
    for(Integer ii:Iar){
        System.out.println("unique values are"+ii);
    }
    uniqueArrayInPlace(arr);
    uniqueArrayInPlace2(arr);
}

private static Integer[] uniqueArray(int[] arr) {
    ArrayList<Integer> al= new ArrayList<>();   
    for(int ii: arr){
        if( al.contains(ii)){
            continue;
        }
        else{
            al.add(ii);
        }
    } 
    return al.toArray(new Integer[0]);
    }

    private static void uniqueArrayInPlace(int[] arr) {
//printing the 1st element of the array bcz its 1st so till now its unique
        System.out.println("unique element is "+arr[0]);
    for(int i=1;i<=arr.length-1;i++){//running outer loop from 2nd element to last element
        int j;
        for(j=0;j<i;j++){//inner loop from 1st element till just one b4 the above element
            if(arr[j]==arr[i]){//checking if the element at ith index has come
// from 0th to i-1th index, if yes then no need to print it and so break
//from the inner loop and get the next ith element to get checked
                break;
            }
        }//inner loop closed
        if(j==i){//if ith element pass the if condition from 0 to i-1th element
 //then we need to print it since it has not appeared b4, so if the ith element
//has been checked from 0th to i-1th index then that means now value of j will
//have become equal to that of i since j=0;j++ means use j as 0 in this loop
//and as the loop ends the value j will become 1 so when we j reached i-1 in 
//last loop so after the end of the loop it will become equal to i
            System.out.println("unique element is "+arr[i]);
        }

    } 
}

 private static void uniqueArrayInPlace2(int[] arr) {
//printing the 1st element of the array bcz its 1st so till not its unique
    int c=0;      
System.out.println("unique element of arrayis "+arr[0]);
    for(int i=1;i<=arr.length-1;i++){//running outer loop from 2nd element to last element
        c=0;
        int j;
        for(j=0;j<i;j++){//inner loop from 1st element till just one b4 the above element
            if(arr[j]==arr[i]){//checking if the element at ith index has come
// from 0th to i-1th index, if yes then increasing the counter by 1
            c=c+1;
            }
        }//inner loop closed
        if(c==0){//even if the number has appeared even once before then the 
    //counter value will not be zero and if counter is zero then that means the
    //element has not appeared before
            System.out.println("unique element of array is "+arr[i]);
        }

    } 
}
}
