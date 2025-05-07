import java.util.Scanner;
public class tribonacci{
public static void main(String[] args){

	System.out.println("enter the number till which you want the series");
	int N= new Scanner(System.in).nextInt();
	
	if(N==1){
	System.out.println("nth number is 0");
	}

	
	if(N==2){
	System.out.println("nth number is 1");
	}
	
	
	if(N==3){
	System.out.println("nth number is 1");
	}
	
	printingTribonacci(N);
	}
	public static void printTribonacci(int N){
	int a=0,b=1,c=1;
	int temp,sum;
	System.out.print("Tribonacci series is"+a+" "+b+" "+c+" ");
	for(int i=1;i<=N-3;i++){
	  
	    sum=a+b+c;
	    temp=a;
	    a=b;
	    b=c;
	    c=sum;
         System.out.print(sum+" ");
	    
	}
}
}	