package ua.kpi.flux.special;

import reactor.core.publisher.Flux;

public class Materialize {

  public static void main(String[] args) {
    Flux.just("1","2","3")
        .materialize()
        .subscribe(System.out::println);
    Flux.just("1","2","3")
        .materialize()
        .dematerialize()
        .subscribe(System.out::println);
  }
}
