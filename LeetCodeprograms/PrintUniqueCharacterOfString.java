import java.util.Scanner;

public class PrintUniqueCharacterOfString {
    public static void main(String[] args){
        String str="this is the welcome string";
        String[] arr= str.split("\\s+");//this regex is important to split the string
        for(String st: arr){
            System.out.println(st);
            
        }
        String inSt= new Scanner(System.in).next();
            for(int i=0;i< inSt.length()-1;i++){
                if(inSt.indexOf(inSt.charAt(i))== inSt.lastIndexOf(inSt.charAt(i))){
                System.out.println(inSt.charAt(i));
                }
                else{
                    continue;
                }

            }
    }
    
}
