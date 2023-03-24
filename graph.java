import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class graph {

    HashSet<vertex>vertices = new HashSet<>();
    HashMap<vertex, List<vertex>> list = new HashMap<>();

    private boolean checkNodes(int vertex_id) {

        boolean nodeExistent = false;

        vertex vertex = new vertex(vertex_id);


        if(vertices.contains(vertex))
            nodeExistent = true;

        return nodeExistent;


    }

    private vertex getVertex (int vertexId) {

        vertex result = null;

        for(vertex v : vertices) {
            if(v.getVertex_id() == vertexId) {
                result = v;
            }
        }

        return result;

    }

    private void addVertexToVertices(int vertex_id) {

        vertex vertex = new vertex(vertex_id);

        vertices.add(vertex);
        list.put(vertex, new ArrayList<>());

    }
    public void addEdge(int source, int target) {

        if (!checkNodes(source)) {
            addVertexToVertices(source);
        }
        if (!checkNodes(target)) {
            addVertexToVertices(target);
        }

        if(checkNodes(source) && checkNodes(target)) {
            list.get(getVertex(source)).add(getVertex(target));

            getVertex(source).degree();

        }
    }
     public void saveGraph () throws FileNotFoundException {
         PrintWriter outputFile = new PrintWriter("output.txt");

        for(vertex vertex : vertices) {
            outputFile.println(
                    vertex.getVertex_id() + " " +
                    vertex.getOutDegree() + " " +
                           formatting(list.get(vertex)
            ));
        }

        outputFile.close();
     }
     private String formatting (List<vertex> adjacentVertex){

        String output = "";

        for(vertex vertex : adjacentVertex) {
            output += vertex.getVertex_id() + " ";
        }

        output = output.trim();

        return output;

     }

     public void outputGraph() {
        for (vertex vertex : vertices) {
            System.out.println(
                    "Vertex " + vertex.getVertex_id() + ": rank = " + vertex.getRank() + ", out-degree = " + vertex.getOutDegree()
                    + "\nEdges from " + vertex.getVertex_id() + " to: " + formatting(list.get(vertex)).replace(" ", ", ")
            );
            System.out.println();
        }
     }


}

