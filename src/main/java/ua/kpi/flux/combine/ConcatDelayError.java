package ua.kpi.flux.combine;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class ConcatDelayError {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.range(1, 5) // 1, 3, 5,
        .filter(x -> x % 2 == 0);
    Flux<Integer> oddNumbers = Flux.range(1, 5)  //2 4
        .filter(x -> x % 2 > 0);
    Flux<Integer> error = Flux.error(new RuntimeException());
    Flux<Integer> fluxOfIntegers = Flux.concatDelayError(evenNumbers, error , oddNumbers);
    fluxOfIntegers
        .doOnError(System.out::println)
        .subscribe(System.out::println); // 2 4 1 3 5
    fluxOfIntegers.blockLast();
  }
}
