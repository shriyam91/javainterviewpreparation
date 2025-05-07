import java.util.concurrent.locks.ReentrantLock;

public class Threadex{

    public static void main(String args[]){
       
        //two threads in Java which runs in Parallel
        
        Runnable runnable= new Runnable(){
            @override
            public void run(){
                for( int i=0;i<2;i++){
                    System.out.println("This is thread : " + Thread.currentThread().getName()));
                }
            }
        };
        Thread threadA = new Thread(runnable);
       
        //Runnable interface is implemented using Anonymous Class
        Thread threadB = new Thread(new Runnable(){
            @override
            public void run(){
                
                for(int i =0; i<3; i++){
                    System.out.println("This is thread : " + Thread.currentThread().getName());
                
                }
            }
        });
       
        //starting both Thread in Java
        threadA.start(); //start will call run method in new thread
        threadB.start();

        try{
            threadA.join();
            threadB.join();
        }
       catch(InterruptedException e){
        System.out.println(e.getMessage());
       }

    System.out.println("now this will be run by the main thread");
    System.out.println("this one also run by the main thread");

}  

}
