package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

public class GroupBy {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6);
    Flux<GroupedFlux<Integer, Integer>> groupedFlux = integerFlux.groupBy(i -> i % 2);
    groupedFlux.blockFirst().subscribe( System.out::println);
  }
}
