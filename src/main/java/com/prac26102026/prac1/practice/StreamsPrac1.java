package com.prac26102026.prac1.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsPrac1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        String a= names.stream().filter(name -> name.startsWith("B")).toString(); // will not Bod coz
//        The code prints a reference hash instead of "Bob" because stream().filter(...) returns a Stream<String> object, and calling .toString() on a stream gives its object memory address, not the elements inside it.
        String a= names.stream().filter(name -> name.startsWith("B")).findFirst().orElse("No name found");
        System.out.println(a);
        names.stream().forEach(System.out::println);   // to print all names in the list


        // Convert to stream
        Stream<String> nameStream = names.stream();
        System.out.println(nameStream);

        List<String> names1 = Arrays.asList("Alice", "Bob", "Charlie");
        Stream<String> nameStream1 = names.stream();


        String[] namesArray = {"Alice", "Bob", "Charlie"};
        Stream<String> arrayStream = Arrays.stream(namesArray);

        Stream<String> directStream = Stream.of("Alice", "Bob", "Charlie");

    }
    public void printHello() {
        System.out.println("Hello World");
    }
    Runnable r = () -> System.out.println("Hello World");

    public void printHello1() {
        List<String> names = Arrays.asList("Pavan", "Rahul", "Amit");
        names.sort((a, b) -> a.compareTo(b));
        names.sort(String::compareTo);
        System.out.println(names);
    }
}
