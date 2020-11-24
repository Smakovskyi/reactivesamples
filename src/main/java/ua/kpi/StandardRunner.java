package ua.kpi;


import java.util.Collections;
import java.util.List;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class OurRunnable implements Runnable{
    public void run(){
      System.out.println("Hello");
    }
}

public class StandardRunner {


  public static void main(String[] args) {
    //List.of(1).stream();

    Runnable first = new OurRunnable();
    first.run();


    Runnable second = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello");
      }
    };

    Runnable third = () -> {System.out.println("Hello");};

    Function<Integer,Integer>  func = (param) -> Integer.bitCount(param);
    System.out.println( func.apply(33));
    System.out.println(func.andThen( ( x)->x*2).apply(33));
    Predicate<Integer> odd = (val) -> val%2 != 0;
    System.out.println(odd.test(-3));

    BiFunction<Integer,Integer,Integer> comparator = Integer::compare;
    BiFunction<Integer,Integer,Integer> secondComparator = (x,y)->Integer.compare(x,y);
    BiFunction<Integer,Integer,Integer> thirdComparator = Integer::compareTo;

    Supplier<String> supplier = () -> "Hello World";
    System.out.println(supplier.get());
    Consumer<Integer> consumer = System.out::println;
    Consumer<Integer> consumerTwo = x -> System.out.println(x);
    consumerTwo.accept(100500);

    Callable<Integer> callable = () -> 2;
    try {
      System.out.println(callable.call());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
