package codility;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        String result = "";
        Scanner stdin = new Scanner(System.in);
        String line = stdin.nextLine();
        int numInputs = Integer.parseInt(line);
        for(int i=0;i< numInputs; i++)
        {
            int n = Integer.parseInt(stdin.nextLine());;
            int res = 1;
            boolean add = false;
            for(int j=1; j<= n; j++){
                if(add){
                    res++;
                    add = false;
                }else{
                    res = res<<1;
                    add= true;
                }
            }
            result += String.format("%s %s\n", n,res);
        }
        stdin.close();
        System.out.println(result);
    }
}