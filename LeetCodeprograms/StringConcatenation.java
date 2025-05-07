import java.util.Scanner;

public class StringConcatenation {
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        int N= scan.nextInt();
        String[] str= new String[N];
        for(int i=0;i<str.length;i++){
            str[i]= scan.nextLine();
            scan.next();
        }      
       String st= sum(str);
       System.out.println(st);
    }

    private static String sum(String[] str) {
        StringBuilder sb= new StringBuilder();
        for(String s: str){
            s.trim();
            sb.append(s);
        }
        String st= sb.toString();
        return st;
    }
}
