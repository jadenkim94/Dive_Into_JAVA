package effective_java.static_factory_method;

public class FooImpl implements Foo{

    public static Foo getFoo(){
        FooImpl foo = new FooImpl();
        return foo;
    }

    @Override
    public void fooMethod() {
        System.out.println("FooImpl implements FooMethod");
    }
}
