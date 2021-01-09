package effective_java.static_factory_method;

public class Tester {
    public static void main(String[] args) {

        A a = new A();
        System.out.println(a.sign);

        B b = B.getB();
        System.out.println(b.sign);

        A a2 = new A("A with Sign");
        System.out.println(a2.sign);

        B b2 = B.getB_WithSign("B with sign");
        System.out.println(b2.sign);

        B b3 = B.getRootB();
        System.out.println(b3.sign);

        Foo.getFoo().fooMethod();

    }
}
