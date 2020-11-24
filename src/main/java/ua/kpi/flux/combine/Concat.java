package ua.kpi.flux.combine;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Concat {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.range(1, 5) // 1, 3, 5,
        .filter(x -> x % 2 == 0);
    Flux<Integer> oddNumbers = Flux.range(1, 5)  //2 4
        .filter(x -> x % 2 > 0);
    Flux<Integer> fluxOfIntegers = Flux.concat(evenNumbers, oddNumbers);
    fluxOfIntegers.subscribe(System.out::println); // 2 4 1 3 5
    fluxOfIntegers.blockLast();
  }
}
