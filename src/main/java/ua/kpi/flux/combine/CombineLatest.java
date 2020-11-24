package ua.kpi.flux.combine;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class CombineLatest {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.range(1, 5) // 1, 3, 5,
        .filter(x -> x % 2 == 0).delayElements(Duration.ofMillis(100));
    Flux<Integer> oddNumbers = Flux.range(1, 5)  //2 4
        .filter(x -> x % 2 > 0).delayElements(Duration.ofMillis(100));
    Flux<Integer> fluxOfIntegers = Flux.combineLatest(evenNumbers, oddNumbers,
        (a, b) -> a + b);
    fluxOfIntegers.subscribe(System.out::println); // 3 5 7 9
    fluxOfIntegers.blockLast();
  }
}
