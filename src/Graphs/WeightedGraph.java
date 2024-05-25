package Graphs;

import ElementsOfGraph.Edge;

import java.util.*;

public class WeightedGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();

    public WeightedGraph(){
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v){
        map.put(v, new ArrayList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight){
        if(!hasVertex(source))
            addVertex(source);
        if(!hasVertex(dest))
            addVertex(dest);

        if(!hasEdge(source, dest) && !source.equals(dest)){
            map.get(source).add(new Edge<>(source, dest, weight));

            if(undirected){
                map.get(dest).add(new Edge<>(dest, source, weight));
            }
        }
    }

    public int getVerticesCount(){
        return map.size();
    }

    public int getEdgesCount(){
        int count = 0;

        for(Vertex v : map.keySet()){
            count += map.get(v).size();
        }

        return undirected ? count / 2 : count;
    }

    public boolean hasVertex(Vertex v){
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest){
        if(!hasVertex(source)){
            return false;
        }
        for(Edge<Vertex> edge : map.get(source)){
            if(edge.getDest().equals(dest)){
                return true;
            }
        }
        return false;
    }

    public Iterable<Vertex> adj(Vertex v){
        if(!hasVertex(v))
            return null;
        List<Vertex> adjVertices = new ArrayList<>();
        for(Edge<Vertex> edge : map.get(v)){
            adjVertices.add(edge.getDest());
        }
        return adjVertices;
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex v){
        if(!hasVertex(v))
            return null;
        return map.get(v);
    }
}
