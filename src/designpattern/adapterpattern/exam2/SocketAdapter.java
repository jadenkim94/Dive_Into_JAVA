package designpattern.adapterpattern.exam2;

// 구현된 인터페이스를 필요에 따라 사용할 수 있게끔 만든 adapter interface
public interface SocketAdapter {

    Volt get120Volt();

    Volt get110Volt();

    Volt get200Volt();

}

