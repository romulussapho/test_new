package ro.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.prefs.PreferenceChangeEvent;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

/*        public interface Predicate<T> {
            boolean test(T t);
        }

        public interface Function<T,R> {
            R apply(T t);
        }

        public interface BinaryOperator<T> {
            T apply(T left, T right);
        }

        public interface Consumer<T> {
            void accept(T t);
        }

        public interface Supplier<T> {
            T get();
        }*/



        Predicate<Integer> odd = n -> n % 2 != 0;

        Callable<Integer> callme = () -> 42;
        Test<String> test = () -> "Testing interface";
        System.out.println(test.test());

        Function<Double, Double> f1 = n -> n * n;

        Function<Integer, Double> f2 = n -> {
            System.out.printf("Calculate square root [%d]\n", n); return Math.sqrt(n); };

        Function<Integer, String> intToBinary = n -> Integer.toBinaryString(n);
        Function<Double, String> longToBinary = n -> Double.toHexString(n);
        Function<Integer, String> toHex = n -> Integer.toHexString(n);



        System.out.println(f1.compose(f2).apply(2));
        System.out.println(intToBinary.apply(-4));
        System.out.println(toHex.apply(10));


        List<Integer> results = IntStream.range(1, 30).filter(n -> n%2 != 0).boxed().collect(Collectors.toList());

        results.stream().forEach(n -> System.out.print(n + " "));

        System.out.println("\n" + results.stream().max((a, b) -> { if( a == b) return 0; if (a > b) return 1;  return -1; } ));
        System.out.println("Operation: " + IntStream.range(1,10).filter(n -> n%2 != 0).average());

        byte val = -0b0111_0000;
        int v1 = 0xAF;
        System.out.println(val + "  " + v1);

        Optional<Integer> opt = Optional.empty();

        opt.ifPresent(x -> System.out.println(x));
    }
}

interface Test<R> {
    R test();
}
