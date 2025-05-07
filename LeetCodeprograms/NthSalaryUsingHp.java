import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;
class NthSalaryUsingHp{
    public static void main(String[] args){
        HashMap<String,Integer> hp= new HashMap<>();
        hp.put("anil",1000);
        hp.put("arvind",1300);
        hp.put("arav",1200);
        hp.put("bibek",1600);
        hp.put("akash",1400);
        hp.put("adil", 1700);
        hp.put("chetan",2100);

        HashMap<String,Integer> nhp= new HashMap<>();
        nhp.put("anil",1000);
        nhp.put("arvind",1300);
        nhp.put("arav",1300);
        nhp.put("bibek",1000);
        nhp.put("akash",1400);
        nhp.put("adil", 1400);
        nhp.put("chetan",1300);

        
        System.out.println("enter the value for N");
        int N= new Scanner(System.in).nextInt();
        System.out.println("Nth highest salary is "+ highestSalary(hp,N));

        
    //get the salary of all they emp with salary 1300 using stream
   List<Map.Entry<String,Integer>> ll= salaryGroup(nhp);
   for(Map.Entry<String,Integer> ent: ll){
     System.out.println(ent.getKey()+"..."+ent.getValue());
   }
        

    }
    public static Map.Entry highestSalary(HashMap<String,Integer> hp, int n){

    Map.Entry<String,Integer> entry= hp.entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder())).collect(Collectors.toList()).get(n-1);
        return entry;
    }

    public static List<Map.Entry<String,Integer>> salaryGroup(HashMap<String,Integer> nhp){
      nhp.entrySet().stream().filter(ent-> ent.getValue()==1300).forEach(ent-> System.out.println("salarygroup: "+ent.getKey()+" and"+ent.getValue()));
       
      List<Map.Entry<String,Integer>> ll=  nhp.entrySet().stream().filter(ent-> ent.getValue()==1300).collect(Collectors.toList()); 
        return ll;
    }

}