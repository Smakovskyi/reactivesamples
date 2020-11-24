package ua.kpi.flux.transformations;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import reactor.core.publisher.Flux;
import reactor.util.annotation.NonNull;
//import reactor.util.function.Tuple2;
//import reactor.util.function.Tuples;

public class Buffer {
  public static class Tuple<T1,T2>{
    @NonNull
    final T1 t1;
    @NonNull final T2 t2;

    Tuple(T1 t1, T2 t2) {
      this.t1 = Objects.requireNonNull(t1, "t1");
      this.t2 = Objects.requireNonNull(t2, "t2");
    }


    public T1 getT1() {
      return t1;
    }


    public T2 getT2() {
      return t2;
    }

    @Override
    public String toString() {
      return "Tuple{" +
          "t1=" + t1 +
          ", t2=" + t2 +
          '}';
    }
  }

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Flux<List<Integer>> buffer = integerFlux.buffer(2);
    buffer.subscribe( System.out::println );
    integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5});
    Flux<List<Integer>> listFlux = integerFlux.delayElements(Duration.ofSeconds(1))
        .buffer(Duration.ofSeconds(2));
    listFlux.subscribe(System.out::println);
    listFlux.blockLast();
    Flux<Tuple> tupleFlux = integerFlux.delayElements(Duration.ofSeconds(1))
        .buffer(Duration.ofSeconds(2))
        .map(list -> new Tuple(list.size(), list.stream().mapToInt(x -> x).average()));
    tupleFlux.subscribe(System.out::println);
    tupleFlux.blockLast();
  }
}
