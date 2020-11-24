package ua.kpi.flux.transformations;


import reactor.core.publisher.Flux;

public class Index {

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
    flux.index()
        .subscribe(System.out::println);

    flux.index((index, value) -> index * 100 + value)
        .subscribe(System.out::println);
  }

}
