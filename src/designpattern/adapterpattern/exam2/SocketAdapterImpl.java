package designpattern.adapterpattern.exam2;

// adapter 구현체 (ObjectAdapter 방식)
public class SocketAdapterImpl implements SocketAdapter{

    private Socket socket = new Socket();

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get110Volt() {
        Volt volt = socket.getVolt();
        volt.setVolts(110);
        return volt;
    }

    @Override
    public Volt get200Volt() {
        Volt volt = socket.getVolt();
        volt.setVolts(200);
        return volt;
    }
}
