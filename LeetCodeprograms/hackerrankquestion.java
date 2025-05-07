import java.util.Scanner;

public class hackerrankquestion {
//although this solution is also correct but i have done this question in a shorter
//way in mississippi.java file
    public static void main(String[] args){
        //input mississippi as mis2is2ip2i baaa as b3 , repetition cannot be more
        //than 9, input bhhhh output: bh4
        short i=9;
        int j= 6;
        System.out.println(i+j);
        //System.out.println(j);
      Scanner scan= new Scanner(System.in);
          String str= new Scanner(System.in).next();
        
       // System.out.println(aa+bb);
         printcount(str);
         

        
    }//baaaa
    //mississippi

    private static void printcount(String str) { 
        int count=0;
        for(int i=0;i<=str.length()-2;i++){
            char ch= str.charAt(i);
            if(str.charAt(i+1)==ch && i!=str.length()-2){
                count=count+1;
                continue;
            }
            if(str.charAt(i+1)==ch && i==str.length()-2){
                count=count+1;
                System.out.print(str.charAt(i));
                count=count+1;
                if(count>=2){
                char charval= (char)(count+'0');
                System.out.print(charval);
            }
        }
         
            if(str.charAt(i+1)!=ch && i!=str.length()-2){
                System.out.print(str.charAt(i));
                count=count+1;
                if(count>=2){
                char charval= (char)(count+'0');
                System.out.print(charval);
                }
                
                
                
                count=0;
            }
             if(str.charAt(i+1)!=ch && i==str.length()-2){
                System.out.print(str.charAt(i));
                count=count+1;
                if(count>=2){
                char charval= (char)(count+'0');
                System.out.print(charval);
                }
                System.out.print(str.charAt(i+1));
                
                
                
                count=0;
            }

        }
    }
}

        // int count;
        // for(int i=0;i<=str.length()-2;i++){
        //     count=0;
        //     char ch= str.charAt(i);
        //     for(int j=i+1; j<=str.length()-1;j++){
        //         if(str.charAt(j)==ch){
        //             count=count+1;
        //         }
        //         else{
        //             if(count==0){
        //                 System.out.print(ch);
        //             }
        //             if(count>=1){
        //                 count=count+1;
        //                 char chval= (char)(count+'0');
        //                 System.out.print(ch);
        //                 System.out.print(chval);
        //             }
        //             break;//this will break from the inner for loop
        //         }
        //     }
        // }
   // }
    
//}
