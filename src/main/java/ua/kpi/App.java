package ua.kpi;

import io.reactivex.Observable;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Observable.fromArray( 1,2,3,4,5,6)
                .filter( val -> val > 2 && val %2 ==0 )
                .map( val -> val * 2 )
                .subscribe( System.out::println );
        System.out.println( "Hello World!" );

        Observable.just(Arrays.asList("1" , "22", "333"))
                .flatMap( items -> Observable.fromIterable(items))
                .subscribe( System.out::println);

        Observable.fromArray( "1" , "22", "333" )
                .flatMap( str -> Observable.fromArray( str.getBytes()) )
                .subscribe( System.out::println);
    }
}
