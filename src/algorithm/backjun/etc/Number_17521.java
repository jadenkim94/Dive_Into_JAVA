package algorithm.backjun.etc;
/*
문제
국제자본부동산회사(ICPC)는 바이트 코인(Byte Coin)에 자금을 투자하고 있다. 바이트 코인은 김박사가 만든 가상 화폐이다.
실제로는 바이트 코인 가격을 예상할 수 없지만 이 문제에서는 바이트 코인 가격 등락을 미리 정확히 예측할 수 있다고 가정하자.

우리는 1일부터 n일까지 n일 동안 그림 1과 같이 바이트 코인의 등락을 미리 알 수 있으며 우리에게는 초기 현금 W가 주어져 있다.

요일 수 n, 초기 현금 W, 1일부터 n일까지 각 요일의 바이트 코인 가격이 주어질 때,
n일 날 보유하고 있는 모든 코인을 매도할 때 보유하게 될 최종 현금의 최댓값을 출력하는 프로그램을 작성하시오.

입력
입력은 표준입력을 사용한다. 첫 번째 줄에 요일 수를 나타내는 양의 정수 n과 초기 현금 W(1 ≤ n ≤ 15, 1 ≤ W ≤ 100,000)가 주어진다.
다음 n 개의 줄에서, i번째 줄은 i일의 바이트 코인 가격을 나타내는 정수 si가 주어진다(1 ≤ si ≤ 50).

출력
출력은 표준출력을 사용한다. n일 날 보유하고 있는 모든 코인을 매도할 때 가지고 있는 현금의 최댓값을 한 행에 출력한다.
 비록 초기 현금 W는 그렇게 크지 않지만 최종 현금은 매우 커질 수 있음에 주의하자.
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
10 24
5
7
5
4
2
7
8
5
3
4
 */
public class Number_17521 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        long initialCpital = sc.nextInt();
        ArrayList<Integer> priceChart = new ArrayList<>();
        long coin = 0;

        for(int i = 0 ; i < days; i++){
            priceChart.add(i, sc.nextInt());
        }

        for(int i = 0 ; i < priceChart.size()-1; i++){
            if(priceChart.get(i) < priceChart.get(i+1)){ // 다음 날 더 비싸면 사야함.
                if(initialCpital >= priceChart.get(i)){  // 가지고있는 현금이 코인가격보다 높은경우
                    coin += initialCpital/priceChart.get(i);
                    initialCpital %= priceChart.get(i);
                }
            } else if (priceChart.get(i) > priceChart.get(i+1)){ // 다음 날 더 싸다면 팔아야함
                initialCpital += coin * priceChart.get(i);
                coin = 0;
            }
        }

        initialCpital += coin * priceChart.get(priceChart.size()-1);
        System.out.println(initialCpital);

    }
}
