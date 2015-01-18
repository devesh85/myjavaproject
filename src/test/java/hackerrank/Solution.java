package hackerrank;

/**
 * Created by devesh on 1/8/15.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) {

        int maxValue = 0;
        for(int i=l; i<= r; i++){
            for(int j=i; j<= r; j++){
                int currVal = i ^ j;
                if(currVal > maxValue ){
                    maxValue = currVal;
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}