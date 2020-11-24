package ua.kpi.flux.combine;

import reactor.core.publisher.Flux;

public class Merge {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.just(1, 3, 5);
    Flux<Integer> oddNumbers = Flux.just(2, 4);
    Flux<Integer> integerFlux = Flux.merge(evenNumbers, oddNumbers);
    integerFlux.subscribe(System.out::println);
    integerFlux = Flux.merge( 2, evenNumbers, oddNumbers);
    integerFlux.blockLast();
  }

}
