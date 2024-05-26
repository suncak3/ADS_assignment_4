package SearchAlgorithms;

import Graphs.MyGraph;
import ElementsOfGraph.Vertex;
import java.util.*;

public class BFS<V> extends Search<V> {
    private MyGraph<V> graph;

    public BFS(MyGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        Vertex<V> sourceVertex = new Vertex<>(source);
        bfs(sourceVertex);
    }

    private void bfs(Vertex<V> source) {
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);

        while (!queue.isEmpty()) {
            Vertex<V> current = queue.remove();
            for (Vertex<V> neighbor : graph.adj(current)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}
