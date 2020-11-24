package ua.kpi.flux;

import java.util.Arrays;
import reactor.core.publisher.Flux;

public class FromIterable {

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5));
    flux.subscribe(System.out::println);
    Flux.fromArray(new Integer[] {10, 20, 30, 40, 50})
        .subscribe(System.out::println);
  }
}
