package ua.kpi.flux.transformations;

import static ua.kpi.flux.AsynchronousCreate.delay;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class DelayElements {

  public static void main(String[] args) {
    Flux.range(0,10)
        .delayElements(Duration.ofSeconds(1))
        .subscribe(System.out::println);
    delay(15);
  }

}
