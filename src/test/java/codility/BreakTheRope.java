package codility;

/**
 * Created by devesh on 1/1/15.
 */
class BreakTheRope {
    public int solution(int[] A, int[] B, int[] C) {

        int start = 0;

        int end = A.length - 1;
        boolean ok = true;
        int count = 0;
        while(true){
            if(start > end){
                break;
            }
            int mid = start + ( end - start)/2;
//            int mid = end;
            ok = true;
            int [] T = new int [mid+1];
            for(int i = mid; i >=0; i--){
                T[i] +=  B[i];
                if(C[i] >= 0){
                    T[C[i]] += T[i];
                }
                if(A[i] - T[i]  < 0){
                    ok = false;
                    break;
                }
            }

            if(ok){
                start = mid + 1;
                count = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return count;

    }




    public static void main(String[] args) {

        BreakTheRope s = new BreakTheRope();
        int [] A = {5, 3, 6, 3, 3};
        int [] B = {2, 3, 1, 1, 2};
        int [] C = {-1, 0, -1, 0, 3};

//        int [] A = {4, 3, 1};
//        int [] B = {2, 2, 1};
//        int [] C = {-1, 0, 1};
        int res = s.solution(A,B,C);
        System.out.println(res);
    }

}
