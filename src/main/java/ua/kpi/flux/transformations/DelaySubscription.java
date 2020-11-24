package ua.kpi.flux.transformations;

import static ua.kpi.flux.AsynchronousCreate.delay;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class DelaySubscription {

  public static void main(String[] args) {
    Flux.range(0,10)
        .delayElements(Duration.ofSeconds(1))
        .doOnSubscribe((subscription) -> System.out.println("On Subscribe"))
        .doOnEach(signal -> System.out.println("Signal " + signal.getType() + " " + signal.get()))
        .delaySubscription(Duration.ofSeconds(10))
        .subscribe(System.out::println);
    delay(15);
  }

}
