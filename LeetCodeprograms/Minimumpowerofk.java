// we have to find minimum number of terms of power of k to make it equal to N
//eg : 15:3^2+3^1+3^1: so 3 power terms required 
//eg:5:3^1+3^0+3^0:so 3 power terms required
//eg 35:2^5+2^1+2^0:so 3 power terms required
//eg:729:27^2: so 1 power term required
import java.util.Scanner;

public class Minimumpowerofk {
   static int sum=0;
   static int count=0;
public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    int N= scan.nextInt();
    int K= scan.nextInt();
    find(N,K);
}
public static void find(int n, int k){
    
    int pow= (int)(Math.log((double)n)/Math.log((double)k));
    double powd= Math.log((double)n)/Math.log((double)k);
     sum= sum+pow;
     count=count+1;
     if(pow==powd){
       System.out.println("Minimum number of powers of "+k+" required to obtain "+n+" are: "+sum);
       //sum is the sum of all the powers of k , in case they ask this also 
       System.out.println("Minimum number of power terms of "+k+" required: "+count);
    }
     else{
        int Nnew= (int)( n- Math.pow(k, (double)pow));
        find(Nnew, k);
     }
} 
}
