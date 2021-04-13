package algorithm.basic.sort;

import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = new int[20];

        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100);
            System.out.print(list[i] + " ");
        }
        System.out.println();
        bubbleSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }


    }

    public static void bubbleSort(int[] list) {
       for(int i = 0; i < list.length-1; i++){
           boolean swap = false;
           for(int j = 0; j < list.length-1-i; j++){
               if(list[j] > list[j+1]){
                   int temp = list[j];
                   list[j] = list[j+1];
                   list[j+1] = temp;
                   swap = true;
               }
           }
           if(!swap)
               break;
       }
    }


}
