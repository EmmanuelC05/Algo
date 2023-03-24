import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");

        graph graph = new graph();


        Scanner scanner = new Scanner(file);
        while(scanner.hasNextInt()) {
            int source = scanner.nextInt();
            int target = scanner.nextInt();
            graph.addEdge(source, target);
        }

        graph.saveGraph();
        graph.outputGraph();
    }

}