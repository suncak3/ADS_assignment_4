package Graphs;

import ElementsOfGraph.Vertex;
import java.util.*;

public class MyGraph<V> {
    private final boolean undirected;
    private Map<Vertex<V>, List<Vertex<V>>> map = new HashMap<>();

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V data) {
        Vertex<V> newVertex = new Vertex<>(data);
        if (!map.containsKey(newVertex)) {
            map.put(newVertex, new ArrayList<>());
        }
    }


    public void addEdge(V source, V destination) {
        //For example here
        Vertex<V> src = new Vertex<>(source);
        Vertex<V> dest = new Vertex<>(destination);

        if (!map.containsKey(src)) {
            map.put(src, new ArrayList<>());
        }
        map.get(src).add(dest);

        if (undirected) {
            if (!map.containsKey(dest)) {
                map.put(dest, new ArrayList<>());
            }
            map.get(dest).add(src);
        }
    }

    public boolean hasVertex(Vertex<V> vertex) {
        return map.containsKey(vertex);
    }

    public boolean hasEdge(V source, V destination) {
        //Here
        Vertex<V> src = new Vertex<>(source);
        Vertex<V> dest = new Vertex<>(destination);
        return map.containsKey(src) && map.get(src).contains(dest);
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


    public List<Vertex<V>> adj(Vertex<V> vertex) {
        if(map.containsKey(vertex)){
            return map.get(vertex);
        }
        else{
            return new ArrayList<>();
        }
    }

}
