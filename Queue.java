/* ***************************************************
 * Meagan Kropp
 * 
 * Queue.java
 *
 * creates a queue with generics and uses methods from List.java
 *************************************************** */


class Queue
{
	private List list;
		
	public Queue()
	{
		list = new List();
	}

	public Queue(Queue s)
	{
		list = new List(s.list);
	}
	
	public void Enqueue(String data)
	{
		list.Last();
		list.InsertAfter(data);
	}

	public String Dequeue()
	{
		list.First();
		String data = list.GetValue();
		list.Remove();
		return data;
	}

	public String Peek()
	{
		list.First();
		return list.GetValue();
	}

	public int Size()
	{
		return list.GetSize();
	}

	public boolean IsEmpty()
	{
		return list.IsEmpty();
	}

	public boolean IsFull()
	{
		return list.IsFull();
	}

	public boolean Equals(Queue s)
	{
		return (list.Equals(s.list));
	}

	public Queue Add(Queue s)
	{
		Queue newQueue = new Queue(this);
		newQueue.list = newQueue.list.Add(s.list);
		return newQueue;
	}

	public String toString()
	{
		return list.toString();
	}
	
}