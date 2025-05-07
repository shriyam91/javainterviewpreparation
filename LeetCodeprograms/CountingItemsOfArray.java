import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CountingItemsOfArray {
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
            System.out.println("enter the value for index i");
            arr[i]=scan.next().charAt(0);
            
        }
        List<Character> nlist= new ArrayList<>();
         List<Character> arr2= countFrequency(arr,nlist);
         Character[] newarr= new Character[arr2.size()];
         newarr= arr2.toArray(newarr);
        System.out.print("the required array is "+ Arrays.toString(newarr));
        
    }

    private static List<Character> countFrequency(char[] arr, List<Character> nlist) {
    //   // 
    //   HashMap<Character,Integer> map= new HashMap<>();
    //      for(int i=0;i<arr.length; i++){
    //     if(map.containsKey(arr[i])){
    //         Integer ii= map.get(arr[i]);
    //         map.put(arr[i], ii+1);
    //     }
    //     else{
    //         map.put(arr[i], 1);
    //     }
    //   }
    //   char[] arr2= new char[map.keySet().size() + map.values().size()];
     
    //   for( Map.Entry<Character, Integer> entry: map.entrySet() ){
         
    //   }
      //
      
      
        int c;
       for(int i=0;i< arr.length;i++){
        c=0 ;
        if( nlist.contains(arr[i])){
            continue;
        }
        else{
            for(int j=i;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    c=c+1;
                }
            }
            
                nlist.add(arr[i]);
                if(c>=2){
                    char nval= (char)(c+'0');//we convert int to char by adding
        // the ASCII value of the character  0 to it and not the integer 0 itself.
                    nlist.add(nval);//this is a better way to convert char to int
    //simi larly to convert int to char we just need to subtract the ASCII value
    //of 'character 0' and not the value 0 itself
    //ex: char val=a; int nval= a-'0'; 
                    //nlist.add(Integer.toString(c).charAt(0));//this is another way
        //of converting char to int but the above one is better as it work both ways
        //and it will work for integer of any digits and not just a single digit
    //and to convert string to integer we can simply use Integer.parseInt(stringvalue)
    //and to convert int to string we can simply use String.valueOf(integervalue)         
    }            
        }//else closed
       }  
        return nlist;
    }
}
