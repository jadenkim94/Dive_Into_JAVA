#Java Reflection 

###리플랙션이란 ? 
구체적인 클래스 타입을 알지 못하는 상황에서 해당 클래스의 타입과 필드, 메소드들에 접근할 수 있도록 해주는 API 이다.

#### 어떻게 동작하는가? 
리플랙션의 동작원리를 이해하기 위해서는 우선 클래스 로더 시스템에 대한 이해가 필요하다.  
간단하게 자바 프로그램을 실행하는 과정에 대해서 상기해보자  
1. 우선 작성한 소스코드를 (.java 파일) javac 컴파일러를 통해 바이트코드(.class 파일)로 변환 시켜놓아야 할 것이다.  
2. 클래스 로더 시스템의 로딩, 링크, 초기화 과정에서 프로그램의 실행을 위해 .class 파일의 바이트코드를 읽어 메모리에 올리는 과정이 진행 될 것이다.  
3. 그리고 Execution Engine 에 의해 동작하게 될 것이다. 참고로 Execution Engine 에 의해 동작한다 함은 바이트코드를 OS 가 이해하도록 인터프리팅하여 동작하게 하는 것을 의미하고 이 과정에서 JIT 컴파일러가 사용되는데, 간단하게 언급하면 반복되는 바이트코드를 캐싱하여 반복되는 모든 바이트코드를 매번 번역하지 않고 캐싱해둔 코드를 사용함으로써 속도를 높여주는 역할을 한다. 

앞서 말했듯 리플랙션의 동작원리를 이해하기 위해서는 클래스 로더 시스템에 대해 유심히 살펴보아야 한다.  
클래스 로더 시스템은 세가지 과정으로 이루어지는데  
1. 클래스를 읽어오는 로딩과정 
2. 래퍼런스를 연결하는 링크과정
3. static 변수에 값을 할당하는 초기화과정


으로 이루어져 있다.  
클래스 로딩과정에서 .class 파일의 바이트 코드를 읽어 JVM 메모리의 메소드영역에 클래스 수준의 정보(클래스 이름(FQCN), 부모 클래스 이름, 메소드, 변수 ..)를 저장하게 되고
로딩이 끝나면 해당 클래스 타입의 Class 객체를 생성하여 JVM 메모리의 힙영역에 저장하게 된다.  
바로 이때 생성된 해당 클래스 타입의 Class 인스턴스를 통해 로딩된 클래스의 타입과 메소드 변수에 접근이 가능해 지는 것이다. 

#### 왜 필요한가? 
구체적인 클래스 타입을 알지 못하는 상황 해당 클래스의 타입과 필드, 메소드들에 접근하기 위해서이다.  
그렇다면 구체적인 클래스 타입을 알지 못하는 상황은 어떠한 상황인가에 대해서 생각해 볼 필요가 있다.  
프레임워크를 제작하는 개발자가 프레임워크를 사용하는 개발자가 만들 클래스 타입을 유추할 수 있을까?  
스프링프레임워크는 어노테이션을 통해 Dependency Injection 을 해주는데 과연 스프링프레임워크 개발자들은 내가 오늘 작성할 클래스와 그 클래스에 주입될 클래스를 알고 있었을까?  
그렇지 않다. 그들은 어떤 타입의 클래스가 주입될지는 알지 못한다. 히지만 리플랙션을 활용하면 이러한 일들이 가능하다.  
코드를 보며 간단하게 살펴보도록 하자. 
(작성한 코드는 백기선님의 '더 자바, 코드를 조작하는 다양한 방법'강의에서 참조하였다. )  
```java

public class ContainerService {

    public static <T> T getObject(Class<T> classType){
        T instance = createInstance(classType); 
        Arrays.stream(classType.getDeclaredFields()).forEach(f -> { // 3. 어떠한 타입의 Class 인스턴스를 통해 해당 타입의 필드들을 돌면서 
            if(f.getAnnotation(Inject.class) != null){ // 4. 필드에 @Inject 어노테이션이 있다면 
                Object fieldInstance = createInstance(f.getType()); // 5. 그 필드의 타입인스턴스를 리턴받고 
                f.setAccessible(true); // 6. 해당 필드의 접근을 가능하게 하고 
                try {
                    f.set(instance, fieldInstance); // 7. 해당 필드에 5번 과정에서 리턴받은 인스턴스를 주입한 후 
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return instance; // 8. DI가 완료된 어떠한 타입의 인스턴스를 반환한다. 
    }

    private static <T> T createInstance(Class<T> classType) { // 1. 어떠한 타입의 Class 인스턴스를 받는다. 
        try {
            return classType.getConstructor(null).newInstance(); // 2. 해당타입의 생성자를 활용해 해당 타입인스턴스를 만들어 리턴한다. 
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
```







  
