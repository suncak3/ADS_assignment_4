package Graphs;

import ElementsOfGraph.Vertex;
import ElementsOfGraph.Edge;
import java.util.*;

public class WeightedGraph<V> {
    private Map<Vertex<V>, List<Edge<Vertex<V>>>> map = new HashMap<>();
    private boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        map.putIfAbsent(new Vertex<>(data), new ArrayList<>());
    }

    public void addEdge(V source, V destination, double weight) {
        Vertex<V> src = getOrCreateVertex(source);
        Vertex<V> dest = getOrCreateVertex(destination);
        if (!src.equals(dest)) {
            map.get(src).add(new Edge<>(src, dest, weight));
            if (undirected) {
                map.get(dest).add(new Edge<>(dest, src, weight));
            }
        }
    }

    private Vertex<V> getOrCreateVertex(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        if (!map.containsKey(vertex)) {
            map.put(vertex, new ArrayList<>());
        }
        return vertex;
    }

    public boolean hasVertex(V data) {
        return map.containsKey(new Vertex<>(data));
    }

    public boolean hasEdge(V source, V destination) {
        Vertex<V> src = new Vertex<>(source);
        Vertex<V> dest = new Vertex<>(destination);
        if (map.containsKey(src)) {
            for (Edge<Vertex<V>> edge : map.get(src)) {
                if (edge.getDest().equals(dest)) {
                    return true;
                }
            }
        }
        return false;
    }


    public int getVerticesCount() {
        return map.size();
    }


    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> vertex : map.keySet()) {
            count += map.get(vertex).size();
        }
        return undirected ? count / 2 : count;
    }


    public List<Edge<Vertex<V>>> getEdges(V data) {
        Vertex<V> vertex = new Vertex<>(data);
        if (map.containsKey(vertex)) {
            return map.get(vertex);
        } else {
            return new ArrayList<>();
        }
    }

    public Set<Vertex<V>> getVertices() {
        return new HashSet<>(map.keySet());
    }
}
