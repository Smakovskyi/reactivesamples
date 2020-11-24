package ua.kpi.flux.terminate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CollectListMap {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("one", "two", "three", "four", "five");
    Mono<List<String>> listMono = stringFlux.collectList();
    System.out.println(listMono.block());
    Mono<Map<Integer, String>> mapMono = stringFlux.collectMap(String::length);
    System.out.println(mapMono.block());
    Mono<Map<Integer, Collection<String>>> multiMapMono = stringFlux
        .collectMultimap(String::length, x -> x );
    System.out.println(multiMapMono.block());
  }

}
