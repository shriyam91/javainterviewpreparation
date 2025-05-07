import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StringtoInteger {
   static ArrayList<Integer> val2=new ArrayList<>();
    public static void main(String args[]){
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();
       // int count=0;
        scan.nextLine();
        String val[]=new String[n];
        

        for (int i = 0; i < val.length; i++) {
            System.out.println("enter the value");
            val[i]=scan.nextLine();
        }
         Integer[] arr= parseVal(val);
         for( Integer i:arr){
            
            System.out.println("even numbers are"+i);
        } 
    }
    
    public static Integer[] parseVal(String[] val){
       // int count=0;
        for( String str:val){
           try{

            if(Integer.parseInt(str)%2==0){
            val2.add(Integer.parseInt(str));
           
                 }}
                 catch(Exception e){
                    //val2.add(null);there is no need to add a null value in response to if unexpectedNumberFormat exception occurs, we can simply handle this expection by getting the exception message 
                    System.out.println(e.getMessage());
                    
                }
        }
        System.out.println(val2.size());
    // List<Integer> list=   val2.stream().filter(value-> value%2==0&&value!=0).collect(Collectors.toList());
        //System.out.println(list.size());//list will ensure to not have any null values
           // return list.toArray(new Integer[list.size()]);
        return val2.toArray(new Integer[val2.size()]);
         
        
        } 
        

        }  
    
    

