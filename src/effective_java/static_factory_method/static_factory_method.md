# 생성자 대신 static 팩토리 메소드를 고려해 보자.

객체 인스턴스를 생성할 때, 기본적으로 사용하는 방법은 생성자를 사용하여 만드는 것이다.

```java
public class A {
    String sign = "This is A";
    public A(){}
}
public class Tester {
    public static void main(String[] args) {

        A a = new A();
        System.out.println(a.sign); // -> This is A 
        
    }
}
```

그렇지만, 이 방법 이외에 static 팩토 를 사용할 수 도 있다.

```java
public class B {
    String sign = "This is B";

    public static B getB(){
        return new B();
    }
}

public class Tester {
    public static void main(String[] args) {

        B b = B.getB();
        System.out.println(b.sign); // -> This is B

    }
}
```

그렇다면 static 팩토리를 활용하면 얻을 수 있는 것들은 무엇일까?

### :gift:1. 직관적인 Naming 이 가능하다.

```java
public class A {
    String sign = "This is A";
   
    public A(String sign){
        this.sign = sign;
    }
}
```
위와 같이 생성자의 경우 반드시 클래스 이름과 동일한 이름을 가져야 한다. 
하지만, static 팩토리를 활용하면 일반적인 메소드임으로 조금 더 직관적인 
네이밍을 할 수 있다. 
```java
public class B {
    String sign = "This is B";

    public static B getB_WithSign(String sign){
        B b = new B();
        b.sign = sign;
        return b;
    }
}


public class Tester {
    public static void main(String[] args) {

        A a2 = new A("A with Sign");
        System.out.println(a2.sign);  // --> A with Sign

        B b2 = B.getB_WithSign("B with Sign");
        System.out.println(b2.sign);  // --> B with Sign

    }
}
```

### :gift:2. 반드시 새로운 인스턴스를 생성할 필요가 없다.
new 키워드와 생성자를 통해 인스턴스를 생성하면 새 인스턴스 가 생성된다. 
하지만 static 팩토리를 활용하면, 반드시 새로운 인스턴스를 생성하지 않고, 만들어진 인스턴스를 return 하는 방법도 사용할 수 있다.

```java

public class B {

    private static final B B_ROOT = getB_WithSign("ROOT B");

    public static B getB_WithSign(String sign){
        B b = new B();
        b.sign = sign;
        return b;
    }

    public static B getRootB(){
        return B_ROOT;
    }
}


public class Tester {
    public static void main(String[] args) {

        B b3 = B.getRootB();
        System.out.println(b3.sign); // -> ROOT B

    }
}

```

### :gift:3. 반환타입의 하위타입 인스턴스를 반환할 수 있다. 

static 팩토리 메소드에서 리턴하는 값을 하위타입의 인스턴스로 리턴할 수 있다.
이 방법을 사용하면 리턴 타입은 인터페이스로 한 후, 해당 인터페이스의 구현체 인스턴스를 리턴할 수 있다. 
이렇게 하면 **인터페이스의 구현체는 API로 노출 시키지 않고, 구현체 인스턴스를 만들수 있게 할 수 있다.**
 
 ```java
public interface Foo {

    void fooMethod();

    static Foo getFoo(){
        return FooImpl.getFoo();
    }

}


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




    public class Tester {
        public static void main(String[] args) {
            Foo.getFoo().fooMethod(); // -> FooImpl implements FooMethod
    }
}
       
```

### :gift:4. 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.

다음은 java.util 의 EnumSet 코드의 일부이다
```java
public static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) {
        Enum<?>[] universe = getUniverse(elementType);
        if (universe == null) {
            throw new ClassCastException(elementType + " not an enum");
        } else {
            return (EnumSet)(universe.length <= 64 ? new RegularEnumSet(elementType, universe) : new JumboEnumSet(elementType, universe));
        }
    }
```

반환 부분을 보면 enum 의 element 갯수가 64개 이하인 경우 RegularEnumSet 타입을 반한하고, 초과인 경우  JumboEnumSet 타입을 반환하는 것을 확인할 수 있다.