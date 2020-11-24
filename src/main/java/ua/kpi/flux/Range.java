package ua.kpi.flux;

import reactor.core.publisher.Flux;

public class Range {

  public static void main(String[] args) {
    Flux.range(0,20)
        .subscribe(System.out::println);
  }

}
