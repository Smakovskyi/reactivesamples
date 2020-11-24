package ua.kpi.flux.transformations;

import reactor.core.publisher.Flux;

public class DoOnEach {

  public static void main(String[] args) {
    Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5})
        .doOnEach( integerSignal -> {
          System.out.println( "" + integerSignal.getType() + " " + integerSignal.get()); } )
        .subscribe(System.out::println);
  }
}
