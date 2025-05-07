import java.util.Map;
import java.util.Scanner;


import java.util.*;

class countingusingmap{
    public static void main(String args[]){

       //   countingusingmapWrapper
        Scanner scan= new Scanner(System.in);
        HashMap<Character,Integer> count= new HashMap<Character,Integer>();
        String str= scan.nextLine();
        for( int i=0;i<str.length();i++){
            if(count.containsKey(str.charAt(i))){
                Integer val= count.get(str.charAt(i));
                count.put(str.charAt(i), val+1);
            }
            else{
                count.put(str.charAt(i), 1);
            }
        }
            

        
        for(Character ch: count.keySet()){
            System.out.println(ch+" "+count.get(ch));
        }
        for(Map.Entry<Character,Integer>entry :count.entrySet()){
          System.out.println(  entry.getKey()+" "+entry.getValue());
        }
        
        

    }}
