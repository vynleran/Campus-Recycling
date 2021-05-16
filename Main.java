import java.io.*;
import java.util.*;
import java.time.*;
import java.nio.file.*;

public class Main {

    public static void main(String args[]) throws Exception{

        Graph map = new Graph();
        File vertices = new File("vertices.txt");
        Scanner verticesInput = new Scanner(vertices);
        String[] vertex = verticesInput.nextLine().split(",");
        for (String s : vertex)
            map.addVertex(s);

        map.makeAdjMat(vertex.length);

        File edges = new File("edges.csv");
        Scanner edgesInput = new Scanner(edges);
        while (edgesInput.hasNextLine())
        {
            String currentEdge = edgesInput.nextLine();
            String[] edge = currentEdge.split(",");
            Vertex origin = map.findVertex(edge[0]);
            Vertex destination = map.findVertex(edge[1]);
            int weight = Integer.parseInt(edge[2]);
            map.addEdge(origin, destination, weight);
        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("What is your starting building? ");
        String input = userInput.nextLine();
        Vertex startingVertex = map.findVertex(input);

        /* PrintStream console = System.out;
		File file = new File("out.txt");
		FileOutputStream output = new FileOutputStream(file);
		PrintStream print = new PrintStream(output);
		System.setOut(print); */


        if (startingVertex != null)
        {
            System.out.println("Dijkstra");
            long startTimeDijkstra = System.currentTimeMillis();
            map.dijkstra(map, startingVertex);
            System.out.println();
            long endTimeDijkstra = System.currentTimeMillis();
            long elapsedTimeDijkstra = endTimeDijkstra - startTimeDijkstra;
            System.out.println("The time for Dijkstra: " + elapsedTimeDijkstra + " ms.");
            System.out.println();

            System.out.println("Prim-Jarnik");
            long startTimePrim = System.currentTimeMillis();
            map.primMST(map, startingVertex);
            System.out.println();
            long endTimePrim = System.currentTimeMillis();
            long elapsedTimePrim = endTimePrim - startTimePrim;
            System.out.println("The time for Prim-Jarnik: " + elapsedTimePrim + " ms.");
            System.out.println();
            if (elapsedTimeDijkstra < elapsedTimePrim)
                System.out.println("Dijkstra is faster than Prim-Jarnik.");
            if (elapsedTimePrim < elapsedTimeDijkstra)
                System.out.println("Prim-Jarnik is faster than Dijkstra.");

            System.out.println();
            System.out.println("Max Spanning Tree");
            System.out.println("________________________________");
            map.maxST(map, startingVertex);
            System.out.println();

            System.out.println();
            System.out.println("DFS");
            System.out.println("________________________________");
            map.DFS(map, startingVertex);
            System.out.println();
            System.out.println();

            System.out.println("BFS");
            System.out.println("________________________________");
            map.BFS(map, startingVertex);
            System.out.println();
            System.out.println();
        }

        else System.out.println("Invalid input homie :(");

        //System.setOut(console);
		//System.out.println("Output sent to out.txt");

    }
}
