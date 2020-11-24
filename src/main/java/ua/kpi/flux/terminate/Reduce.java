package ua.kpi.flux.terminate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Reduce {

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
    Mono<Integer> sum = flux.reduce(0, (x, y) -> x + y);
    System.out.println(sum.block());
    sum = flux.reduce( (x, y) -> x + y);
    System.out.println(sum.block());
  }
}
