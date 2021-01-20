package datastructure.class_object_reference;

import java.util.Scanner;

public class Code15 {
    public static void main(String[] args) {
        // 수를 입력받아서 정렬해서 출력
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int [] data = new int[n];

        for(int i = 0 ; i < n; i++){
            int tmp = sc.nextInt();
            // 현재 배열에 저장된 데이터의 갯수는 i 개
            int j = i-1; // 현재 가장 큰 데이터 data[j]
            while (data[j] > tmp){
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = tmp;

        }



    }
}
