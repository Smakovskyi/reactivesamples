package ua.kpi.flux.transformations;

import static ua.kpi.flux.AsynchronousCreate.delay;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AllAny {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Mono<Boolean> allEven = integerFlux.all(item -> item % 2 == 0);
    System.out.println(allEven.blockOptional());
    integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Mono<Boolean>  allGreaterThanZero = integerFlux.all(item -> item > 0);
    System.out.println(allGreaterThanZero.block());
    integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Mono<Boolean> anyGreaterThenZero = integerFlux.any(item -> item > 0);
    System.out.println(anyGreaterThenZero.block());
    Flux<Integer> emptyFlux = Flux.empty();
    anyGreaterThenZero = emptyFlux.any(item -> item > 0);
    System.out.println(anyGreaterThenZero.blockOptional());
    System.out.println(emptyFlux.all(item -> item > 0).block());
  }

}
