package ua.kpi.flux;

import java.util.stream.Stream;
import reactor.core.publisher.Flux;

public class FromStream {

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5));
    flux.subscribe(System.out::println);
  }
}
