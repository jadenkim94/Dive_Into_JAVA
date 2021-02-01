package java8.java8interface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
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
        System.out.println("=====");
        //method reference 를 활용하면
        names.forEach(System.out::println);
        /*
        jaden
        son
        park
        */

        System.out.println("=====");
        System.out.println("=====");

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

        System.out.println("=====");
        System.out.println("=====");

        List<String> startsWithJ = names.stream().map(String::toUpperCase)
                .filter(n -> n.startsWith("J"))
                .collect(Collectors.toList());
        startsWithJ.forEach(System.out::println);
        // -> JADEN


        System.out.println("=====");
        System.out.println("=====");


        names.removeIf(n -> n.startsWith("j"));
        names.forEach(System.out::println);
        /*
        son
        park
        */

        System.out.println("=====");
        System.out.println("=====");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());
        names.forEach(System.out::println);
        /*
        son
        park
        */


    }
}
