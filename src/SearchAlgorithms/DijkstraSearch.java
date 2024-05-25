package SearchAlgorithms;

import ElementsOfGraph.Edge;
import Graphs.WeightedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraSearch<Vertex> extends Search<Vertex> {
    private final WeightedGraph<Vertex> graph;
    private final Map<Vertex, Double> distanceTo;
    private final Set<Vertex> unsettledNotes;

    public DijkstraSearch(WeightedGraph<Vertex> graph, Vertex source){
        super(source);
        unsettledNotes = new HashSet<>();
        this.graph = graph;
        distanceTo = new HashMap<>();

        dijkstraSearch();
    }

    private void dijkstraSearch() {
        distanceTo.put(source, (double) 0);
        unsettledNotes.add(source);

        while(!unsettledNotes.isEmpty()){
            Vertex current = getVertexWithMinWeight(unsettledNotes);
            unsettledNotes.remove(current);
            marked.add(current);

            for(Vertex neighbor : graph.adj(current)){
                double edgeWeight = getEdgeWeight(current, neighbor);
                double newDistance = distanceTo.get(current) + edgeWeight;

                if(newDistance < getShortestDistance(neighbor)){
                    distanceTo.put(neighbor, newDistance);
                    edgeTo.put(neighbor, current);
                    unsettledNotes.add(neighbor);
                }
            }
        }
    }

    private double getEdgeWeight(Vertex current, Vertex neighbor) {
        for(Edge<Vertex> edge : graph.getEdges(current)) {
            if (edge.getDest().equals(neighbor))
                return edge.getWeight();
        }
        return Double.MAX_VALUE;
    }

    private Vertex getVertexWithMinWeight(Set<Vertex> unsettledNotes) {
        Vertex minVertex = null;
        for(Vertex v : unsettledNotes){
            if(minVertex == null){
                minVertex = v;
                continue;
            }

            if(getShortestDistance(v) < getShortestDistance(minVertex)){
                minVertex = v;
            }
        }
        return minVertex;
    }

    private double getShortestDistance(Vertex v) {
        Double d = distanceTo.get(v);

        if(d == null)
            return Double.MAX_VALUE;
        else
            return d;
    }


}
