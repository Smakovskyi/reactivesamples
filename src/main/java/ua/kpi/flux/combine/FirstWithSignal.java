package ua.kpi.flux.combine;

import java.time.Duration;
import java.util.Arrays;
import reactor.core.publisher.Flux;

public class FirstWithSignal {

  public static void main(String[] args) {
    Flux<Integer> delayed100 = Flux.just(1, 2, 3, 4, 5)
        .delayElements(Duration.ofMillis(500));
    Flux<Integer> delayed200 = Flux.just(10, 20, 30, 40, 50)
        .delayElements(Duration.ofMillis(600));
    Flux<Integer> first = Flux.firstWithSignal(Arrays.asList(delayed100, delayed200));
    first.subscribe(System.out::println);
    first.blockLast();
  }
}
