//wap to check whether N is power of K
import java.util.Scanner;

class NpowerofK{
    public static void main(String[] args) {
        int a=3;
        double b=3.0;
        System.out.println(a==b);
        System.out.println(3.442==3);
        
      Scanner scan= new Scanner(System.in);
      System.out.println("enter value of N");
      int N= scan.nextInt();
      System.out.println("enter value of K");
      int K= scan.nextInt();
      System.out.println(N+" being a power of"+ K+" is a "+ find(N,K)+" statement");
    }
    public static boolean find(int n, int k){
        
       
      double res= (Math.log((double)n)/Math.log((double)k));//since log takes only double as the parameter
      int res2= (int)(Math.log((double)n)/Math.log((double)k)); 
       return res==res2;
    //   int ab= (int)res;
    //    if(res/(double)ab==1.0){
    //     return true;
    //    }
    //    else{
    //     return false;
    //    }
        
    // }

}
}