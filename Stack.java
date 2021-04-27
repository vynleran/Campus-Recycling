/* ***************************************************
 * Meagan Kropp
 * 
 * Stack.java
 *
 * creates a stack with generics and uses methods from List.java
 *************************************************** */


class Stack
{
	private List list;
		
	public Stack()
	{

		list = new List();
	}

	public Stack(Stack s)
	{
		list = new List(s.list);
	}
	
	public void Push(String data)
	{
		list.First();
		list.InsertBefore(data);
	}

	public String Pop()
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

	public boolean Equals(Stack s)
	{
		return (list.Equals(s.list));
	}

	public Stack Add(Stack s)
	{
		Stack newStack = new Stack(this);
		newStack.list = newStack.list.Add(s.list);
		return newStack;
	}

	public String toString()
	{
		return list.toString();
	}
	
}

