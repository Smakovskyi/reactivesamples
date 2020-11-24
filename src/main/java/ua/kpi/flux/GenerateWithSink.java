package ua.kpi.flux;

import java.util.Iterator;
import reactor.core.publisher.Flux;

public class GenerateWithSink {
  public static int current = 0;

  static Integer getNext(){
    return ++current;
  }

  public static void main(String[] args) {
    int arr[] = new int[1];

    Flux<Object> generatedFlux = Flux.generate((sink) -> sink.next(getNext()));
    generatedFlux.take(10).subscribe( System.out::println );
  }

}
