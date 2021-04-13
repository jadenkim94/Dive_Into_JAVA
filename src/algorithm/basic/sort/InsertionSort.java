package algorithm.basic.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int [] list = new int[10];
        for(int i = 0 ; i < list.length; i++){
            list[i] = (int) (Math.random()*100);
        }
        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();
        insertionSort2(list);
        for (int element : list) {
            System.out.print(element + " ");
        }

    }

    public static void insertionSort(int [] list){
        for(int target = 1; target < list.length; target++){
            for(int infront = target; infront > 0; infront--){
                if(list[infront-1] > list[infront]){
                    int temp = list[infront-1];
                    list[infront-1] = list[infront];
                    list[infront] = temp;
                } else {
                    break;
                }
            }

        }
    }

    public static void insertionSort2(int [] list){
        if(list.length == 1){
            return;
        }
        for(int i = 1; i < list.length; i++){
            int key = list[i]; // i : 정렬안된 부분 중 가장 작은 인덱스, key : 정렬안된 부분 중 가장 첫 원소
            int j = i-1;       // j : 정렬된 부분의 인덱스, 최초라면 0
            while (j >= 0 && key < list[j]){ // 정렬된 부분의 인덱스가 key 보다 크다면
                list[j+1] = list[j];        // 해당 인덱스의 값을 뒤로 밀어버리고
                j--;                        // 정렬된 부분의 인덱스를 한칸 줄여서 다시 key 와 비교
            }
            list[j+1] = key;
        }
    }
}
