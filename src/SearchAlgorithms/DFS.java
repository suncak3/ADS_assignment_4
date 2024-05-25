package SearchAlgorithms;

import Graphs.MyGraph;

public class DFS<Vertex> extends Search<Vertex>{
    public DFS(MyGraph<Vertex> graph, Vertex source) {
        super(source);

        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);

        for (Vertex v : graph.adj(current)) {
            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
