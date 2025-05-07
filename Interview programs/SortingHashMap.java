import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class SortingHashMap {
    public static void main(String[] args) {
        Map<Character,Integer> hp= new HashMap<>();
        hp.put('a', 5);
        hp.put('b', 7);
        hp.put('c', 3);
        hp.put('h', 2);
        hp.put('r', 44);
       
//shorter way to sort a hashmap is using stream() on entrySet() of hashmap
  hp.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(ent-> System.out.println("key is "+ ent.getKey()+" and value is "+ent.getValue()));
 //and if key or value stored in map is a oject(made of many fields),let's say
 //we have to sort acc. to key' salary field where key is an Employee object
 // made of many fields, so we will do:
// hp.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employees:: getSalary)));
  //Longer Method to sort a map:
     
//step1: store the key value pair of map in a list
//step2: sort the list using a collection.sort and pass the list and the comparator<Map.Entry<T,T> as the parameter
// and define the int compare( obj o1,obj2 ) method
//step3:now when the list is sorted then again store the data from the list to a new hashmap
 
  List<Map.Entry<Character,Integer>> hplist= new ArrayList<Map.Entry<Character,Integer>>(hp.entrySet());
    Collections.sort(hplist, new Comparator<Map.Entry<Character,Integer>>() {

        @Override
        public int compare(Map.Entry<Character,Integer> o1, Map.Entry<Character, Integer> o2) {
            // TODO Auto-generated method stub
           return (o1.getValue()-o2.getValue());
        }
        
    });
    //we can directly print keys and values directly from the list:
    for(Map.Entry<Character,Integer> ent: hplist){
        System.out.println("printing directly from the list: key is "+ent.getKey()+" value is "+ent.getValue());
    }
    //and if we want to store the sorted key- value pairs back to the map in
    //the sorted order
 
    //step3, while loading the sorted  data back from the list to a new hashmap 
//remember to use ONLY  a LinkedHashMap bcz the major difference b/w a hashmap
//and a linked hashmap is that linkedhashmap supports the ordering and tracing
//of the elements and a hashmap does not do so, So to whenever we have to sort an
//hashmap or put a sorted data from list/set to a hashmap then we have to only 
//use linkedhashmap 
    HashMap<Character,Integer> nhp= new LinkedHashMap<Character,Integer>();
        for(Map.Entry<Character,Integer> ent: hplist){
            nhp.put(ent.getKey(), ent.getValue());
        }
         
    
    
    System.out.println("map sorted according to values:");
    for(Map.Entry<Character,Integer>entry:nhp.entrySet()){
        System.out.println("key is "+ entry.getKey() +" and its corresponding value is "+ entry.getValue());
    }
    
    }
}
