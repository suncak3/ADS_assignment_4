package SearchAlgorithms;

import ElementsOfGraph.Vertex;
import java.util.*;

public abstract class Search<V> {
    protected Vertex<V> source;
    protected Set<Vertex<V>> marked = new HashSet<>();
    protected Map<Vertex<V>, Vertex<V>> edgeTo = new HashMap<>();

    public Search(V source) {
        this.source = new Vertex<>(source);
    }

    public boolean hasPathTo(V destination) {
        Vertex<V> destVertex = new Vertex<>(destination);
        return marked.contains(destVertex);
    }

    public Iterable<V> pathTo(V destination) {
        LinkedList<V> path = new LinkedList<>();
        Vertex<V> current = new Vertex<>(destination);
        while (current != null && !current.equals(source)) {
            path.addFirst(current.getData());
            current = edgeTo.get(current);
        }
        if (current.equals(source)) {
            path.addFirst(source.getData());
        }
        return path;
    }
}
