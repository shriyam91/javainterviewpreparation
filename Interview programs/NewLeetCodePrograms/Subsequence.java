import java.util.ArrayList;
import java.util.Arrays;

public class Subsequence {

    public static void main(String[] args){

        String p="";
        String str="abc";
        //all subsequences are: a,ab,ac,abc,b,bc,c:total 7
       // subSeq(p,str);
       ArrayList<String> list= subSeq2(p,str);
       System.out.println("arraylist is "+list.toString());
       System.out.println("arraylist to array to string is "+Arrays.toString(list.toArray(new String[0])));
    }
    // public static void subSeq(String p, String str){
    //     if(str.isEmpty()){
    //         System.out.println(p);
    //         return;
    //     }
    //     char ch= str.charAt(0);
    //     subSeq(p+ch,str.substring(1));//1st recursion call to take the 
    // //1st character and call the recursion with the substring with 1st character
    // //removed
    //     subSeq(p,str.substring(1));//2nd recursion call is to ignore
    //     //the 1st character and call the recursion with the substring with 1st character
    //     //removed
    // }

    public static ArrayList<String> subSeq2(String p, String str){
        ArrayList<String> lst= new ArrayList<>();
        if(str.isEmpty()){
         
           lst.add(p);
            return lst;
        }
        char ch= str.charAt(0);
        ArrayList<String> l1= subSeq2(p+ch,str.substring(1));//1st recursion call to take the 
    //1st character and call the recursion with the substring with 1st character
    //removed
    ArrayList<String> l2=subSeq2(p,str.substring(1));//2nd recursion call is to ignore
        //the 1st character and call the recursion with the substring with 1st character
        //removed
        l1.addAll(l2);
        return l1;
    }

}
