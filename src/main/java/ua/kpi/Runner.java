package ua.kpi;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Runner {

  public static void main(String[] args) {
    Observable.fromArray("1","2","3")
        .subscribe(item-> {
          System.out.println(item);
          Thread.sleep(2000);
        }
        );


    Disposable subscribe = Observable.fromArray("1", "2", "3")
        .map(x -> x)
        .observeOn(Schedulers.single())
        .map( x -> {throw new RuntimeException("123");} )
        .doOnError((ex)->{
          System.out.println("Exception happens" + ex.getMessage());
        })

        .subscribe(item -> {
              System.out.println(item);
              Thread.sleep(2000);
            }
        );
    while (!subscribe.isDisposed()){
      Thread.yield();
    }
  }
}
