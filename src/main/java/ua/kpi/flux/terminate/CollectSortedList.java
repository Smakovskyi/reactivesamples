package ua.kpi.flux.terminate;

import java.util.Comparator;
import java.util.List;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CollectSortedList {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("one", "two", "three", "four", "five");
    Mono<List<String>> listMono = stringFlux.collectSortedList();
    System.out.println(listMono.block());
    listMono = stringFlux.collectSortedList(Comparator.comparing(String::length));
    System.out.println(listMono.block());
  }

}
