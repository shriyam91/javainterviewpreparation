public class MultithreadingJoin {

    static  double result;
    static double target= 0.5;//declaring target variable as static simply
    //bcz we can use it inside the difference method without the need to pass
    //it as a parameter in that method
     static double precision= 0.00000001;
    public static void main(String[] args) {
        
       
    //note that variables declared inside the lambda expressions cannot be local
    //, they have to be class variables
        Runnable runnable = ()-> result= generateNumber();
      // Runnable run= ()->{
      //    for(int i=0;i<2;i++){
      //       System.out.println(Thread.currentThread().getName());
      //    }
      // };
        Thread thread = new Thread(runnable);
        thread.start();
         try{
            thread.join();
            //this will ensure that the main thread does not starts
            //untill the 2nd thread(bcz the 1st thread is
            //always the main thread) is finished  
         }        
         catch(InterruptedException exe){
            System.out.println(exe.getMessage());
         }
         precision= difference(result);
         System.out.println("system returned the value of "+ result);
         System.out.println("value was generated to a precision of "+ precision);
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
