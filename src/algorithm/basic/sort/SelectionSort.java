package algorithm.basic.sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = new int[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 100);
        }

        for (int element : list) {
            System.out.print(element + " ");
        }
        System.out.println();

        selectionSort(list);

        for (int element : list) {
            System.out.print(element + " ");
        }
    }

    private static void selectionSort(int[] list) {
        for(int i = 0; i <list.length; i++){
            int minIndex = i;
            for(int j = i+1; j < list.length; j++){
                if(list[minIndex] > list[j]){
                    minIndex = j;
                }
            }
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }

}
