import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Java program example to demonstrate How to convert InputStream into String by using JDK
 * Scanner utility. This program will work Java 5 onwards as Scanner was added in Java 5.
 */        
    
 
 
public class InputStreamtoString {

    public static void main(String args[]) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("C:/MyJavaLearning/Interview programs/movies.txt");
        String inputStreamString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();
        System.out.println(inputStreamString);
    }//Scanner method takes the text file and the encoding pattern as the parameter 
    //note that it is necessary to provide the encoding pattern and since we are reading english data so we will always provide UTF-8
    //it is necessary to use the usedelimiter("\\A") method with "\\A" parameter bcz this is a predefined in Scanner class that it will usedelimiter("\\A") method will be used to extract complete data as a single string, here "\\A" parameter tells the scanner to read till the last word of the last line
    //next() is used to return the data as String, and we don't use nextLine() bcz that will return only the first line of the complete data

}

