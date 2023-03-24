import java.util.Objects;

public class vertex {
    public vertex(int vertex_id) {
        this.vertex_id = vertex_id;
    }
    private int vertex_id;
    private double rank = -1;
    private int outDegree = 0;
    private int inDegree;

    public double getRank() {
        return rank;
    }

    public int getVertex_id() {
        return vertex_id;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void degree() {
        //outDegree = outDegree + 1;

        outDegree++;
    }

    public vertex() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        vertex vertex = (vertex) o;
        return vertex_id == vertex.vertex_id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(vertex_id);
    }
}


