//since every number can be expressed in form of 2, find 
//the minimum terms of power of 2 to make it equal to a number N
//eg: 15: 2^4-2^0(not like the previous program where I would have done 2^3+2^2+2^1+2^0)
//eg: 9:2^3+2^0

    import java.util.Scanner;
    public class minimumpowerof2 {
   static int sum=0;
   static int count=0;
public static void main(String[] args) {
    Scanner scan= new Scanner(System.in);
    int N= scan.nextInt();
   
    find(N);
}
public static void find(int n){
    
    int pow= (int)(Math.log((double)n)/Math.log((double)2));
    double powd= Math.log((double)n)/Math.log((double)2);
     //sum= sum+pow;
     count=count+1;
     if(pow==powd){
       //System.out.println("Minimum number of powers of "+2+" required to obtain "+n+" are: "+sum);
       //sum is the sum of all the powers of k , in case they ask this also 
       System.out.println("Minimum number of power terms of "+2+" required: "+count);
    }//Note: value of log(1) is always 0 for any base
     else{
//now after considering the difference between the 'n-2^pow' and '2^(pow+1)-n',then accordingly we will call the find method with the required parameter 
        if((n-Math.pow(2,pow))<(Math.pow(2,pow+1)-n)){
        int Nnew= (int)( n- Math.pow(2, (double)pow));
        find(Nnew);
        
     }
     else{
        find((int)(Math.pow(2, pow+1)-n));
     }
    }
}
}

