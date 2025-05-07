import java.util.Scanner;

class finNthfibonacci{
     static Scanner scan= new Scanner(System.in);
    static int n= scan.nextInt();
    static int sum=0;
    
    public static void main(String[] args) {
       
        if(n==0){
            System.out.println("nth number is 0");
        }
        else if(n==1){
            System.out.println("nth number is 1");
        }
        else{
            int num=nthNum(n);
            System.out.print("nth number is "+num);

        }
    }
    public static int nthNum(int n){
        int a=0;int b=1;
        for(int i=1;i<=n-2;i++){
             sum= a+b;
            a=b;
            b=sum;
        }
       
        return sum;
    }
}