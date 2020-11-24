package ua.kpi.flux.transformations;

import static ua.kpi.flux.AsynchronousCreate.delay;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class DelaySequence {

  public static void main(String[] args) {
    Flux.range(0,10)
        .doOnSubscribe((subscription) -> System.out.println("On Subscribe"))
        .delayElements(Duration.ofSeconds(1))
        .delaySequence(Duration.ofSeconds(5))
        .subscribe(System.out::println);
    delay(15);
  }

}
