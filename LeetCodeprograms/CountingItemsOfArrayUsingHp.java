import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingItemsOfArrayUsingHp {
    //input: [a,a,b,b,b,c,c,c,d]
    //output:[a,2,b,3,c,3,d]
    //input:[A,v,a,n,e,e,s,h]
    //output:[A,v,a,e,2,s,h]
    //input:[A,t,i,a,j,a,j,j,a,i,c,c]
    //output:[A,t,i,2,a,3,j,3,c,2]
    public static void main(String[] args) {
        
        Scanner scan= new Scanner(System.in);
        System.out.print("enter the size of array");
        int n= scan.nextInt();
        scan.nextLine();
        char[] arr= new char[n];
        for(int i=0;i< n;i++){
            System.out.println("enter the value for index"+ i);
            arr[i]=scan.next().charAt(0);
            
        }
        LinkedHashMap<Character,Integer> hp= new LinkedHashMap<Character,Integer>();
         List<Character> arr2= countFrequency(arr,hp);
         
         Character [] newarr= arr2.toArray(new Character[0]);
        System.out.print("the required array is "+ Arrays.toString(newarr));
        
    }

    private static List<Character> countFrequency(char[] arr, LinkedHashMap<Character,Integer> nhp) {
        int val,val2,c;
        List<Character> nl= new ArrayList<Character>();        
       for(char ch: arr){
        c=0;
        if( nhp.containsKey(ch)){
            val= nhp.get(ch);
            nhp.put(ch, val+1);
            
            
        }
        else{
            nhp.put(ch, 1);
        }
                      
    }
    //Map.Entry is used to traverse through the key-value pairs of the hashmap
   for( Map.Entry<Character,Integer> ent : nhp.entrySet()){
         nl.add(ent.getKey());
         if(ent.getValue()>=2){
            //typecasting int to char
            val2=ent.getValue();
            nl.add((char) (val2 +'0'));// to typecaste a int to char we simply
    //add the character '0' to it, and similarly to typecaste a char to int
    //we simply subtract '0' from it;
    char cc= 'k';
    System.out.println("just for testing the typecasting b/w int and char"+ (int)(cc-'0'));
         }
   }
    return nl;
}
}
