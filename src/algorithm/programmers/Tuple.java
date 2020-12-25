package algorithm.programmers;

/*
문제 설명
셀수있는 수량의 순서있는 열거 또는 어떤 순서를 따르는 요소들의 모음을 튜플(tuple)이라고 합니다.
n개의 요소를 가진 튜플을 n-튜플(n-tuple)이라고 하며, 다음과 같이 표현할 수 있습니다.

(a1, a2, a3, ..., an)
튜플은 다음과 같은 성질을 가지고 있습니다.

중복된 원소가 있을 수 있습니다. ex : (2, 3, 1, 2)
원소에 정해진 순서가 있으며, 원소의 순서가 다르면 서로 다른 튜플입니다. ex : (1, 2, 3) ≠ (1, 3, 2)
튜플의 원소 개수는 유한합니다.
원소의 개수가 n개이고, 중복되는 원소가 없는 튜플 (a1, a2, a3, ..., an)이 주어질 때(단, a1, a2, ..., an은 자연수),
이는 다음과 같이 집합 기호 '{', '}'를 이용해 표현할 수 있습니다.

{{a1}, {a1, a2}, {a1, a2, a3}, {a1, a2, a3, a4}, ... {a1, a2, a3, a4, ..., an}}
예를 들어 튜플이 (2, 1, 3, 4)인 경우 이는

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
와 같이 표현할 수 있습니다. 이때, 집합은 원소의 순서가 바뀌어도 상관없으므로

{{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
{{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
{{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.

특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
"{{2},{2,1},{2,1,3},{2,1,3,4}}"     ->  	[2, 1, 3, 4]
"{{1,2,3},{2,1},{1,2,4,3},{2}}"	    ->      [2, 1, 3, 4]
"{{20,111},{111}}"	                ->      [111, 20]
"{{123}}"	                        ->      [123]
"{{4,2,3},{3},{2,3,4,1},{2,3}}"	    ->      [3, 2, 4, 1]
 */
public class Tuple {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        // 확인
        int[] solution = solution(s);
        for(int i : solution){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String s){

        // 문자열 정리
        s = s.substring(2, s.length()-2).replace("},{", "//");
        String [] sArr = s.split("//");

        // 배열의 크기가 작은순으로 정렬
        Arrays.sort(sArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) {
                    return 1;
                } else
                    return -1;
            }
        });

        // 문자열 배열에서 숫자들을 뽑아올 때, 중복된 숫자는 제거
        ArrayList<Integer> arr = new ArrayList<>();

        for(String str : sArr){
            String[] val = str.split(",");

            for(int i = 0 ; i < val.length; i++){
                int num = Integer.parseInt(val[i]);
                if(!arr.contains(num))
                    arr.add(num);
            }
        }

        int[] answer = new int[arr.size()];
        for(int i = 0 ; i <arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
