package ua.kpi.flux.terminate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class MyArrayList extends ArrayList {

}

public class Collect {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("1", "2", "3");
    Mono<List<String>> listMono = stringFlux.collect(Collectors.toList());
    System.out.println(listMono.block());

    stringFlux = Flux.just("1", "2", "3");
    listMono = stringFlux.collect( MyArrayList::new, (col, el) -> col.add(el));
    System.out.println(listMono.block());
  }
}
