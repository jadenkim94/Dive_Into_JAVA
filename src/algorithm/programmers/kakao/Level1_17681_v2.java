package algorithm.programmers.kakao;

public class Level1_17681_v2 {
    public static void main(String[] args) {
        String[] solution = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        for(String s : solution){
            System.out.println(s);
        }
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        // 정수를 이진수로
        String[] sArr1 = binaryArray(arr1);
        String[] sArr2 = binaryArray(arr2);
        String[] combineArray = combineArray(sArr1, sArr2);
        return combineArray;
    }

    public static String[] binaryArray(int[] arr){
        String[] binaryArr = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            String intToBin = Integer.toBinaryString(arr[i]);
            stringBuilder.append(intToBin);
            while (stringBuilder.length()!=arr.length){
                stringBuilder.insert(0, 0);
            }
            binaryArr[i] = stringBuilder.toString();
        }
        return binaryArr;
    }

    public static String[] combineArray(String[] sArr1, String[] sArr2){
        String[] combinedArray = new String[sArr1.length];
        int combinedArrayLength = combinedArray.length;

        for(int i = 0 ; i < combinedArray.length; i++){
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0 ; j < combinedArrayLength; j++){
                if(sArr1[i].charAt(j) == '1' || sArr2[i].charAt(j) == '1'){
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            combinedArray[i] = stringBuilder.toString();
        }
        return combinedArray;
    }
}
