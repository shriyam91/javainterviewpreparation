import java.util.Arrays;

class maxandmin{
    public static void main(String args[]){
     int[] arr= new int[]{2,4,5,6,332};
    System.out.println( Arrays.stream(arr).max().getAsInt());
    System.out.println( Arrays.stream(arr).min().getAsInt());
    Integer a= 34;
    Integer b=34;
    System.out.println(a==b);
    Integer c=555;
    Integer d=555;
    System.out.print(c==d);
    
}
}
 