// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
import java.util.HashSet;
import java.util.Scanner;

class LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        
        Scanner scan= new Scanner(System.in);
        System.out.println("enter the string");
        String str= scan.next();
        //using sliding window and 2 pointers ie l and r
        int l=0;
        int r=0;
        int maxLength=0;
        HashSet<Character> set= new HashSet<>();
        //cadbzabcd
        while(r<str.length()){
            if(!set.contains(str.charAt(r))){
                set.add(str.charAt(r));
                if((r-l)+1 > maxLength ){
                    maxLength=(r-l)+1;
                }
                r++;//if set does not contains the character at r then r pointer
    //should move forward
            }
            else{
                set.remove(str.charAt(l));//if set contains the character at r 
//pointer then that character should be removed and the l pointer should move 
//forward and l pointer should keep moving forward till l pointer is one index 
//ahead of the repeated character and the all the characters till the repeated
//characters are removed from the set so that the 1st if condition ie
//if(!set.contains(str.charAt(r))) evaluates to true and we can look for a new
//substring
 l++;

            }


        }
        System.out.println("length of longest substring is "+maxLength);
        
    }
}
