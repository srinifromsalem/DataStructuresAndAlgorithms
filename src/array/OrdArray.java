package array;

class OrdArray {
	private long[] array; // ref to array a
	private int nElems; // number of data items
//-----------------------------------------------------------

	public OrdArray(int max) // constructor
	{
		array = new long[max]; // create array
		nElems = 0;
	}

//-----------------------------------------------------------
	public int size() {
		return nElems;
	}

//-----------------------------------------------------------
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int currentIndex;
		while (true) {
			currentIndex = (lowerBound + upperBound) / 2;
			if (array[currentIndex] == searchKey)
				return currentIndex; // found it
			else if (lowerBound > upperBound)
				return nElems; // can’t find it
			else // divide range
			{
				if (array[currentIndex] < searchKey)
					lowerBound = currentIndex + 1; // it’s in upper half
				else
					upperBound = currentIndex - 1; // it’s in lower half
			} // end else divide range
		} // end while
	} // end find()
//-----------------------------------------------------------

	public void insert(long value) // put element into array
	{
		int j;
		for (j = 0; j < nElems; j++) // find where it goes
			if (array[j] > value) // (linear search)
				break;
		for (int k = nElems; k > j; k--) // move bigger ones up
			array[k] = array[k - 1];
		array[j] = value; // insert it
		nElems++; // increment size
	} // end insert()
//-----------------------------------------------------------

	public boolean delete(long value) {
		int j = find(value);
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move bigger ones down
				array[k] = array[k + 1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
//-----------------------------------------------------------

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(array[j] + " "); // display it
		System.out.println("");
	}
//-----------------------------------------------------------
} // end class OrdArray
////////////////////////////////////////////////////////////////