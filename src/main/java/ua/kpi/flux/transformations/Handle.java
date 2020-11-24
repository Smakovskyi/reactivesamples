package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;

public class Handle {

  public static void main(String[] args) {

    Flux<Object> flux = Flux.just(1, 2, 3, 4, 5)
        .handle((lastEmitted, sink) -> {
          System.out.println("Emmited " + lastEmitted);
          if (lastEmitted > 3)
            sink.complete();
          else
            sink.next(1);
        });
    flux
        .subscribe(i -> System.out.println("Received :: " + i));
  }
}
