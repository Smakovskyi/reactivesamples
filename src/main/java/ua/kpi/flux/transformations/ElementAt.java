package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ElementAt {

  public static void main(String[] args) {
    Mono<Integer> element = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5})
        .elementAt(1);

    element.subscribe(System.out::println);
    System.out.println(element.block());
  }
}
