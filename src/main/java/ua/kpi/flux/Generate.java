package ua.kpi.flux;

import java.util.concurrent.Callable;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

public class Generate {

  public static void main(String[] args) {
    Flux<Object> generatedFlux = Flux.generate(() ->1, (state, sink) ->
    {
      sink.next(state);
      return state + 1;});

    generatedFlux.take(10).subscribe( System.out::println );

    Flux.generate(
        () -> Tuples.of(0, 1),
        (state, sink) -> {
          sink.next(state.getT1());
          return Tuples.of(state.getT2(), state.getT1() + state.getT2());
        }).take(5).subscribe(System.out::println);

  }

}
