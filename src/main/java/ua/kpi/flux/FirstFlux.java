package ua.kpi.flux;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

public class FirstFlux {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("1", "2", "3");
    Flux<String> fluxFromPublisher = Flux.from(stringFlux);
    fluxFromPublisher.subscribe(System.out::println);

    Publisher<String> publisher= (subscriber) -> {
        subscriber.onNext("one");
        subscriber.onNext("two");
        subscriber.onComplete(); };

    fluxFromPublisher = Flux.from(publisher);
    fluxFromPublisher.subscribe(System.out::println);


  }

}
