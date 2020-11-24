package ua.kpi.flux.terminate;

import reactor.core.publisher.Flux;

public class DistinctUntilChanged {

  public static void main(String[] args) {
    Flux<Integer> distinct = Flux.just(1, 1, 2, 2, 1, 1, 3, 3, 2, 2)
        .distinctUntilChanged();
    distinct.subscribe(System.out::println); //1, 2, 1, 3, 2
    distinct.blockLast();
    distinct = Flux.just(1, 1, 4, 4, 3, 3, 4, 4, 5, 6)
        .distinctUntilChanged(key -> key % 3);
    distinct.subscribe(System.out::println); // 1,3,4,5,6
  }
}
