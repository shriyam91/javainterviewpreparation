
    
import java.util.Scanner;
import java.util.Arrays;
public class ttt
 {
    static Scanner scan =new Scanner(System.in);
    public static void main(String[] args)
    {
        
        char board[][]={{'_','_','_'},
                        {'_','_','_'},
                        {'_','_','_'}};


    

      System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.

            //Task 2: Call the function printBoard();
         printboard(board);
         for(int i=1;i<=9;i++)
         {
             
             if(i%2!=0)
             {
                 System.out.println("it is X's turn");
                 int index[]=askUser(board);
                 int k= index[0];
                 int l= index[1];
                 board[k][l]='X';
                }
                else{
                    System.out.println("it is O's turn");
                    int ind[]=askUser(board);

                    int k= ind[0];
                    int l= ind[1];
                    board[k][l]='O';
                }
                printboard(board);
          if(i>=5){
            checkWin(board,i);
        }
         
         
    }

             
              /*
              {  Task 3: Loop through turns.

                  if (X) turn {
                     Task 4: call askUser(). 
                     Task 5: populate the board using askUser's return value.
                  } else {
                      Task 4: call askUser(). 
                      Task 5: populate the board using askUser's return value. Then, print it.

                  }

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */

           
        } 

public static void printboard(char pr[][])
{
  for (int i=0; i<pr.length;i++){
      System.out.print("\t");
    for(int j=0;j<pr[i].length;j++){
      
        System.out.print(pr[i][j]+ " ");
      
      
    }System.out.println("\n \n");
  }
}
   public static int[] askUser( char br[][])
   {  
       System.out.println("enter the index of row  want to mark on");
       int c=scan.nextInt();
       System.out.println("enter the index of column  want to mark on");
       int d=scan.nextInt();
       int val[]={c,d};
       while(true)
       {
          if(br[c][d]=='X'|| br[c][d]=='O')
          {
            System.out.println("the position is already marked, please reenteer the new row and column index");
            c=scan.nextInt();
            d=scan.nextInt();
       }
       else
       {
           return val;//since return keyword has inbuilt break in it, so as the value is returned the while loop automatically will break inspite of true condition in while
           
           
       }
    }


   }
   public static void checkWin(char br[][],int pp){
       int count=0;
       int cc=0;

       for(int i=0; i<br.length; i++)
       {
           if( br[i][0]=='X' && br[i][1]=='X' && br[i][2]=='X'){
               System.out.println("X wins ,bhapkaaaa");
               System.exit(0);

           } if( br[i][0]=='O' && br[i][1]=='O' && br[i][2]=='O'){
            System.out.println("O wins ,bhapkaaaa");
            System.exit(0);

        }

          
           if( br[0][i]=='X' && br[1][i]=='X' && br[2][i]=='X'){
               System.out.println("X wins ,bhapkaaaa");
               System.exit(0);

           }
           
           if( br[0][i]=='O' && br[1][i]=='O' && br[2][i]=='O'){
            System.out.println("O wins ,bhapkaaaa");
            System.exit(0);

        }
           
       }
      
       
          

       
       for(int i=0; i<br.length; i++){
        for(int j=0; j<br[i].length; j++){
            if(i==j){

            
            if(br[i][j]=='X')
           {
               count=count+1;
           }
           if(br[i][j]=='O')
           {
               cc=cc+1;
           }
        }
           if(i+j==2)
           {
               if(br[i][j]=='X'){
                   count=count+1;

               }
               if(br[i][j]=='O'){
                cc=cc+1;

            }
        
               }
           }
          


        }
        System.out.println(count+" "+ cc);
        if(count==3)
        { 
            System.out.println("X wins, Bhapkaaaa");
            System.exit(0);

        }
        if(cc==3){
            System.out.println("O wins, Bhapkaaaa");
            System.exit(0);
        }
    
          
          
           
       
      
       
          

       
      
           
          


        
        
       else
       {
           if(pp>=5 && pp<9){

           
           System.out.println("no one won till now, keep playing");
        }
        else{
            System.out.println("no one won, it is draw");
        }
       
        }

    }

   }

    /** Task 2 - Write a function that prints the board.
     * Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */        

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */




