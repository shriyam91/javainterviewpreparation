import java.util.Arrays;
import java.util.Scanner;
// this program did not work as expected, right solution is in the program named
//'CountingItemsOfArray'
public class countingitemsinplace {
    public static void main(String[] args) {
       Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        scan.nextLine();

        String[] num= new String[N];
        for (int i = 0; i < num.length; i++) {
            num[i]=scan.nextLine();
    }
     String[] newnum= find(num );
     System.out.println(Arrays.toString(newnum));
}
public static String[] find( String[] num){
 
    int index=0;
   int i=0;
    while(i< num.length){
       int j=i;
        while(j<num.length && num[i]==num[j]){
            j++;
        }
        
        num[index++]=num[i];
        //index+=1;
        num[index++]=String.valueOf(j-i);
        
        i=j;
    }
    return num;

}

}
