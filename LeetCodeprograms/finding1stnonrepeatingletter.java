import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;
//ex: aabccdeb
public class finding1stnonrepeatingletter {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        String str= scan.nextLine();
       
      char ch2= findIndexUsingInbuiltMethod(str);
     char ch3= findindexusinghashMap(str);
    
       
        System.out.println("first non repeating character is "+ch2);

      //  System.out.println("index of 1st non repeating character is "+findindex(str));
   // System.out.println("first non repeating character using Linkedhashmap is "+ch3);
 System.out.println("index of 1st non repeating character is"+
 "using Linkedhashmap is "+ch3);
}
   
  
        public static char  findIndexUsingInbuiltMethod(String st){
                for(char ch :st.toCharArray()){
                    if ( st.indexOf(ch) == st.lastIndexOf(ch)) {
                        
                        return ch;
                    }
                    
                    }
                    return 404;
            }
           

            
               
            public static char findindexusinghashMap(String st){
                int position;
                Map<Character,Integer> hp= new LinkedHashMap<>();//using linked hashmap bcz in simple hashmap order is not maintained but in linkedhashmap order is maintained
                for( char ch: st.toCharArray()){
                    if(hp.containsKey(ch)){
                        int val= hp.get(ch);
                        hp.put(ch, val+1);
                    }
                    else{
                        
                        hp.put(ch, 1);
                    }
                }
                Integer[] val= new Integer[hp.size()];
                // for(Map.Entry<Character,Integer> entry: hp.entrySet()){
                //     if(entry.getValue()==1){
                        
                //         return entry.getKey();
                        
                //     }
                // }
                for( Character chch: hp.keySet()){
                    if( hp.get(chch)==1){
                        return chch;
                    }
                }
                return 404;
            }


            }
        
    


