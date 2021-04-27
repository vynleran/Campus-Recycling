class Vertex
{
	private String data;
	private boolean visited;

	// constructor
	public Vertex()
	{
		this.data = " ";
		this.visited = false;
	}

	// accessor and mutator for the data component
	public String getData()
	{
		return this.data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

	// accessor and mutator for visited component
    public boolean getVisited()
    {
        return this.visited;
    }

    public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public String toString()
	{
		return this.data;	
	}

}