import java.io.*;
import java.util.*;
import java.time.*;
import java.nio.file.*;

public class Main {

    public static void main(String args[]) throws Exception{

        String buildings = " ";
        Graph map = new Graph();
        buildings = new String(Files.readAllBytes(Paths.get("vertices.txt")));
        String[] arrayString = buildings.split("\\r?\\n");

        for(int i = 0; i < arrayString.length; i++)
        {
            map.addVertex(arrayString[i]);
        }


        File edges = new File("edges.csv");
        Scanner edgesInput = new Scanner(edges);
        
        while(edgesInput.hasNextLine())
        {
            String currentEdge = edgesInput.nextLine();
            String edge[] = currentEdge.split(",");

            Vertex begin = map.findVertex(edge[0]);
            
            Vertex ending = map.findVertex(edge[1]);
            int verWeight = Integer.parseInt(edge[2]);


            map.addEdge(begin, ending);

        }

        //Scanner user = new Scanner(System.in);
        //System.out.println("Path to which building: ");
       // String userInput = user.nextLine(); // scanning user input
    }
}
