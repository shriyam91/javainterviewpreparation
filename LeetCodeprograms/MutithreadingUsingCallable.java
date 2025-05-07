import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MutithreadingUsingCallable {

    
    static double target= 0.5;//declaring target variable as static simply
    //bcz we can use it inside the difference method without the need to pass
    //it as a parameter in that method
      static double precision= 0.00000001;
       static double result=0;
    public static void main(String[] args) {
      
      
    //note that variables declared inside the lambda expressions cannot be local
    //, they have to be class variables
//now we will do the same presision number generating program using callable and futuretask
          //  Runnable runnable = ()-> result= generateNumber(precision);
    Callable<Double> callable= ()-> generateNumber();//since call() method
//of the callable interface in not of void type,call() has return type of Future
// and it can take the return 
//value, so we do not need to give a static variable here to seperately to 
//store the result bcz callable variable itself can store the returned value,
//we just need to give the generic type same as that of the returned value

 FutureTask<Double> futureTask= new FutureTask<>(callable);
 //inspite of assigning the callable object insdie the thread we assigned
 //the futureTask object bcz thread only takes an object of runnable type
 //and since futureTask interface implements runnable interface so futuretask
 //is also of Runnable type by the virtue of polymorphism

 Thread thread= new Thread(futureTask);
    

       
        thread.start();
         try{
            result=futureTask.get();//this is another benifit of using
//futuretask interface, get() of futuretask does the both works: work of join()
// of thread class and also retrieves value returned by the call() method(and 
//stored in the callable object)
            //this will ensure that the main thread does not starts
            //untill the 2nd thread(bcz the 1st thread is
            //always the main thread) is finished  
         } 
         //note that futuretask throws 2 exception ie interruptedexception
//and executionexception so either we catch both of these seperately or
//or we can use only one catch which will catch the main class of these 2 
//exception it catch( Exception exe)     
         catch(ExecutionException exe){
            System.out.println(exe.getMessage());
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // catch(Exception exe){
        //     System.out.println(exe.getMessage());
        //  }
        precision= difference(result);
         System.out.println("system returned the value of "+ result);
         System.out.println("value was generated to a precision of  "+ precision);
    }

    public static double generateNumber(){
       double number= Math.random();//it generates a number b/w 0 and 1
       double differ = difference(number);
       //so only when math.random() will generate a number bigger or equal to
       //4.9999999 then only we can return the number
       while(differ> precision){
        number = Math.random();
         differ= difference(number);
       }
       return number;
    }
    public static double difference(double number){
        return Math.abs(target- number);// 
    }
    
}
