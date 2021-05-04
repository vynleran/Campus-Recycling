/* ***************************************************
 * Meagan Kropp
 * 
 * Stack.java
 *
 * creates a stack with generics and uses methods from List.java
 *************************************************** */


class Stack<type>
{
	private List<type> list;
		
	public Stack()
	{

		list = new List<type>();
	}

	public Stack(Stack<type> s)
	{
		list = new List<type>(s.list);
	}
	
	public void Push(type data)
	{
		list.First();
		list.InsertBefore(data);
	}

	public type Pop()
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

	public boolean Equals(Stack<type> s)
	{
		return (list.Equals(s.list));
	}

	public Stack<type> Add(Stack<type> s)
	{
		Stack<type> newStack = new Stack<type>(this);
		newStack.list = newStack.list.Add(s.list);
		return newStack;
	}

	public String toString()
	{
		return list.toString();
	}
	
}

