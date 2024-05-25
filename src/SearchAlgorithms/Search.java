package SearchAlgorithms;

import java.util.*;

public class Search<Vertex> {
    protected final Vertex source;
    protected final Set<Vertex> marked;
    protected final Map<Vertex, Vertex> edgeTo;

    public Search(Vertex source) {
        this.source = source;
        this.marked = new HashSet<>();
        this.edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v){
        return marked.contains(v);
    }

    public Iterable<Vertex> pathTo(Vertex v){
        if(!hasPathTo(v))
            return null;

        ArrayList<Vertex> path = new ArrayList<>();
        for(Vertex vertex = v; vertex != source; vertex = edgeTo.get(vertex)){
            path.add(vertex);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
