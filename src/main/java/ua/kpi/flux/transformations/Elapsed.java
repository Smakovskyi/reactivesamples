package ua.kpi.flux.transformations;

import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public class Elapsed {

  public static void main(String[] args) {
    Flux<Tuple2<Long, Integer>> elapsed = Flux.just(1, 2, 3, 4, 5)
        .delayElements(Duration.ofMillis(50))
        .elapsed();
    elapsed
        .subscribe(System.out::println);
    elapsed.blockLast();
  }
}
