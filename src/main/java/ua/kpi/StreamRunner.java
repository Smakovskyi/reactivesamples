package ua.kpi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;

public class StreamRunner {

  public static void main(String[] args) {
    List<String> strings = Arrays.asList("one", "two", "three", "four");
    List<Byte> byteList = strings.stream()
        .map(String::toUpperCase)
        .map( String::getBytes)
        .map( ArrayUtils::toObject )
        .map( Arrays::asList)
        .flatMap( List::stream  )
        .collect(Collectors.toList());

    byte[] bytes = ArrayUtils.toPrimitive(byteList.toArray(new Byte[0]));
    System.out.println(new String(bytes));


  }

}
