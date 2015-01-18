package codility;

import org.junit.*;
import org.junit.Test;
import sun.security.util.BigInt;

import java.math.BigInteger;

/**
 * Created by devesh on 1/8/15.
 */
public class Tester {

    @Test
    public void testFibo() throws Exception{
        String input = "0 1 10";
        String [] arr= input.split(" ");
        int N = Integer.parseInt(arr[2]);

        BigInteger[] arrInt = new BigInteger[N];
        arrInt[0] = new BigInteger(arr[0]);
        arrInt[1] = new BigInteger(arr[1]);
        for(int i=2; i<N; i++){
            arrInt[i] =   (arrInt[i-1].multiply(arrInt[i-1])).add(arrInt[i-2]);
        }
        System.out.println(arrInt[N-1]);
    }
}
