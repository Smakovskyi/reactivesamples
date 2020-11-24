package ua.kpi.flux;

import reactor.core.publisher.Flux;

public class Deffer {

  public static void main(String[] args) throws Exception {
    Flux<Long> defer = Flux.defer(() -> Flux.just(System.currentTimeMillis()))
        .cache();
    Thread.sleep(10000);
    System.out.println(defer.blockLast());
    System.out.println(System.currentTimeMillis());
    Thread.sleep(10000);
    System.out.println(defer.blockLast());
    System.out.println(System.currentTimeMillis());
  }
}
