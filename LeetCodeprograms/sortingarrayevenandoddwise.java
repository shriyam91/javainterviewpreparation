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
//sort the array such that 1st even numbers should come in ascending order
//then  all odd numbers should come in ascending order
public class sortingarrayevenandoddwise {
//Note: in this prgrm we have frst stored the even numbers in the same array
//and then odd numbers in the same array and then we have used the 
//Arrays.sort(array[],starting index(inclusive),ending index(excluded)) method
//2 times, first to sort the even numbers and then to sort the odd numbers 
    public static void main(String args[]){

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
            nll.remove();//removes from the underlying collection the 
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
        

       int i=0;
       
        while (itr.hasNext()) {
            Integer v= itr.next();
            
            if(v%2 == 0){
        
                //adding the even numbers to the same array
             arry[i]= v;
             i=i+1;  
                itr.remove();
                }
               
         
            //and after adding them to the original arrays then
                //we are deleting them from the arraylist, since interator itr
    //is applied on the arraylist so it will remove the elements of the arraylist
    //only
            }
             int indexTillEven= i;//so from index 0 to index i-1 are
                //even numbers
                
        // now when the while ends we are left with the arraylist containing
        //only odd numbers
      for(Integer in: al){
        arry[i]=in;//now adding the leftover odd integers to the same array
        //ie arry
        i=i+1;
      }
    //Note:Arrays.sort(array[], starting index, ending index) 
    // public static void sort(int[] arr, int from_Index, int to_Index) ;
//  PARAMETERS:
//   It takes three parameters as can be perceived from the syntax which is as
// follows:

// The array to be sorted
// The index of the first element, inclusive, to be sorted (Referred to as from_index)
// The index of the last element, exclusive, to be sorted (Referred to as last_index)
//FIRST sorting the even numbers:     
Arrays.sort(arry, 0, indexTillEven);
//Now sorting the left over odd numbers 
Arrays.sort(arry, indexTillEven, arry.length);
        return arry;
    }
    
}
