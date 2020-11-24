package ua.kpi.flux.transformations;

import static java.lang.Thread.sleep;

import reactor.core.publisher.Flux;

public class Repeat {

  static int val = 0;

  public static void main(String[] args) throws InterruptedException {
    Flux<Integer> flux = Flux.just(1, 2, 3)
        .repeat(2);
    flux.subscribe(System.out::println);
    flux.blockLast();
    System.out.println("=============");
    sleep(1);
    flux = Flux.just(1, 2, 3)
        .repeat(()-> val++ < 5);
    flux.subscribe(System.out::println);
    sleep(2);
  }
}
