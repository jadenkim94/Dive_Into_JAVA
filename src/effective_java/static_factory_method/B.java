package effective_java.static_factory_method;

public class B {
    String sign = "This is B";

    private static final B B_ROOT = getB_WithSign("ROOT B");

    public static B getB(){
        return new B();
    }

    public static B getB_WithSign(String sign){
        B b = new B();
        b.sign = sign;
        return b;
    }

    public static B getRootB(){
        return B_ROOT;
    }
}
