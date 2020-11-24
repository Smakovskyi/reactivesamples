package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;

public class Map {

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.just(1, 2, 3)
        .map(s -> s + 1);
    flux.subscribe(System.out::println);
    flux.blockLast();
  }

}
