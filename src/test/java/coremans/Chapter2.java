package coremans;

import org.junit.Test;

/**
 * Created by devesh on 12/9/14.
 */
public class Chapter2 {

    @Test
    public void testInsertionSort() throws Exception{
        int [] a = {5,2, 6,1,4,3};
        for(int j= 1; j < a.length; j++){
            int key = a[j];
            int i = j -1;
            while(key < a[i]){
                a[i+1] = a[i];
                i--;
                if(i < 0){
                    break;
                }
            }
            a[i+1] = key;
        }
        for(int i=0; i< a.length -1; i++){
            assert (a[i] < a[i+1]);
        }

    }
}
