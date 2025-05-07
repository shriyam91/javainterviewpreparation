import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        
        
        String keyarray[]= hashMap.keySet().toArray(new String[hashMap.size()]);
        //we can provide a pre-defined size, this is good but it can cause a problem
        // in multi threading when there is a race condition where two threads are
        // trying to update the size
        String valarray[]=hashMap.values().toArray(new String[0]);
        //here we have initialized an empty array which is correct after updation
        // in java6, it works well in concurrency also
        System.out.println(Arrays.toString(valarray));
        System.out.println(valarray.length);
       System.out.println(Arrays.toString(keyarray));
       System.out.println(keyarray.length);
      List<Map.Entry<String,String>> ll= new ArrayList<Map.Entry<String,String>>(hashMap.entrySet());
      HashSet<String> has= new HashSet<String>(hashMap.keySet());
      //Iterator<String> it= has.iterator();
        for( String name: has){
            System.out.println(name);
        }
       

		
      
        Object[] objectArray = hashMap.entrySet().toArray();
        // we cannot provide a predefined type of array while coverting 
        //entrySet() to array() like we do while converting keySet() or 
        //values() to array
        for (int i = 0; i < objectArray.length; i++) {
            System.out.println("object array obtained from entryset" + objectArray[i]);
        }
        System.out.println("lets see" +Arrays.toString(objectArray));
        String[] ar1= hashMap.keySet().toArray(new String[0]);
        String[] ar2= hashMap.values().toArray(new String[0]);
      String[] key= new String[0];
      String[] val= new String[0];
      int index=0; 
      for(Map.Entry<String,String> entry: hashMap.entrySet()){
        key[index]= entry.getKey();
        val[index]=entry.getValue();
        index=index+1;
       }
    }
}