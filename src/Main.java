import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Skriv in ett av orden i listan:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ord1 = reader.readLine();

        System.out.println("Skriv in ett annat av orden i listan:");
        String ord2 = reader.readLine();

        Graph graph = new Graph();
        graph.addNodes(graph.listCreator());  // skapar NodeList med alla ord
        System.out.println();


        graph.djikstras(graph.NodeList.get(graph.getPosition(ord1, graph.NodeList)));
        graph.printPath(graph.sortedList.get(graph.getPosition(ord2, graph.sortedList)));


    }
}