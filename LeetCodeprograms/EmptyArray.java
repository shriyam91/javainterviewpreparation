class EmptyArray{
    public static void main(String[] args) {
 //If the numbers are at  first of the print statement, then a numeric addition
 // is done first, because the leftmost two operands are numbers. 
        System.out.println(10+20+"hello");
  //If numbers are at the last of the print statement then only concatenation of those
  //numbers occurs.     
        System.out.println("hello"+10+20);
         int arr[]=new int[2];
          float arr1[]=new float[2];
        String arr2[]=new String[2];
//bydefault vaue of an int array is 0, of float array is 0.0, of string array
//is null   
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);


    }
}