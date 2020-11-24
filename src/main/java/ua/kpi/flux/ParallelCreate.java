package ua.kpi.flux;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class ParallelCreate {
  static class ActionHolder {
   public Consumer<Integer> consumer;
  }
  public static void main(String[] args) throws Exception {
    ActionHolder actionHolder = new ActionHolder();

    Consumer<FluxSink<Integer>> emitter = sink->{
      Consumer<Integer> consumer = val -> sink.next(val);
      actionHolder.consumer = consumer;
    };

    Flux<Integer> integerFlux = Flux.create(emitter);
    integerFlux.subscribe(System.out::println);

    actionHolder.consumer.accept(1000);
    IntStream.range(0,100).parallel().forEach(actionHolder.consumer::accept);
  }
}
