package ua.kpi.flux.terminate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CountDefault {

  public static void main(String[] args) {
    Mono<Long> count = Flux.just("one", "two", "three", "four", "five")
        .count();
    count.subscribe(System.out::println);
    Flux<Object> objectFlux = Flux.empty()
        .defaultIfEmpty(100);
    System.out.println(objectFlux.blockLast());
  }
}
