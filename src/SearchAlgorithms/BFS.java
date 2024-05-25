package SearchAlgorithms;

import Graphs.MyGraph;
import Graphs.WeightedGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<Vertex> extends Search<Vertex> {
    private final MyGraph<Vertex> graph;
    public BFS(MyGraph<Vertex> graph, Vertex source){
        super(source);
        this.graph = graph;
        bfs(source);
    }

    public void bfs(Vertex v){
        Queue<Vertex> queue = new LinkedList<>();
        marked.add(v);
        queue.add(v);

        while(!queue.isEmpty()){
            Vertex h = queue.remove();
            for(Vertex vertex : graph.adj(h)){
                if(!marked.contains(vertex)){
                    edgeTo.put(vertex, h);
                    marked.add(vertex);
                    queue.add(vertex);
                }
            }
        }
    }
}
