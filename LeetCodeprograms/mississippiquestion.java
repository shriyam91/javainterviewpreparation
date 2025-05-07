import java.util.Scanner;
public class mississippiquestion {
    
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        
        System.out.println("enter the string");
        String str= scan.next();
        System.out.println("output will be "+printFrequency(str));

    }
    //mississippi:mis2is2ip2i, baaa:b3,hbhbb:hbhb2,bbhh:b2h2
    private static String printFrequency(String str) {
        StringBuilder st= new StringBuilder();
        int c=1;
        for(int i=0;i<= str.length()-2;i++){
            if (str.charAt(i)==str.charAt(i+1)){
                c=c+1;
                //since when the index is at the 2nd last index so in that case
    //to print the last character(when the 2nd last character is not equal to
    //last character ) or if the last 2 or more characters are same then to print the 
    //the character along with their frequency we need to handle that case using 
    //a if for all 3 cases:1st when 2nd last charcter and last character or more are 
    //same,2nd: when 2nd last character and last character are not same 
    //3rd: when 3rd last and 2nd last and last character all are different
                //1stcase:when 2nd last and last char are same
                    if(i==str.length()-2){
                    st.append(str.charAt(i));
                    char val= (char)(c+'0');
                    st.append(val);    
                }
            }
            else{
                if(c==1){
                st.append(str.charAt(i));
                //2ndcase:when 3rd,2nd and last character all are different
                if(i==str.length()-2){
                    st.append(str.charAt(i+1));
                        
                }
            }
            else if(c>1)
            {   
                st.append(str.charAt(i));
                char val= (char)(c+'0');
                st.append(val);
                if(i==str.length()-2){
                    st.append(str.charAt(i+1));
                        
                }
                c=1; 
            }
        }
    }

    return st.toString();
    }

}