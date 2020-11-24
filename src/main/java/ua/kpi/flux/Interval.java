package ua.kpi.flux;

import static ua.kpi.flux.AsynchronousCreate.delay;

import java.time.Duration;
import reactor.core.publisher.Flux;

public class Interval {

  public static void main(String[] args) {
    //Create a Flux that emits long values starting with 0
    // and incrementing at specified time intervals, after
    // an initial delay, on the global timer.
    Flux<Long> intervalFlux = Flux.interval(Duration.ofSeconds(1), Duration.ofSeconds(2))
        .take(5);
    intervalFlux.subscribe(System.out::println);

    System.out.println(intervalFlux.blockLast());
  }

}
