package designpattern.adapterpattern.exam1;

public class Math1AdapterTestDriver {
    public static void main(String[] args) {
        Math1Adapter math1Adapter = new Math1AdapterImpl();

        System.out.println(math1Adapter.twiceOf(100f));
        System.out.println(math1Adapter.halfOf(100f));

    }
}
