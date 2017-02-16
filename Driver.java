package hwassignment4csc300;

public class Driver 
{
	public static void main(String[] args)
	{
		LinkList blurb = new LinkList();
		Node a = new Node();
		a.payload = "happy";
		Node b = new Node();
		b.payload = "sad";
		blurb.addFront(blurb, a);
		blurb.addEnd(blurb, b);
		blurb.display(blurb);
	}
}
