package ua.kpi.flux.special;

import static ua.kpi.flux.AsynchronousCreate.delay;

import java.time.Duration;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class Publish {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5, 6)
        .delayElements(Duration.ofMillis(500));
    //integerFlux.subscribe(val -> System.out.println("first = " + val));
    delay(1);
    ConnectableFlux<Integer> published = integerFlux.publish();
    published.subscribe(val -> System.out.println("second = " + val));
    //published.blockLast();
    delay(2);



  }

}
