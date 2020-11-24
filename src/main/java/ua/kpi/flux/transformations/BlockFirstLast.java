package ua.kpi.flux.transformations;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class BlockFirstLast {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Integer first = integerFlux.blockFirst();
    System.out.println(first);
    System.out.println(integerFlux.blockLast());
    System.out.println(integerFlux.blockLast(Duration.ofSeconds(1)));
  }

}
