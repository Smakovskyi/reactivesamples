package ua.kpi.flux;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import ua.kpi.flux.ParallelCreate.ActionHolder;

public class AsynchronousCreate {


  public static int delay(int seconds)  {
    try { Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) { e.printStackTrace();}
    return seconds;
  }

  public static void main(String[] args)  {
    ActionHolder actionHolder = new ActionHolder();
    Consumer<FluxSink<Integer>> emitter = sink->{
      Consumer<Integer> consumer = val -> sink.next(val);
      actionHolder.consumer = consumer;
    };
    Flux<Integer> integerFlux = Flux.create(emitter);
    integerFlux.subscribe( item -> { System.out.println( item + " " + Thread.currentThread().getName() );
    });
    IntStream.range(0,100).parallel().forEach( item ->{
      delay(1);
      System.out.println("accepting " + item + " " + Thread.currentThread().getName());
      actionHolder.consumer.accept(item);});
  }

}
