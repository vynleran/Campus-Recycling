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
    public Edge[][] getAdj(){
        return adjMat;
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
    public void removeEdge(Vertex start, Vertex end){
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

    public void DFS(Graph g, Vertex u)
    {
        Vertex[] parents = new Vertex[numV];
        Stack<Vertex> stack = new Stack<>();

        stack.Push(u);
        u.setVisited(true);
        while (!stack.IsEmpty())
        {
            for (int i = 0; i < adjMat.length; i++)
            {
                vertexList.SetPos(i);
                if ((adjMat[stack.Peek().getIndex()][i] != null) && (!vertexList.GetValue().getVisited()))
                {
                    vertexList.GetValue().setVisited(true);
                    Vertex temp = adjMat[stack.Peek().getIndex()][i].opposite(stack.Peek());
                    parents[temp.getIndex()] = stack.Peek();
                    stack.Push(temp);
                    i = -1;
                }
            }
            stack.Pop();
        }

        for (int i = 0; i < vertexList.GetSize(); i++)
        {
            vertexList.SetPos(i);
            (vertexList.GetValue()).setVisited(false);
        }
        g.printPath(g, parents, u);
    }

    public void dijkstra(Graph g, Vertex u)
    {
        boolean[] known = new boolean[numV]; // all false initially;
        int[] cost = new int[numV]; // shortest known distance from "s"
        Vertex[] path = new Vertex[numV]; // preceding Vertex in path;

        // initialize the arrays
        for (int i = 1; i < known.length; i++)
            known[i] = false;
        known[u.getIndex()] = true;


        for (int i = 0; i < cost.length; i++)
            cost[i] = Integer.MAX_VALUE;
        cost[u.getIndex()] = 0;

        for (int i = 0; i < cost.length; i++)
        {
            if (adjMat[u.getIndex()][i] != null)
            {
                cost[i] = adjMat[u.getIndex()][i].getWeight();
                path[i] = u;
            }
        }

        for (int i = 0; i < cost.length - 1; i++)
        {
            int next = findMinVertex(cost, known);
            if(next == -1)
                continue;
            known[next] = true;
            for (int j = 0; j < adjMat.length; j++)
            {
                if (!known[j] && adjMat[next][j] != null)
                {
                    cost[j] = Math.min(cost[j], (cost[next] + adjMat[next][j].getWeight()));
                    if (cost[j] == (cost[next] + adjMat[next][j].getWeight()))
                    {
                        vertexList.SetPos(next);
                        path[j] = vertexList.GetValue();
                    }
                }
            }
        }

        g.printPath(g, path, u);
    }

    public void printPath(Graph g, Vertex[] path, Vertex u)
    {
        for (int i = 0; i < path.length; i++)
        {
            List pathList = new List<>();
            Vertex v = path[i];
            if (path[i] == null)
            {
                vertexList.SetPos(i);
                System.out.println(vertexList.GetValue());
            }

            else
            {
                vertexList.SetPos(i);
                pathList.InsertBefore(vertexList.GetValue());
                while (!v.equals(u))
                {
                    pathList.InsertBefore(v);
                    v = path[v.getIndex()];
                }

                pathList.InsertBefore(u);
                System.out.println(pathList);
            }
        }
    }

    public int findMinVertex (int[] cost, boolean[] known)
    {
        int minCost = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < cost.length; i++)
        {
            if ((cost[i] < minCost) && !known[i])
            {
                minIndex = i;
                minCost = cost[i];

            }
        }
        return minIndex;
    }

    //exact opposite of find min vertex
    public int findMaxVertex (int[] cost, boolean[] known)
    {
        int maxCost = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < cost.length; i++)
        {
            if ((cost[i] > maxCost) && !known[i])
            {
                maxIndex = i;
                maxCost = cost[i];
            }
        }
        return maxIndex;
    }

    // referenced Geeks for Geeks and totalhorizon.com
    public int primMST(Graph g, Vertex u)
    {
        Vertex[] mst = new Vertex[numV]; //store mst array
        int[] cost = new int[numV]; //used to pick min weight
        boolean[] known = new boolean[numV];

        for (int i = 0; i < cost.length ; i++)
            cost[i] = Integer.MAX_VALUE; //makes all infinity
        cost[u.getIndex()] = 0; //making the key 0 so the first index picked is zero

        int distance = 0;
        for (int i = 0; i < cost.length ; i++)
        {
            int next = (findMinVertex(cost, known)); //calls minVertex and adds in the minMST and key
            if(next == -1)
                continue;
            known[next] = true;

            //had to borrow this second for loop from Austin
            for (int k = 0; k < adjMat.length; k++)
            {
                if (adjMat[next][k] != null && !known[k])
                {
                    cost[k] = adjMat[next][k].getWeight();
                    vertexList.SetPos(next);
                    mst[k] = vertexList.GetValue();
                }
            }
            distance = distance + cost[next];
        }
        System.out.println("The distance for the Minimum Spanning Tree is: " + distance);
        printPath(g, mst, u);
        return distance;
    }


}