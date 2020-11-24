package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.math.MathFlux;

public class As {

  public static void main(String[] args) {
    Mono<String> stringMono = Flux.range(1, 10)
        .map(i -> i + 2)
        .map(i -> i * 10)
        .as(MathFlux::sumInt)
        .map(isum -> "sum=" + isum);
    stringMono.subscribe(System.out::println);
  }
}
