package codility;

import org.junit.Test;
import org.junit.*;

import java.util.*;

/**
 * Created by devesh on 1/11/15.
 */
public class CityComparator {

    @Test
    public void testMe() throws Exception{
        int [] C = {1,3,0,3,2,4,4};
        int [] D = {6,2,7,5,6,5,2};
        System.out.println(solution(2,C,D));
    }

    @Test
    public void testMe0() throws Exception{
        int [] C = {1,3,0,3,2,4,4};
        int [] D = {1,1,1,1,1,1,1};
        System.out.println(solution(2,C,D));
    }

    @Test
    public void testMe2() throws Exception{
        int [] C = {1,3,0,3,2,4,4};
        int [] D = {6,2,7,5,6,5,2};
        System.out.println(solution(5,C,D));
    }

    @Test
    public void testMe3() throws Exception{
        int [] C = {1,3,0,3,2,4,4};
        int [] D = {6,2,7,5,6,5,2};
        System.out.println(solution(7,C,D));
    }



    public int solution(int K, int[] C, final int[] D) {
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return  D[o2] - D[o1] ;
//            }
//        };

        TreeMap<Integer, Set<Integer>> likenessMap = new TreeMap<Integer, Set<Integer>>();
        for(int i=0; i< D.length; i++){
            int likeNess = D[i];
            Set<Integer> set = likenessMap.get(likeNess);
            if(set == null){
                set = new HashSet<Integer>();
            }
            set.add(i);
            likenessMap.put(likeNess, set);
        }

        Map<Integer, Set<Integer>> pathMap = new HashMap<Integer, Set<Integer>>();
        for(int i=0; i< C.length; i++){
            Set<Integer> path = pathMap.get(i);
            if(path == null)
                path = new HashSet<Integer>();
            path.add(C[i]);
            pathMap.put(i, path);
            path = pathMap.get(C[i]);
            if(path == null)
                path = new HashSet<Integer>();
            path.add(i);
            pathMap.put(C[i], path);
        }

//        for(Integer lk : likenessMap.descendingKeySet()){
            Set<Integer> lkSet = likenessMap.descendingKeySet();
        Integer[] array = (Integer[]) lkSet.toArray();
        int index = 1;
        Set<Integer> keys = likenessMap.get(array[0]);
            Set<Integer> visited = new HashSet<Integer>();
            Set<Integer> inPath = new HashSet<Integer>();
            for(Integer head: keys){
                visited.add(head);
                int counter = 1;
                while(counter < K){
                    int nextCity = array[index++];
                    inPath.add(nextCity);

                    boolean added = true;
                    while (added){
                        added = false;
                        Set<Integer> toMove = new HashSet<Integer>();
                        for(Integer city: inPath){
                            for(Integer inCity: visited){
                                if(pathMap.get(inCity).contains(city)){
                                    toMove.add(city);
                                    added = true;
                                    break;
                                }
                            }
                        }
                        for(Integer city: toMove){
                            visited.add(city);
                            inPath.remove(city);
                        }
                    }

                    counter++;
                }
            }








        return K;
    }

}
