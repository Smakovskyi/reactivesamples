package ua.kpi.flux.combine;

import reactor.core.publisher.Flux;

public class ConcatWith {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.just(1, 3, 5);
    Flux<Integer> oddNumbers = Flux.just(2, 4);
    Flux<Integer> fluxOfIntegers = evenNumbers.concatWith(oddNumbers);
    fluxOfIntegers.subscribe(System.out::println); // 1 3 5 2 4
    Flux<Integer> secondFlux = evenNumbers.concatWithValues(10, 20, 30);
    secondFlux.subscribe(System.out::println); //1 3 5 10 20 30
    fluxOfIntegers.blockLast();
  }
}
