public class Edge {

    private int weight;
    private Vertex start;
    private Vertex end;

    public Edge(Vertex a, Vertex b){
        this.start = a;
        this.end = b;
    }

    public Edge(int w, Vertex a, Vertex b){
        this.weight = w;
        this.start = a;
        this.end = b;
    }

    // getters and setters for the weight variable
    public int getWeight(){
        return this.weight;
    }

    public void setWeight(int w){
        this.weight = w;
    }

    // getters and setters for the vertex A
    public Vertex getStart(){
        return this.start;
    }

    public void setStart(Vertex name){
        this.start = name;
    }

    // getters and setters for the vertex B
    public Vertex getEnd(){
        return this.end;
    }

    public void setEnd(Vertex name){
        this.end = name;
    }

    // methods that return the vertices
    public Vertex opposite(Vertex vertex){
        Vertex output = null;

        if(vertex.getData().equals(start.getData())){
            output = end;
        }
        else if(vertex.getData().equals(end.getData())){
            output = start;
        }
        else{
            throw new IllegalArgumentException("Illegal Vertex");
        }

        return output;
    }

    public Vertex[] endPoint(){
        Vertex[] output = new Vertex[2];

        output[0] = start;
        output[1] = end;

        return output;
    }
}
