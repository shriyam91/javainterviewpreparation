import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.ValueExp;
 
class convertingmaptoarray
{
    // Program to convert map to an array in Java
    public static void main(String[] args)
    {
        Map<String, String> hashMap = new HashMap<>();
 
        hashMap.put("RED", "#FF0000");
        hashMap.put("BLUE", "#0000FF");
        hashMap.put("green", "taken0");
        hashMap.put("Khakhi", "police");
        System.out.println(hashMap.size());
        
        
        String keyarray[]= hashMap.keySet().toArray(new String[hashMap.size()]);//we can provide a 
        //pre-defined size, this is good but it can cause a problem in multi 
        //threading when there is a race condition where two threads are trying to 
        //update the size
        String valarray[]=hashMap.values().toArray(new String[0]);//here we have
        // initialized an empty array which is correct after updation in java6, it
        // works well in concurrency also
    
    //Method to convert/hashmap's keys and values in a list:
        List<String> nl= new ArrayList<String>(hashMap.keySet());//this is how you
    //convert/store hashmap's key values inside a list, note that arraylist takes
    //set as a parameter and copy all it's element to it and vice versa ie set
    //also takes list as a parameter and copy all it's element to it , so we need to just pas the keySet() as a parameter inside 
    // the arraylist
    List<String> nl2= new ArrayList<String>(hashMap.values());
    //Method to convert array to a list and array to a set:
    List<String> nl3= Arrays.asList(valarray);
    Set<String> ns= new HashSet<String>(Arrays.asList(valarray));//note that
    //set takes list and list takes set as a parameter and copy all it's element to it

        System.out.println(Arrays.toString(valarray));
        System.out.println(valarray.length);
       System.out.println(Arrays.toString(keyarray));
       System.out.println(keyarray.length);
    //   HashSet<String> has= new HashSet<String>(hashMap.keySet());
    //   //Iterator<String> it= has.iterator();
    //     for( String name: has){
    //         System.out.println(name);
    //     }
       

		
      
    //     Object[] objectArray = hashMap.entrySet().toArray();// we cannot provide a predefined type of array while coverting entrySet() to array() like we do while converting keySet() or values() to array
    //     for (int i = 0; i < objectArray.length; i++) {
    //         System.out.println(objectArray[i]);
    //     }
       // System.out.println(Arrays.toString(objectArray));
      String[] key= new String[hashMap.size()];
      String[] val= new String[hashMap.size()];
     //the above method of using hashmap.getKeys().toarray() or hashmap.values() is good
     // but it does'nt ensures that the the array of keys/values which you will get will be in the same order in which you entered which is sometimes required to solve some leetcode programs
     // so to get the keys / values in the same order in which we entered we should always use Entry.Map<generic,generic> variable: hashmap.entrySet()
      int index=0; 
      for(Map.Entry<String,String> entry: hashMap.entrySet()){
        
        key[index]= entry.getKey();
        val[index]=entry.getValue();
      
       System.out.println(key[index]+" and  "+val[index]);
       index=index+1;
       }
    }
}