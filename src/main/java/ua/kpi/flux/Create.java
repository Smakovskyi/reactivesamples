package ua.kpi.flux;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Create {

  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1,2,3,4,5);

    Consumer<FluxSink<Integer>> consumer = (sink) -> list.forEach( (val) -> sink.next(val));
    Consumer<FluxSink<Integer>> secondConsumer = new Consumer<FluxSink<Integer>>() {
      @Override
      public void accept(FluxSink<Integer> integerFluxSink) {
        integerFluxSink.next(1);
        integerFluxSink.next(2);
        integerFluxSink.complete();
      }
    };
    Flux<Integer> integerFlux = Flux.create(consumer);
    integerFlux.subscribe(System.out::println);

    Flux<Integer> secondFlux = Flux.create(secondConsumer);
    secondFlux.subscribe( System.out::println );
  }
}
