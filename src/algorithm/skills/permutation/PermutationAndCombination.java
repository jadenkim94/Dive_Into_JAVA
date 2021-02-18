package algorithm.skills.permutation;

import java.util.ArrayList;

public class PermutationAndCombination {

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5 중 3개 를 순서있이 뽑는 경우의 수   5P3
        // -> depth = 3
        isUsed = new boolean[4];
        permutation(4, 2);
    }

    public static ArrayList<Integer> result = new ArrayList<>();
    public static boolean[] isUsed;

    public static void permutation(int n, int m){
        if( result.size() == m){
            printResult();
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            if(isUsed[i-1] == false){  // 사용하지 않은 수라면 (0-1, 1-2, 2-3, 3-4, 4-5)
                isUsed[i-1] = true;    // 사용을 표시하고
                result.add(i);         // 결과배열에 추가
                permutation(n, m);     // 다음 depth
                System.out.println("=====");
                result.remove(result.size()-1); // 이코드로 넘어왔다는건, result.size() == m 이 되었단 거겠지?
                isUsed[i-1] = false;
            }
        }
    }

    public static void redundentPermutation(int n, int m){
        if(result.size() == m){
            printResult();
            return;
        }
        for(int i = 1 ; i <= n ; i++){
            result.add(i);
            permutation(n,m);
            result.remove(result.size()-1);
        }
    }

    public static void combination(int n, int m, int start){ // 5C3
        if(m == 0){
            printResult();
            return;
        }

        for(int i=start;i<=n;i++){
            result.add(i);
            combination(n,m-1,i+1);
            result.remove(result.size()-1);
        }
    }

    public static void redundantCombination(int n, int m, int start) {
        if (m == 0) {
            printResult();
            return;
        }
        for(int i=start;i<=n;i++){
            result.add(i);
            combination(n,m-1,i);
            result.remove(result.size()-1);
        }
    }


        public static void printResult(){
        result.forEach(i -> System.out.print(i+" "));
        System.out.println();
    }

}
