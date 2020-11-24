package ua.kpi.flux.transformations;

import java.time.Duration;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class bufferWhen {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5, 6, 7, 8});
    Flux<Integer> whenCondition = Flux.range(0,20)
        .delayElements(Duration.ofSeconds(2));
    Flux<List<Integer>> buffers = integerFlux.delayElements(Duration.ofSeconds(1))
        .bufferWhen( whenCondition, open -> Mono.delay(Duration.ofSeconds(3)) );
    buffers.subscribe(System.out::println );
    buffers.blockLast();
  }

}
