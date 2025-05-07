import java.util.Scanner;

class reverseinteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num= scan.nextInt();
        String str= Integer.toString(num);
        
        String rev= find(str.toCharArray());
        System.out.println("reverse of the number by converting number into a string and then further into array of characters is "+rev);
        System.out.println("reverse of the number using the conventional method is "+num+ " is " +reverseConventional(num));
    }
    public static String find(char[] num){
        int n=num.length;
        String st="";
        for(int i=0;i<n/2;i++){
            char temp= num[i];
            num[i]=num[n-i-1];
            num[n-i-1]=temp;
        }
        for(char ch: num) {
             st=st+ch;
        }
        return st;
    }
    public static int reverseConventional(int num){
        int n,sum=0;
        while(num!=0){
            n= num%10;
            
            sum=sum*10 +n;
            num=num/10;    
        }
        return sum;
    }
}
