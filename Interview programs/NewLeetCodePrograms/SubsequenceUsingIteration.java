import java.util.ArrayList;
import java.util.List;

public class SubsequenceUsingIteration {
    public static void main(String[] args){

        int[] arr={1,2,3};
        List<List<Integer>> list=SubseqUsingIteration(arr);
        for( List<Integer> lst: list){
            System.out.println(lst.toString());
        }
    }
    public static List<List<Integer>> SubseqUsingIteration(int[] arr){
        if (arr.length > 5) { // Limit to a reasonable size, e.g., 20
            throw new IllegalArgumentException("Input array too large. Maximum size allowed is 20.");
        }
        List<List<Integer>> outerList= new ArrayList<>();
        outerList.add(new ArrayList<>());
        for(int num: arr){

            for(int j=0;j<outerList.size();j++){
                List<Integer> inner= new ArrayList<>(outerList.get(j));
                inner.add(num);
                outerList.add(inner);
        }
    }
    return outerList;
    
}
}