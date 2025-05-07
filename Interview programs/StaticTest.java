import java.io.IOException;

public class StaticTest {

private int count=0;
//note: if we try to access a non static variable inside a static method directly
//then we will get the error" cannot refer a non static field from static reference"
//so the correct solution is to make the variable static or a 2nd way is
//to create instance of the class and then access the nonstatic variable using
//the instance of the class bcz non static variable belongs to the instance of
//the class and their value can be different for different instances whereas
//value of static variables is same throughout the class bcz they belong to the
//class  

public static void main(String args[]) throws IOException {
StaticTest test = new StaticTest(); //accessing static variable by creating an instance of
//below line will give error
//count=count+1;
//this will work bcz here we are using the non static variable using the 
//instance of the class
int var=test.count +1;
System.out.println("value is "+var);
}
}