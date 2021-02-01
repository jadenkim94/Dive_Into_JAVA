#자바8에 추가된 인터페이스 기본 메소드와 스태틱 메소드 
### :sparkles: [Iterable 인터페이스](https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html)
* foreach() 
```java 
         List<String> names = new ArrayList<>();
         names.add("jaden");
         names.add("son");
         names.add("park");
 
         names.forEach(n -> {
             System.out.println(n);
         });
         /*
         jaden
         son
         park
         */
        
         //method reference 를 활용하면
         names.forEach(System.out::println);
         /*
         jaden
         son
         park
         */
```
* spliterator() 
```java
// foreach() 와 유사하지만 쪼갤 수 있는 기능이 있다. 
        Spliterator<String> spliterator = names.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        
        while (spliterator.tryAdvance(System.out::println));
        System.out.println("======");
        while (spliterator1.tryAdvance(System.out::println));
        /*
        son
        park
        ======
        jaden
         */
```
spliterator 을 활용하면, 병행처리를 유용하게 할 수 있을 것이다. 또 한 Stream 의 기반에 spliterator 이 사용되고 있다. 
### :sparkles: [Collection 인터페이스](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
* stream() 
```java
        List<String> startsWithJ = names.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());
        startsWithJ.forEach(System.out::println);
        // -> JADEN
```
collection 이 가지고 있는 elements 들을 stream 으로 만들어 사용할 수 있게 해준다. 
* removeIf()
```java
        names.removeIf(n -> n.startsWith("j"));
        names.forEach(System.out::println);
        /*
        son
        park
        */
```
인자로 넘어온 predicate 를 활용해 해당하는 elements 들을 제거할 수 있다. 


### :sparkles: [Comparator 인터페이스](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)
* reversed()
```java
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
        /*
        son
        park
        */
```
역순으로 정렬을 해준다. 

* thenComparing()
```java
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        // 대소문자 구분없이 문자를 역순으로 정렬한 상태이다. 만약 이 상태에서 또 다른 정렬을 사용하고 싶다면 위 코드를 다음의 코드처럼 수정하면된다.
        // names.sort(compareToIgnoreCase.reversed().thenComparing()); 
        names.forEach(System.out::println);
        /*
        son
        park
        */
```
필요한 경우 다양한 정렬을 순차적으로 이어서 할 수 있다.  