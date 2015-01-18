package hackerrank;

import java.util.Scanner;

/**
 * Created by devesh on 1/8/15.
 */
public class Letter {
    public static boolean isPalindrome(String word){
        int len = word.length();
        for(int i=0; i< len/2;i++){
            if(!word.substring(i, i+1).equals(word.substring(len - i -1, len-i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int N = Integer.parseInt(stdin.nextLine());
        String result = "";
        for(int i=0; i < N; i++){
            String word = stdin.nextLine();
            int steps = 0;
            int len = word.length();
            int currIndex = len -1;
            while(!isPalindrome(word)){
                char ch = word.charAt(currIndex);
                if(ch != 'a'){
                    ch = (char)(((int)ch) -1 );
                    String prefix = word.substring(0, currIndex);
                    String suffix = currIndex != len -1 ? word.substring(currIndex+1, len):"";
                    word = prefix + Character.toString(ch)+ suffix;
                    steps++;
                }
            }
            result += String.format("%s\n", steps);
        }
        stdin.close();


    }
}
