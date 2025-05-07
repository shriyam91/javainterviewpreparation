// Here is our sample program to show why relying on default character encoding is a bad idea and why you must use character encoding while converting byte array to String in Java. 
//In this program, we are using Apache Commons IOUtils class to directly read files into a byte array.
// It takes care of the opening/closing input stream, so you don't need to worry about leaking file descriptors.
// Now how you create String using that array, is the key. If you provide the right character encoding, you will get the correct output otherwise a nearly correct but incorrect output.
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

/**
 * Java Program to convert byte array to String. 
 * In this example, we have first
 * read an XML file with character encoding "UTF-8" into byte array 
 * and then created
 * String from that. When you don't specify a character encoding, Java uses
 * platform's default encoding, which may not be the same if file is 
 * a XML document coming from another system, emails, 
 * or plain text files fetched from an * HTTP server etc. 
 * You must first discover correct character encoding
 * and then use them while converting byte array to String.
 *
 * @author Javin Paul
 */
public class ByteArraytoString{

        public static void main(String args[]) throws IOException  {

           System.out.println("Platform Encoding : " 
                        + System.getProperty("file.encoding"));
               
           FileInputStream fis = new FileInputStream("C:/MyJavaLearning/Interview programs/movies.txt");
          
           // Using Apache Commons IOUtils to read file into byte array
           byte[] filedata = IOUtils.toByteArray(fis);
               
           String str = new String(filedata, "UTF-8");
           System.out.println(str);
                               
        }
}


