import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortingHashMap {
    public static void main(String[] args) {
        Map<Character,Integer> hp= new HashMap<>();
        hp.put('a', 5);
        hp.put('b', 7);
        hp.put('c', 3);
        hp.put('h', 2);
        hp.put('r', 44);
       Set<Integer> ss= hp.values().stream().sorted((a,b)-> -(a-b)).collect(Collectors.toSet());
    for(Integer i: ss){
        System.out.println(i);
    }
    }
}
