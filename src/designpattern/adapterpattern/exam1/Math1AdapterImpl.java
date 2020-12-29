package designpattern.adapterpattern.exam1;

// Class Adapter (inheritance 를 이용한다)
public class Math1AdapterImpl extends Math1 implements Math1Adapter {

    @Override
    public Float twiceOf(Float f) {
        return (float) twice(f.doubleValue());
    }

    @Override
    public Float halfOf(Float f) {
        return (float) Math1.half(f.doubleValue());
    }
}
