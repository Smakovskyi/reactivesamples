package ua.kpi.flux.transformations;

import static ua.kpi.flux.AsynchronousCreate.delay;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DistinctCount {

  public static void main(String[] args) {
    Mono<Long> countMono = Flux.fromArray(new Integer[]{1, 1, 2, 2, 2, 3, 3, 4, 5, 5, 6, 6, 6})
        .distinct()
        .doOnNext(System.out::println)
        .count();
    countMono.subscribe(System.out::println);
    Long block = countMono.block();
    System.out.println(block);
  }
}
