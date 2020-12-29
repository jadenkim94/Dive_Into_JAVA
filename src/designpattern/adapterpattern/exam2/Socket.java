package designpattern.adapterpattern.exam2;


// 이미 구현되어 있는 인터페이스
public class Socket {

    public Volt getVolt(){
        return new Volt(120);
    }
}
