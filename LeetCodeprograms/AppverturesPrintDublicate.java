import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppverturesPrintDublicate {
     
    public static void main(String[] args) {
//         input - [1,4,7,9,4,9]
// output- [4,9]
        int[] arry={1,4,7,9,4,9};

       System.out.println( Arrays.toString(dublicate(arry).toArray(new Integer[0])));

    }
    public static List dublicate(int[] arry){
        List<Integer> list= new ArrayList<>();
        int val;
        for(int i=0;i<arry.length-1;i++){
            val=0;
            for(int j=i+1;j<arry.length;j++){
                if(arry[i]==arry[j]){
                    val=val+1;
                    break;
                }
            }
            if(val>0){
                list.add(arry[i]);
            }
        }
        return list;
    }
}
