package ua.kpi.flux;

import reactor.core.publisher.Flux;

public class Just {

  public static void main(String[] args) {
    Flux<String> just = Flux.just("foo", "bar");
    just.subscribe(System.out::println);

  }
}
