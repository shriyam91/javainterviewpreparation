import java.util.Arrays;
import java.util.Scanner;

class sortarray {
    public static void main(String[] args) {
   int[] ar=   new int[]{3,7,66,8,46};
   
int temp=0;
for(int i=0;i<ar.length-1;i++){
if(ar[i]>ar[i+1])
{
temp=ar[i];
ar[i]=ar[i+1];
ar[i+1]=temp;
}
}
for(int i:ar){
    System.out.println(i);
}
Scanner scan= new Scanner(System.in);
System.out.print("enter the number of rows");
int n=scan.nextInt();
String rowstring="";
for(int i=1;i<=n;++i){
rowstring=rowstring+"*";
System.out.println(rowstring);
}

System.out.print(Arrays.toString(ar));

        
    }
}
