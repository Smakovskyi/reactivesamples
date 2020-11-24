package ua.kpi.flux.transformations;

import java.util.function.Consumer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class Cache {
  static int val;
  public static void main(String[] args) {
    //int val[] = new int[1];
    Consumer<FluxSink<Integer>> consumer = (sink) -> {
      for(int i = 0; i < 5; i ++){
        sink.next( val++ );
      }
    };

    Flux<Integer> integerFlux = Flux.create(consumer);
    Flux<Integer> cache = integerFlux.cache();
    integerFlux.subscribe(System.out::println);
    System.out.println("=======");
    cache.subscribe(System.out::println);
    System.out.println("=======");
    cache.subscribe(System.out::println);
  }

}
