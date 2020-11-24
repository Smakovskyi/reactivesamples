package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FilterWhen {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.just(1,2,3,4,5)
        .filterWhen( el -> Mono.just( el > 2  ) );
    integerFlux.subscribe( System.out::println );
    integerFlux.blockLast();
  }

}
