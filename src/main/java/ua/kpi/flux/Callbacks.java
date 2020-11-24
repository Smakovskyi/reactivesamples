package ua.kpi.flux;

import reactor.core.publisher.Flux;

public class Callbacks {

    public static void main(String[] args) {
      Flux//.fromArray(new Integer[] { 1, 2, 3})
          .error(new IllegalArgumentException())
          .doOnComplete( () -> { System.out.println("Operation completed."); } )
          .doOnError(System.out::println)
          .doOnEach( item -> System.out.println("Item " + item.getType()
              + " " + (item.hasValue() ? item.get() : item.getThrowable()) ))
          .doOnNext( item -> System.out.println("Next item " + item))
          .doOnSubscribe( subscription -> System.out.println("On subscribe") )
          .doOnTerminate( () -> System.out.println("Termination event"))
          .subscribe(System.out::println);

    }

}
