import java.util.Collections.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frequencyincreament {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        int[] num= new int[N];
        for (int index = 0; index < num.length; index++) {
            num[index]=scan.nextInt();
        }
        System.out.println("enter the frequency required ");
        int M= scan.nextInt();
        int res= findFrequency(N,M,num);
        System.out.println("required frequency is "+ res);
    }
    public static int findFrequency(int n,int m,int[] num){
        int result=0;
       Map<Integer,Integer> hp= new HashMap<Integer,Integer>();
        for(int i=0;i< num.length;i++){
            if(hp.containsKey(num[i])){
                int val= hp.get(num[i]);
                hp.put(num[i],val+1);
            }
            else{
                hp.put(num[i],1);
            }
        }
        Integer[] val= hp.values().toArray(new Integer[0]);
        for( Integer i: val){
            if(i<m){
                result=result+(4-i);
            }
        }
        return result;
    }
}
