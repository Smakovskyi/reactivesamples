package ua.kpi.flux.combine;

import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Join {

  public static void main(String[] args) {
    Flux<Integer> evenNumbers = Flux.just( 1, 3, 5 )
        .delayElements(Duration.ofMillis(100));

    Flux<Integer> oddNumbers = Flux.just( 2, 4, 6 )
        .delayElements(Duration.ofMillis(100));

    Flux<Integer> join = evenNumbers.join(oddNumbers,
        leftEl -> Mono.just(1)
            .delayElement(Duration.ofMillis(150))
        , rightEl -> Mono.just(1)
            .delayElement(Duration.ofMillis(150))
        , (l, r) -> l + r);
    join.subscribe(System.out::println);
    join.blockLast();
  }
}
