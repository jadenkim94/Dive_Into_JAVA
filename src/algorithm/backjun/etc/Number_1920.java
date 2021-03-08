package algorithm.backjun.etc;

import java.io.*;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/1920

5
4 1 5 2 3
5
1 3 7 9 5
 */
public class Number_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nInput = br.readLine();
        String[] nInputs = nInput.split(" ");
        int[] nArr = new int[nInputs.length];
        for (int i = 0; i < nArr.length; i++) {
            nArr[i] = Integer.parseInt(nInputs[i]);
        }
        int m = Integer.parseInt(br.readLine());
        String mInput = br.readLine();
        String[] mInputs = mInput.split(" ");
        int[] mArr = new int[mInputs.length];
        for (int i = 0; i < mArr.length; i++) {
            mArr[i] = Integer.parseInt(mInputs[i]);
        }

        Arrays.sort(nArr);

        // 1 2 3 4 5

        StringBuilder stringBuilder = new StringBuilder();

        int start = 0;
        int end = nArr.length - 1;

        for (int i = 0; i < mArr.length; i++) {
            stringBuilder.append(binarySearch(nArr, mArr[i], start, end) + "\n");
        }

        System.out.println(stringBuilder.toString());

    }

    private static int binarySearch(int[] nArr, int target, int start, int end) {
        if (start > end) return 0;
        int mid = (start + end) / 2;

        if (nArr[mid] == target) {
            return 1;
        } else if (target < nArr[mid]) {
            end = mid - 1;
            return binarySearch(nArr, target, start, end);
        } else {
            start = mid + 1;
            return binarySearch(nArr, target, start, end);
        }
    }
}
