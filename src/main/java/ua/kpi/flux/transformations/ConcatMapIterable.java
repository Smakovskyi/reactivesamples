package ua.kpi.flux.transformations;

import java.util.stream.Collectors;
import reactor.core.publisher.Flux;

public class ConcatMapIterable {

  public static void main(String[] args) {
    Flux<Character> charFlux = Flux.just("Hello", "world")
        .concatMapIterable(
            str -> str.chars().boxed().collect(Collectors.toList()))
        .map( i -> Character.valueOf((char)i.intValue()));
    charFlux.subscribe(System.out::println);
    charFlux.blockLast();
  }

}
