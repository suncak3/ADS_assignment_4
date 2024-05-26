package SearchAlgorithms;

import ElementsOfGraph.Edge;
import ElementsOfGraph.Vertex;
import Graphs.WeightedGraph;

import java.util.HashMap;
import java.util.Map;

public class DijkstraSearch<V> extends Search<V> {
    private WeightedGraph<V> graph;
    private Map<Vertex<V>, Double> distTo = new HashMap<>();
    private Map<Vertex<V>, Boolean> visited = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        this.graph = graph;
        //Also here
        Vertex<V> sourceVertex = new Vertex<>(source);

        for (Vertex<V> vertex : graph.getVertices()) {
            distTo.put(vertex, Double.MAX_VALUE);
            visited.put(vertex, false);
        }
        distTo.put(sourceVertex, 0.0);

        dijkstra();
    }

    private void dijkstra() {
        while (true) {
            Vertex<V> v = getMinDistanceVertex();
            if (v == null) break;
            visited.put(v, true);

            for (Edge<Vertex<V>> edge : graph.getEdges(v.getData())) {
                updateShortestPath(edge);
            }
        }
    }

    private Vertex<V> getMinDistanceVertex() {
        Vertex<V> minVertex = null;
        double minDistance = Double.MAX_VALUE;
        for (Map.Entry<Vertex<V>, Double> entry : distTo.entrySet()) {
            if (!visited.get(entry.getKey()) && entry.getValue() < minDistance) {
                minDistance = entry.getValue();
                minVertex = entry.getKey();
            }
        }
        return minVertex;
    }

    private void updateShortestPath(Edge<Vertex<V>> e) {
        Vertex<V> v = e.getSource(), w = e.getDest();
        double weight = e.getWeight();
        double distanceThroughV = distTo.get(v) + weight;
        if (distanceThroughV < distTo.get(w)) {
            distTo.put(w, distanceThroughV);
            edgeTo.put(w, v);
        }
    }
}
