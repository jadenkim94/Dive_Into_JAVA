package effective_java.static_factory_method;

public interface Foo {

    void fooMethod();

    static Foo getFoo(){
        return FooImpl.getFoo();
    }

}
