package ua.kpi.flux.transformations;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class SwitchMap {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("Hello", "world")
        .switchMap(s -> Flux.fromArray(s.split(""))
            .delayElements(Duration.ofMillis(200))
         );
    stringFlux
                .subscribe(System.out::println);
    stringFlux.blockLast();
  }
}
