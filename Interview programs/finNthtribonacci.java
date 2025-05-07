import java.util.Scanner;
public class finNthtribonacci {
    static Scanner scan= new Scanner(System.in);
    static int n= scan.nextInt();
    static int sum=0;
    
    public static void main(String[] args) {
       
        if(n==1){
            System.out.println("nth number is 0");
        }
        else if(n==2){
            System.out.println("nth number is 1");
        }
        else if (n==3){
            System.out.println("nth number is 2");
        }
        else{
            int num=nthNum(n);
            System.out.println("nth tribonacci number is "+num);

        }
    }
    public static int nthNum(int n){
        int a=0;int b=1; int c=2;
        for(int i=1;i<=n-3;i++){
             sum= a+b+c;
            a=b;
            b=c;
            c=sum;
        }
       
        return sum;
    }
}

