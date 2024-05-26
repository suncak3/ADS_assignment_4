package SearchAlgorithms;

import Graphs.MyGraph;
import ElementsOfGraph.Vertex;

public class DFS<V> extends Search<V> {
    private MyGraph<V> graph;

    public DFS(MyGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        Vertex<V> sourceVertex = new Vertex<>(source);
        dfs(sourceVertex);
    }

    private void dfs(Vertex<V> vertex) {
        Vertex<V> markedVertex = vertex;
        marked.add(markedVertex);
        for (Vertex<V> adjVertex : graph.adj(vertex)) {
            if (!marked.contains(adjVertex)) {
                edgeTo.put(adjVertex, markedVertex);
                dfs(adjVertex);
            }
        }
    }
}
