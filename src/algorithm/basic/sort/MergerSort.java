package algorithm.basic.sort;

public class MergerSort {

    static int [] tmp;

    public static void main(String[] args) {
        int [] list = new int[10];
        tmp = new int[list.length];
        for(int i = 0; i < list.length; i++){
            list[i] = (int) (Math.random()*100);
        }
        mergeSort(list, 0, list.length-1);

        for (int i : list) {
            System.out.print(i + " ");
        }

    }

    static void mergeSort(int [] list, int start, int end){
        if(start < end){
            int middle = (start+end)/2;
            mergeSort(list, start, middle);
            mergeSort(list, middle+1, end);
            merge(list, start, middle, end);
        }
    }

    static void merge(int [] list, int start, int middle, int end){
        int i = start;
        int j = middle+1;
        int index = start;

        while (i <= middle && j <= end){
            if(list[i] <= list[j]){
                tmp[index] = list[i];
                i++;
            } else {
                tmp[index] = list[j];
                j++;
            }
            index++;
        }

        if (i > middle){ // j가 아직 안끝남
            for(int k = j; k <= end; k++){
                tmp[index] = list[k];
                index++;
            }
        } else {
            for(int k = i; k <= middle; k++){
                tmp[index] = list[k];
                index++;
            }
        }

        // tmp -> list
        for(int k = start; k <= end; k++){
            list[k] = tmp[k];
        }
    }
}
