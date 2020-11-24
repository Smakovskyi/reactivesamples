package ua.kpi.flux.special;

import reactor.core.publisher.Flux;

public class Retry {

  static int flag = 0;

  public static void main(String[] args) {
    Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6)
        .map( x-> {
          if(x < 4 || flag++ > 0){
             return x;
          }else{
             throw new RuntimeException();
          }
        })
        .retry();
    flux.subscribe(System.out::println);
    flux.blockLast();

  }
}
