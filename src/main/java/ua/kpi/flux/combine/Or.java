package ua.kpi.flux.combine;

import java.time.Duration;
import java.util.Arrays;
import reactor.core.publisher.Flux;

public class Or {

  public static void main(String[] args) {
    Flux<Integer> delayed500 = Flux.just(1, 2, 3, 4, 5)
        .delayElements(Duration.ofMillis(500));
    Flux<Integer> delayed600 = Flux.just(10, 20, 30, 40, 50)
        .delayElements(Duration.ofMillis(600));
    Flux<Integer> first = delayed500.or(delayed600);
    first.subscribe(System.out::println);
    first.blockLast();
  }
}
