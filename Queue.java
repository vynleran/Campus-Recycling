/* ***************************************************
 * Meagan Kropp
 * 
 * Queue.java
 *
 * creates a queue with generics and uses methods from List.java
 *************************************************** */


class Queue<type>
{
	private List<type> list;
		
	public Queue()
	{
		list = new List<type>();
	}

	public Queue(Queue<type> s)
	{
		list = new List<type>(s.list);
	}
	
	public void Enqueue(type data)
	{
		list.Last();
		list.InsertAfter(data);
	}

	public type Dequeue()
	{
		list.First();
		type data = list.GetValue();
		list.Remove();
		return data;
	}

	public type Peek()
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

	public boolean Equals(Queue<type> s)
	{
		return (list.Equals(s.list));
	}

	public Queue<type> Add(Queue<type> s)
	{
		Queue<type> newQueue = new Queue<type>(this);
		newQueue.list = newQueue.list.Add(s.list);
		return newQueue;
	}

	public String toString()
	{
		return list.toString();
	}
	
}