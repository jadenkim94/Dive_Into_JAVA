package algorithm.programmers;

public class 최대공약수 {
    public static void main(String[] args) {
        int a = 12;
        int b = 8;
        System.out.println(getGCD(a, b));

        // 최소공배수 =  a * b / GCD
        System.out.println(a * b / getGCD(a,b));

    }

    public static int getGCD(int a, int b){ // a > b
        if ( a < b ){
            int tmp = a;
            a = b;
            b = tmp;
        }
        if( a % b == 0)
            return b;
        return getGCD(b, a%b);
    }
}
