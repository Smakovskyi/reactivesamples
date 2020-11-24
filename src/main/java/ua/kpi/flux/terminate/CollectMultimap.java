package ua.kpi.flux.terminate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CollectMultimap {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("one", "two", "three", "four", "five");

    Mono<Map<Integer, Collection<String>>> mapMono = stringFlux.collectMultimap(String::length);
    System.out.println(mapMono.block());
    stringFlux.collectMultimap(x->x, String::length);
    System.out.println(mapMono.block());
  }
}
