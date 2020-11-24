package ua.kpi.flux.transformations;

import java.util.Arrays;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;

public class FlatMap {

  public static void main(String[] args) {
    Flux.just("1,2,3", "4,5,6")
        .doOnNext(System.out::println)
        .flatMap(i -> Flux.fromIterable(Arrays.asList(i.split(","))))
        .doOnNext(System.out::println)
        .collect(Collectors.toList())
        .subscribe(System.out::println);

    Flux.just(Arrays.asList(1,2,3), Arrays.asList(4,5,6))
        .doOnNext(System.out::println)
        .flatMap(i -> Flux.fromIterable(i))
        .doOnNext(System.out::println)
        .collect(Collectors.toList())
        .subscribe(System.out::println);
  }

}
