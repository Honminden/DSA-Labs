public class BinaryHeap
{
    int[] arr;
    int size;

    //create a BinaryHeap
    public BinaryHeap(int capacity)
    {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public BinaryHeap(int[] items)
    {
        this.arr = items;
        this.size = items.length;

        // heapify
        for (int i = (size - 1) / 2; i >= 0; i--)   
        {
            int j = i;
            while (true)
            {
                int left = 2 * j + 1;
                int right = 2 * j + 2;
                int swap = j;

                if (left >= size)
                {
                    // leaf
                    break;
                }
                else if (arr[left] < arr[j])
                {
                    swap = left;
                }

                if ((right < size) && (arr[right] < arr[j]))
                {
                    swap = right;
                }

                // swap
                arr[j] ^= arr[swap];
                arr[swap] ^= arr[j];
                arr[j] ^= arr[swap];

                j = swap;
            }
        }
    }

    //insert a element into the heap
    public void insert(int x)
    {
        arr[size] = 0; // throws Exception when the heap is full

        size++;

        int i = size - 1;
        while (i > 0)
        {
            int parent = (i - 1) / 2;
            if (arr[parent] > x)
            {
                arr[i] = arr[parent];
                i = parent;
            }
            else
            {
                arr[i] = x;
                break;
            }
        }
        
        if (i == 0)
        {
            arr[i] = x;
        }
    }

    //return the minimum element
    public int findMin() throws EmptyException
    {
        if (size == 0)
        {
            throw new EmptyException();
        }
        {
            return arr[0];
        }
    }

    //remove and return the minimum element
    public int deleteMin() throws EmptyException
    {
        if (size == 0)
        {
            throw new EmptyException("empty");
        }
        else
        {   
            int min = arr[0];

            int x = arr[size - 1];
            int i = 0;
            while (i <= (size - 2) / 2)
            {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int swap = i;
            
                if ((left < size) && (arr[left] < x))
                {
                    swap = left;
                }
                
                if ((right < size) && (arr[right] < x))
                {
                    swap = right;
                }

                arr[i] = arr[swap];

                if (swap != i)
                {
                    i = swap;
                }
                else
                {
                    break;
                }
            }

            arr[i] = x;

            arr[size - 1] = 0;
            size--;
            return min;
        }
    }

    //judge whether the heap is empty
    public boolean isEmpty()
    {
        return (size == 0);
    }

    //remove all elements
    public void makeEmpty()
    {
        arr = new int[arr.length];
        size = 0;
    }
}