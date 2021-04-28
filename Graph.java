public class Graph {
    private int numV = 0;
    private boolean directed;
    private List adj;

    // return the number of vertices in the graph
    public int getSize(){
        return numV;
    }

    // getters and setters for the directed variable
    public boolean getDirected(){
        return directed;
    }

    public void setDirected(boolean value){
        this.directed = value;
    }

    // getter for the adjacency list
    public List getAdj(){
        return adj;
    }

    // traverses the graph
    public void traverse(){

    }

    // takes the start and end vertices of an edge
    // and returns that edge
    public Edge getEdge(Vertex start, Vertex end){

    }

    // adds an edge to the graph
    public void addEdge(){

    }

    // removes an edge from the graph
    public void removeEdge(){

    }

    // adds a vertex to the graph
    public void addVertex(){
        // adding the vertex
        numV++;
    }

    // removes a vertex from the graph
    public void removeVertex(){
        // removing the vertex
        numV--;
    }

    // return the degree of a vertex
    public int degree(Vertex v){
        int degree = 0;

        // finding the edges and incrementing the degree var

        return degree;
    }

    // return all the edges connected to a vertex
    public Edge[] incidentEdges(Vertex v){

    }

    // returns the sum of the edges
    public int edgeSum(){
        int sum = 0;

        // getting the weight of the edges
        // adding it to the sum

        return sum;
    }
}
