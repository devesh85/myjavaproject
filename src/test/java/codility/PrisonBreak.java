package codility;

import org.junit.Test;

import java.util.*;

/**
 * Created by devesh on 1/5/15.
 */
public class PrisonBreak {

//    A[0] = 0    B[0] = 1    C[0] = 1
//    A[1] = 1    B[1] = 2    C[1] = 6
//    A[2] = 2    B[2] = 3
//    A[3] = 3    B[3] = 4
//    A[4] = 3    B[4] = 5
//    A[5] = 2    B[5] = 6
//    A[6] = 6    B[6] = 8
//    A[7] = 6    B[7] = 7

    public int solution(int[] A, int[] B, int[] C) {
        int wt = A.length *2;
        int [] cell = new int [A.length + 1] ;
        int count =0;

        if(C.length == 0)
            return count;

        for(int i=0; i< A.length+1; i++){
            cell[i] =0;
        }
        for(int i =0; i< A.length ; i++){
            cell[A[i]]++;
            cell[B[i]]++;
        }
        for(int i=0; i< cell.length; i++){
            if(cell[i] == 1){
                cell[i] = wt;
                count++;
            }
        }
        if(count ==1)
            return count;


        for(int i=0; i< C.length; i++){
            if(cell[C[i]] == wt){
                return -1;
            }
            cell[C[i]] = -1;

        }
        boolean goOn = true;
        while(goOn){
            goOn = false;
            for(int i=0; i< A.length; i++){
                if(cell[A[i]] == wt && cell[B[i]] > 0 && cell[B[i]] < wt  ){
                    cell[B[i]] = wt ;
                    cell[A[i]] = 0;
                    goOn = true;
                }else if(cell[B[i]] == wt && cell[A[i]] > 0){
                    cell[A[i]] = wt;
                    cell[B[i]] = 0;
                    goOn = true;
                }
            }
            int newCount = 0;
            for(int i= 0; i< cell.length; i++){
               if(cell[i] == wt){
                   newCount++;
               }
            }
            if(newCount < count){
                count = newCount;
            }

        }

        return count;
    }

    @Test
    public void testExample() throws Exception{
        int [] A = {0,1,2,3,3,2,6,6};
        int [] B = {1,2,3,4,5,6,8,7};
        int [] C = {1,6};

        assert (4 == solution(A,B,C));
    }
//    public static void main(String[] args) {
//        PrisonBreak p = new PrisonBreak();
//
//        int [] A = {0,1,2,3,3,2,6,6};
//        int [] B = {1,2,3,4,5,6,8,7};
//        int [] C = {1,6};
//    }
}
