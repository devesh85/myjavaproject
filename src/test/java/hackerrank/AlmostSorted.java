package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by devesh on 1/15/15.
 */
public class AlmostSorted {
    public static String result(List<Integer> list){
        String result = "no";
        boolean anomaly = false;
        boolean swap = false;
        boolean reverse = false;
        boolean processed = false;
        boolean possible = false;
        int from = -1;
        int to = -1;
        int fromNum = Integer.MIN_VALUE;

        for(int i=0; i< list.size() - 1; i++){
            if(list.get(i) > list.get(i+1)){
                if(anomaly){
                    reverse = true;
                    to = i+1;

                }else{
                    anomaly = true;
                    from = i+1;
                    fromNum = list.get(i);
                    swap = true;
                }
            }else{
                if(anomaly){
                    swap = true;
                }
            }
        }

        if(swap && possible){
            result = String.format("yes\nswap %s %s", from, to);
        }
        if(reverse && possible){
            result = String.format("yes\nreverse %s %s", from, to);
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 10;
        List<Integer> list = new ArrayList<Integer>();
        int[] arr = {1,8,3,4,5,6,7,2,9,10,11,12};
        for(int i=0; i< N; i++)
            list.add(arr[i]);
        System.out.println(result(list));
    }

//    public static void main(String[] args) {
//        Scanner stdin = new Scanner(System.in);
//        int N = Integer.parseInt(stdin.nextLine());
//        String [] numStr = stdin.nextLine().split(" ");
//
//        List<Integer> list = new ArrayList<Integer>();
//        for(int i=0; i< N; i++){
//            list.add(Integer.parseInt(numStr[i]));
//        }
//        System.out.println(result(list));
//    }
}
