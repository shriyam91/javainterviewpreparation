import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashedInQuestion2 {
    
    public static void main(String[] args) {
        //Example 1:
// Input: nums = [100,4,200,1,3,2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
// Example 2:
// Input: nums = [0,3,7,2,5,8,4,6,0,1]
// Output: 9
//Input: nums = [0,3,7,2,5,8,77,6,0,1]
// Output: 9
// nput: arr[] = {1, 9, 3, 10, 4, 20, 2}
// Output: 4
// Explanation: The subsequence 1, 3, 4, 2 is the longest subsequence of consecutive elements

// Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
// Output: 5
        //
        //1:sort the given array ie {1, 9, 3, 10, 4, 20, 2}
        //2:after sorting the array will be like {1,2,3,4,9,10,20}
        //run a loop and is non consequitive then break out and return the length
        //int arr[]={1, 9, 3, 10, 4, 20, 2};
        int arr[]={ 41,46, 56,45, 35, 44, 33, 34, 92, 43, 32, 42};
        System.out.println(  findLen(arr));

    }
    public static int findLen(int arr[]){
         Arrays.sort(arr);
        //so now we have {1,2,3,4,9,10,20}
         //so now we have 
         int l=0;
        int r=0;
         int max=1; 

        while (r<arr.length-1) {
            if(arr[r+1]-arr[r]==1){
                if(((r+1)-l)+1>max){
                   max= ((r+1)-l)+1;
                }
                r++;
            }
            else{
                r++;
                l=r;
            }
        }
        return max;
}
}