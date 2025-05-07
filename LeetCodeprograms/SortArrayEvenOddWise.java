import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArrayEvenOddWise {
//sort the array such that 1st even numbers should come in ascending order
//then  all odd numbers should come in ascending order
    public static void main(String args[]){
    // here we are  storting even numbers in one arraylist and then odd numbers
    //in another arraylist and then sorting both lists using sort () and
    //then concatinating both lists and then storing back the list to the same 
    //array 

        // 
//First learning how to iterate and remove elements of a list:
//: since list is immutable, so first thing is that if we have to modify
//elements of a list then first save the list as Arraylist bcz arraylist is
// is mutable form of list
//2nd thing to learn : whenever we have to modify elements of a arraylist 
// whether while iterating or even when not iterating, then always use Iterator
//class of the same type as that of arraylist otherwise modifying operation
//will give "UnsupportedOperationException"
//:Remember that Iterator class will modify the original arraylist on which
//the iterator() has been used 
//3rd thing to learn: After modifying a arraylist using Iterator then to 
//print the modified arraylist we cannot use itertor class bcz using iterator
//class we cannot print the elements of the arraylist so we have to use the for
//loop on the arraylist
         List<Integer> nl = Arrays.asList(1,2,6,3,3,9,12);
        
        ArrayList<Integer> l= new ArrayList<>(nl);//Saving the list to an
//arraylist bcz list is immutable and to modify a list we have to save it into
//an arraylist first
         Iterator<Integer> nll = l.iterator();
// nl.remove(1);//this will give "UnexpectedOperationException" bcz list is 
//immutable and so removing an element of it will throw exception
//Note that even after saving the list to an arraylist we cannot use remove()
//arraylist directly bcz it will not work as we will expect, so to remove 
//elements of an arraylist always use Iterator class on the arraylist we want
//to modify
    while( nll.hasNext()){
        int val= nll.next();
        if(val%2==0){
            nll.remove();//Note: remove() does not takes any parameter and
            //removes from the underlying collection the 
//last element returned by this iterator (optional operation). This method can 
//be called only once per call to next.
        }
    }

//     while( nll.hasNext()){
//         int valv= nll.next();
        
   
//     System.out.println("printing using iterator" +valv);
//    }
for( Integer valv: l){
    System.out.println("testing phase" +valv);
}

    System.out.println("enter the size of array");
     int n= new Scanner(System.in).nextInt();
         Integer[] arr2=  new Integer[n];//creating array of Integer type and
//not of int type bcz we have to save the copy of this array in an arraylist
        for(int i=0;i<n;i++){
            System.out.println("enter the value for index "+i );
            arr2[i]=new Scanner(System.in).nextInt();
        }        
//  for(Integer i : arr2){
        //      System.out.println("enter the value of i");
        //     i= new Scanner(System.in).nextInt();
        //  }// Note:All the null pointer exception were coming bcz of this way
//of taking input for the array, this way does not work to take inputs for array
//simply bcz here i represents the value inside the array which does not exists
//b4 taking input for that index number, so old way (done above this wrong method) is the correct
//way of taking input
     
         List<Integer> ll = Arrays.asList(arr2);

         ArrayList<Integer> al= new ArrayList<>(ll);//saving the list to a mutable 
         //form ie Arraylist 
      
         arr2= sortEvenOdd(al,arr2);
        System.out.println("the sorted form of array as per even odd basis ");
         System.out.println(Arrays.toString(arr2));
    }
    public static Integer[] sortEvenOdd(ArrayList<Integer> al, Integer[] arry){
        Iterator<Integer> itr= al.iterator();
        ArrayList<Integer> tal= new ArrayList<Integer> ();

       int i=0;
       
        while (itr.hasNext()) {
            Integer v= itr.next();
            
            if(v%2 == 0){
        
                tal.add(v);//adding the even numbers to a new arraylist
             
             i=i+1;  
                itr.remove();
                }
               
         
            //and after adding them to the new arraylist then
                //we are deleting them from the old arraylist, since interator itr
    //is applied on the arraylist so it will remove the elements of the arraylist
    //only
            }
             int indexTillEven= i;//so from index 0 to index i-1 are
                //even numbers
                //if closed
       //now sorting the arraylist "tal":
       tal.sort(new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o1- o2;
        }
        
       }); 
       //now sorting the arraylist "al " which is left only with odd numbers
       Collections.sort(al, new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
            // TODO Auto-generated method stub
            return o1- o2;
        }
        
       }  );
    //NOW concat the two sorted list , hence we will get a list containing
    //first evven nos in asc. order and then odd nos in asc order.
       List<Integer> newList = Stream.concat(tal.stream(), al.stream())
                             .collect(Collectors.toList());
            for( Integer it: newList){
                System.out.println("just checking "+it);
            }
          //while closed//
        // now when the while ends we are left with the arraylist containing
        //only odd numbers
        arry= newList.toArray(new Integer[0]);
        return arry;
    }
    
}
