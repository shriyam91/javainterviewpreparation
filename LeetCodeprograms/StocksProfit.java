import java.util.Scanner;

public class StocksProfit {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the size of array");
        int N= scan.nextInt();
        scan.nextLine();
        int[] stock= new int[N];
        for (int index = 0; index < stock.length; index++) {
            stock[index]=scan.nextInt();
        }
        stockCal(stock);
    }

    private static void stockCal(int[] stock) {
        int min=0, max=0, maxprofit=0;
        for(int i=0;i<stock.length-1;i++){
//running the outer loop only till 2nd last element of the array bcz we will
//compare 2nd last element to the last element and we cannot compare last element
//with anyother bcz there is no element after that and moreover NOTE: whenever
// we run an inner loop using which we compare the array[i] element with all the
//further elements represented by array[j] then either of the 2 things should
//match to avoid error:
//1st: either in the inner loop j will start with j=i
// or if in the inner loop j is initialized as j=i+1 then in the outer loop i 
// will run only till i<array.length-1
//the above 2 conditions are important bcz either the last comparison will be the 
// comparison of 2nd last element  with
//the last element(so i will run till i< array.length-1) and if have to perform
//the comparison on last element also then only solution to this is that the last
//element will be compared to itself so j=i in the inner loop 
            for(int j=i+1;j<stock.length;j++){
                if(stock[j]-stock[i]>maxprofit){
                    min=stock[i];
                    max=stock[j];
                    maxprofit=stock[j]-stock[i];

                }
            }
        }
        System.out.print("As per the given data one should buy at "+ min+" sell at " +max+ " to make most profit of "+maxprofit);
    }
    
}
