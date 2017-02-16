package hwassignment4csc300;

public class LinkList 
{
	Node head;
	Node tail;
	public void addEnd(LinkList list, Node node)
	{
		if(list.head == null)
		{
			list.head = node;
			list.tail = node;
		}
		else
		{
			list.tail.nextnode = node;
			list.tail = node;
		}
	}
	public void addFront(LinkList list, Node node)
	{
		if(list.head == null)
		{
			list.tail = node;
			list.head = node;
		}
		else
		{
			node.nextnode = head;
			list.head = node;
		}
	}
	public void display(LinkList list)
	{
		Node runner = list.head;
			while (runner != null)
			{
				System.out.println(runner.payload);
				runner = runner.nextnode;
			}
	
	}
}
