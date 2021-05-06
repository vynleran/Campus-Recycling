public class Graph {
    private int numV = 0;
    private boolean directed = false;
    private List<Vertex> vertexList;
    private Edge adjMat[][];

    public Graph(){
        numV = 0;
        adjMat = null;
        vertexList = new List<>();
        directed = false;
    }

    public Graph(int size){
        this.numV = size;
        vertexList = new List<>();
        adjMat = new Edge[size][size];
        makeAdjMat(size);
    }

    public void makeAdjMat(int size){
        adjMat = new Edge[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                adjMat[i][j] = null;
            }
        }
    }

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

    // takes the start and end vertices of an edge
    // and returns that edge
    public Edge getEdge(Vertex start, Vertex end){
        if(adjMat[start.getIndex()][end.getIndex()] != null){
            return adjMat[start.getIndex()][end.getIndex()];
        }
        return null;
    }

    // adds an edge to the graph
    public void addEdge(Vertex start, Vertex end){
        adjMat[start.getIndex()][end.getIndex()] = new Edge(start, end);
        adjMat[end.getIndex()][start.getIndex()] = new Edge(end, start);
    }

    public void addEdge(Vertex start, Vertex end, int weight){
        int startIndex = start.getIndex();
        int endIndex = end.getIndex();
        Edge a = new Edge(start, end, weight);
        Edge b = new Edge(end, start, weight);
        adjMat[startIndex][endIndex] = a;
        adjMat[endIndex][startIndex] = b;
    }

    // removes an edge from the graph
    public void removeEdge(){
        int startIndex = start.getIndex();
        int endIndex = end.getIndex();
        adjMat[startIndex][endIndex] = null;
        adjMat[endIndex][startIndex] = null;
    }

    // adds a vertex to the graph
    public void addVertex(String name){
        Vertex newVertex = new Vertex(name);
        vertexList.Last();
        numV++;
        vertexList.InsertAfter(newVertex);
        vertexList.GetValue().setIndex(vertexList.GetPos());
        updateAdjMat();
    }

    public void updateAdjMat()
    {
        Edge[][] oldAdjMat = adjMat;
        Edge[][] newAdjMat = new Edge[numV][numV];
        if (oldAdjMat != null)
        {
            for (int i = 0; i < oldAdjMat.length; i++)
            {
                for (int j = 0; j < oldAdjMat[i].length; j++)
                {
                    newAdjMat[i][j] = oldAdjMat[i][j];
                }
            }
        }
    }

    // removes a vertex from the graph
    public void removeVertex(){
        // removing the vertex
        numV--;
    }

    // return the degree of a vertex
    public int degree(int row){
        int degree = 0;
        for(int i=0;i<adjMat[row].length;i++){
            if(adjMat[row] != null){
                degree++;
            }
        }
        return degree;
    }

    // returns all outgoing edges of a vertex
    public List<Edge> incidentEdges(Vertex v)
    {
        List<Edge> outgoingEdges = new List<Edge>();
        for (int i = 0; i < adjMat.length; i++)
        {
            if (adjMat[v.getIndex()][i] != null)
                outgoingEdges.InsertAfter(adjMat[v.getIndex()][i]);
        }
        return outgoingEdges;
    }

    // returns the sum of the weights of the edges
    public int edgeSum(Vertex v)
    {
        int result = 0;
        for (int i = 0; i < adjMat.length; i++)
        {
            if (adjMat[v.getIndex()][i] != null)
                result += adjMat[v.getIndex()][i].getWeight();
        }
        return result;
    }

}
