package algorithm.skills.permutation;

import java.util.ArrayList;

public class PermutationPrac {
    int [] numberList;
    boolean [] isUsed;
    ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        int [] numberList = {1,2,3,4};
        PermutationPrac permutationPrac = new PermutationPrac(numberList);

        permutationPrac.permutation(2);
    }

    public PermutationPrac(int[] numberList){
        this.numberList = numberList;
        this.isUsed = new boolean[numberList.length];
    }

    public void permutation(int depth){
        if(result.size() == depth){
            printResult();
            return;
        }
        for(int i = 0; i < numberList.length; i++){
            if(isUsed[i] == false){
                isUsed[i] = true;
                result.add(numberList[i]);
                permutation(depth);
                // depth 만큼 내려간 경우
                isUsed[i] = false;
                result.remove(result.size()-1);
            }
        }

    }

    public void redunduntPermutation(int depth){
        if(result.size() == depth){
            printResult();
            return;
        }
        for(int i = 0; i < numberList.length; i++){
            result.add(numberList[i]);
            redunduntPermutation(depth);
            result.remove(result.size()-1);
        }
    }

    private void printResult() {
        result.forEach( e -> {
            System.out.print(e + " ");
        });
        System.out.println();
    }
}
