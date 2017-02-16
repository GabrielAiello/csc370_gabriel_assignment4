package hwassignment4csc300;

public class AList 
{
	private String[] data;
	
	public AList()
	{
		this.data = new String[0];
	}
	
	private void qSort(int low, int high)
	{
		int pivot = high;
		while(pivot > low && this.data[pivot].compareTo(this.data[pivot-1]) < 0)
		{
			String temp = this.data[pivot];
			this.data[pivot] = this.data[pivot - 1];
			this.data[pivot - 1] = temp;
			pivot--;
		}
		//we know that everything to right of pivot is larger than it
		//we know that the element directly to the left of pivot is <= it
		//or pivot is at it final location if it is equal to low
		for(int i = low; i < pivot - 1; i++)
		{
			if(this.data[i].compareTo(this.data[pivot]) > 0)
			{
				String temp = this.data[i];
				for(int j = i; j < pivot; j++)
				{
					this.data[j] = this.data[j+1];
				}
				this.data[pivot] = temp;
				i--;
				pivot--;
			}
		}
		
		//we know that everything to left of pivot is <= it, and everything to the
		//right of pivot > it, so now we make the necessary recursive calls to sort
		//the rest of the list.
		
		//potentially two recursive calls
		if(pivot - low > 1)
		{
			this.qSort(low, pivot-1);
		}
		
		if(high - pivot > 1)
		{
			this.qSort(pivot+1, high);
		}
	}
	
	public void sort()
	{
		if(this.data.length > 1)
		{
			this.qSort(0, this.data.length-1);
		}
	}
	
	public void reverse()
	{
		String[] temp = new String[this.data.length];
		for(int pos = 0, i = this.data.length-1; i >= 0; i--, pos++)
		{
			temp[pos] = this.data[i];
		}
		this.data = temp;
	}
	
	public String getAtIndex(int index) throws Exception
	{
		//returns without removing the String at position index
		if(index < 0 || index >= this.data.length)
		{
			//illegal position
			throw new Exception("check your input");
		}
		return this.data[index];
	}
	
	public void display()
	{
		/*
		for(int i = 0; i < this.data.length; i++)
		{
			System.out.println(this.data[i]);
		}
		*/
		for(String s: this.data)
		{
			System.out.println(s);
		}
	}
	
	public String removeAtIndex(int index)
	{
		//returns with removing and resizing the String at positon index
		if(index < 0 || index > this.data.length-1)
		{
			throw (new RuntimeException("Bad index!!!!"));
		}
		else
		{
			String val2Return = this.data[index];
			
			//shrink our AList and get rid of bucket index
			String[] temp =  new String[this.data.length-1];
			int pos = 0;
			for(int i = 0; i < index; i++)
			{
				temp[pos] = this.data[i];
				pos++;
			}
			
			for(int i = index+1; i < this.data.length; i++)
			{
				temp[pos] = this.data[i];
				pos++;
			}
			this.data = temp;
			return val2Return;
		}
	}
	
	public String[] getData() 
	{
		return data;
	}
	
	public void add(String s)
	{
		String[] temp = new String[this.data.length + 1];
		for(int i = 0; i < this.data.length; i++)
		{
			temp[i] = this.data[i];
		}
		temp[temp.length-1] = s;
		data = temp;
	}
	
	public int size()
	{
		return this.data.length;
	}
}