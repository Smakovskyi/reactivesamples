package ua.kpi.flux.special;

import reactor.core.publisher.Flux;

public class Checkpoint {

  public static void main(String[] args) {
    Flux<String> stringFlux = Flux.just("1", "2", "3");
    try {
      stringFlux
          .map(str -> {
            throw new RuntimeException();
          })
          .checkpoint()
          .subscribe(System.out::println);
    }catch (Exception ex){
      ex.printStackTrace();
    }
    try {
      stringFlux = Flux.just("1", "2", "3");
      stringFlux
          .map(str -> {
            throw new RuntimeException();
          })
          .checkpoint("Hello checkpoint")
          .subscribe(System.out::println);
    }catch(RuntimeException ex){
      ex.printStackTrace();
    }
    //try {
      stringFlux = Flux.just("1", "2", "3");
      stringFlux
          .map(str -> {
            throw new RuntimeException();
          })
          .checkpoint("Funny checkpoint", true)
          .subscribe(System.out::println);
    //}catch(RuntimeException ex){
    //  ex.printStackTrace();
    //}


  }
}
