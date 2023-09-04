import java.util.LinkedList;

public class Node {
    String word;
    LinkedList<Node> neighbour = new LinkedList<>();
    Node path;
    int dist;
    boolean known = false;


}
