package datastructure.class_object_reference;

import java.util.Scanner;

public class Code14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("====");
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        bubbleSort(array);

        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i]+ " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i = arr.length-1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

}
