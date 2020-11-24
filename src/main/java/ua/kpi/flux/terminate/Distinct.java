package ua.kpi.flux.terminate;

import reactor.core.publisher.Flux;

public class Distinct {

  public static void main(String[] args) {
    Flux<Integer> distinct = Flux.just(1, 1, 2, 2, 3, 3)
        .distinct();
    distinct.subscribe(System.out::println);
    distinct.blockLast();
    distinct = Flux.just(1, 1, 2, 2, 3, 3, 4, 4, 5, 6)
        .distinct(key -> key % 3);
    distinct.subscribe(System.out::println);
  }

}
