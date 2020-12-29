package designpattern.adapterpattern.exam2;

public class SocketAdapterTestDriver {
    public static void main(String[] args) {

        SocketAdapter socketAdapter = new SocketAdapterImpl();

        Volt volt = socketAdapter.get110Volt();

        System.out.println(volt.getVolts());

    }
}
