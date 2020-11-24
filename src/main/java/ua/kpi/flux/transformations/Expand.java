package ua.kpi.flux.transformations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import reactor.core.publisher.Flux;

public class Expand {

  static final class Node {
    final String name;
    final List<Node> children;

    Node(String name, Node... nodes) {
      this.name = name;
      this.children = new ArrayList<>();
      children.addAll(Arrays.asList(nodes));
    }

    @Override
    public String toString() {
      return name;
    }
  }

  static Function<Node, Flux<Node>> expander = node -> Flux.fromIterable(node.children);

  public static List<Node> createTestData(){
    return Arrays.asList(
        new Node( "1", new Node("11") ),
        new Node( "2", new Node("21"),
                             new Node("22", new Node("221")) )
    );
  }

  public static void main(String[] args) {
    Flux<Node> nodeFlux = Flux.fromIterable(createTestData())
        .expandDeep(expander);
    nodeFlux
        .subscribe(System.out::println);
    nodeFlux.blockLast();

  }
}
