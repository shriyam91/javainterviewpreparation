import java.util.Scanner;
//return the length of the new array containing only the unique numbers
//ex:[1,1,3,3,4,5,6,6]
//length of the array with only unique elements ie[1,3,4,5,6] will be 5
//we have to do this task in-place ie without creating any new array
public class makingarrayunique {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextInt();
    }
    System.out.println("length of the new unique array is"+uniqueArraylength(num));
    
    
    }
    public static int uniqueArraylength(int[] num){
        int j=1;
       //  [1,1,3,3,4,5,6,6]
        for (int i = 1; i < num.length; i++) {
           if(num[i]!=num[i-1]){
            num[j++]=num[i];
           }
        }
        int[] arr= uniqueArray(num,j);
       System.out.println("elements of unique array are:");
        for(int n:arr){

            System.out.println(n);
        }
        System.out.println();
       
        return j;
    }
    // since the num array will now contain unique numbers till index j-1 and after that it would be containing the same numbers which it had initially(after index j-1)
    public static int[] uniqueArray(int[] num, int n){
        int[] unique=new int[n];
      
        for (int i = 0; i < n; i++) {
            unique[i]=num[i];
        }
        return unique;

    }
    
    }

