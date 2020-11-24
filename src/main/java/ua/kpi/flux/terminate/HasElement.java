package ua.kpi.flux.terminate;

import java.util.List;
import java.util.stream.Collectors;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HasElement {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("1", "2", "3");
    Mono<Boolean> booleanMono = stringFlux.hasElement("1");
    System.out.println(booleanMono.block());
    stringFlux.hasElements();
    System.out.println(booleanMono.block());
  }
}
