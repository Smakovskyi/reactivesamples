package ua.kpi.flux.transformations;

import java.util.List;
import reactor.core.publisher.Flux;

public class BufferUntilChanged {

  public static void main(String[] args) {
    Flux<Integer> integerFlux = Flux.fromArray(new Integer[]{1, 2, 3, 3, 4, 5, 6, 7, 8});
    Flux<List<Integer>> buffers = integerFlux.bufferUntil(item -> item % 3 == 0);
    buffers.subscribe(System.out::println );
    System.out.println("==============");
    integerFlux = Flux.fromArray(new Integer[]{1, 1, 3, 3, 4, 5, 5});
    buffers = integerFlux.bufferUntilChanged();
    buffers.subscribe(System.out::println );
  }
}
