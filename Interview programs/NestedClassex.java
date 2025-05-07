// * Java program to demonstrate What is nested static and non-static class.
//  * How to create instances of the static and non-static classes and How to call
//  * methods of nested static and Inner class in Java. Overall comparison of
//  * static vs. non-static class.
//  */

class NestedClassex{
    private static String message = "HelloWorld";
 
    // Static nested class
    private static class MessagePrinter{
        //Only static member of Outer class is directly accessible in a nested static class

        public void printMessage(){
            // Compile time error if message field is not static
            System.out.println("Message from nested static class : " + message);
        }
    }
 
    //non-static nested class - also called Inner class
    private class Inner{
     
        // Both static and non-static member of Outer class is accessible in this Inner class
        public void display(){
            System.out.println(" Message from non static nested or Inner class : " + message);
        }
    }
 
 
    // How to create instances of static and non-static nested class
    public static void main(String... args){
     
        // creating instance of nested Static class
        NestedClassex.MessagePrinter printer = new NestedClassex.MessagePrinter();
     
        //calling non static method of nested static class
        printer.printMessage();
     
        // creating instance of a non static nested class or Inner class
     
        // In order to create an instance of Inner class, you need an Outer class instance
     
        NestedClassex outer = new NestedClassex(); //outer class instance for creating non static nested class
     
        NestedClassex.Inner inner  = outer.new Inner();
     
        //calling non static method of Inner class
        inner.display();
     
        // we can also combine the above steps in one step to create an instance of Inner class
        NestedClassex.Inner nonStaticIner = new NestedClassex().new Inner();
     
        // similarly you can now call Inner class method
        nonStaticIner.display();
    }
 
}

// public class NestedInnerClass {
    
}



