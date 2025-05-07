import java.util.HashMap;

class hashedInQuestion1{
    public static void main(String[] args){
        //find number of consequitive one
        //[1,1,0,1,1,1]:3
        //[1,1,2,0,1,1,1,0,0]
        int arr[]={1,1,2,0,1,1,1,1,0};
        System.out.println(find(arr));
    }
    public static int find(int arr[]){
        int max=0;
        int l=0;
        int r=0;
    while (r<arr.length) {
        if(arr[r]==1){
            if((r-l)+1>max){
                max=(r-l)+1;
            }
            r++;
        }
        else{
            r++;
            l=r;
        }
    }        
    return max;
            }
        
    
}