package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by devesh on 1/8/15.
 */
public class Test {
    public static void main(String[] args) {

        String inputString = "aaabbbb";

        String ans;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0; i< inputString.length(); i++){
            String sub = inputString.substring(i, i+1);
            Integer count = map.get(sub);
            if(count == null){
                map.put(sub, 1);
            }else{
                map.put(sub, count +1);
            }
        }
        int oddCount =  0;
        for(String sub: map.keySet()){
            if(map.get(sub)%2 != 0)
                oddCount++;
        }

        ans = oddCount > 1? "NO": "YES";
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        System.out.println(ans);

    }
}
