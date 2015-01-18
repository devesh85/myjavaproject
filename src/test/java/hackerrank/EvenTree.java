package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class EvenTree {


    public static void main(String[] args) {
//        Scanner stdin = new Scanner(System.in);
//        String nums = stdin.nextLine();
        String [] lines = {
                "10 9",
                "2 1",
                "3 1",
                "4 3",
                "5 2",
                "6 1",
                "7 2",
                "8 6",
                "9 8",
                "10 8"
        };
        String nums = lines[0];
        String [] arr = nums.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Set<Integer> added = new HashSet<Integer>();
        for(int i= 0; i< M; i++){
            String line = lines[i+1];//stdin.nextLine();
            String [] splitArr = line.split(" ");
            int a = Integer.parseInt(splitArr[0]);
            int b = Integer.parseInt(splitArr[1]);
            Set<Integer> connA = map.get(a);
            Set<Integer> connB = map.get(b);
            if(connA == null){
                connA = new HashSet<Integer>();
            }
            if(connB == null){
                connB = new HashSet<Integer>();
            }

            if(!added.contains(b)){
                connA.add(b);
                added.add(b);


            }
            if(!added.contains(a)){
                connB.add(a);
                added.add(a);
            }
            map.put(a, connA);
            map.put(b, connB);
        }

        System.out.println(N);
    }
}