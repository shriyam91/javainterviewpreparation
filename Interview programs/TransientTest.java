import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * Java program to demonstrate What is transient variable in Java and fact that the value of
 * transient variable is not serialized and during serialization it initialized with
 * default value of that data type. e.g. If a transient variable is Object than after
 * deserialization its value would be null.
 *
 * @author Javin
 */
public class TransientTest {

 
    public static void main(String args[]) {
 
       Book narnia = new Book(1024, "Narnia", "unknown", 2);
       System.out.println("Before Serialization: " + narnia);
     
        try {
            FileOutputStream fos = new FileOutputStream("narnia.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(narnia);

            System.out.println("Book is successfully Serialized ");

            FileInputStream fis = new FileInputStream("narnia.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Book oldNarnia = (Book) ois.readObject();
         
            System.out.println("Book successfully created from Serialized data");
            System.out.println("Book after seriazliation : " + oldNarnia);
         
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 
 
}
    

