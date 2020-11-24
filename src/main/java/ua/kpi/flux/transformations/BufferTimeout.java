package ua.kpi.flux.transformations;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import reactor.core.publisher.Flux;

public class BufferTimeout {

  public static void main(String[] args) {
    Flux<Integer>integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Flux<Set<Integer>> setFlux = integerFlux.delayElements(Duration.ofSeconds(1))
        .bufferTimeout(3, Duration.ofSeconds(2), () -> new HashSet<>());
    setFlux.subscribe(System.out::println);
    setFlux.blockLast();

  }

}
