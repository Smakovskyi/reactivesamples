package ua.kpi.flux;

import java.util.Arrays;
import java.util.List;
import reactor.core.publisher.Flux;

public class Push {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    Flux<Integer> flux = Flux.push((sink) -> list.forEach((val) -> sink.next(val)));
    flux.subscribe(System.out::println);
    flux.blockLast();
  }
}
