public class List
{
    int size;
    Node head;
    Node tail;

    public List()
    {
        this(1024);
    }

    public List(int capacity)
    {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size()
    {
        return size;
    }

    public int get(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node thisNode = head;

            while (true)
            {
                if (index == 0)
                {
                    // return this node's value
                    return thisNode.value;
                }
                else
                {
                    thisNode = thisNode.next;
                    index--;
                }
            }
        }
    }

    public void add(int index, int value) throws IndexOutOfBoundsException
    {
        Node node = new Node(value);

        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node thisNode = null;
            if (head == null)
            {
                head = tail = node;
                size++;
            }
            else
            {
                thisNode = head;
                while (true)
                {
                    if (index == 0)
                    {
                        // insert before this node
                        node.next = thisNode;
                        if (thisNode == null)
                        {
                            tail = node;
                            node.previous.next = node;
                        }
                        else
                        {
                            thisNode.previous = node;
                            if (thisNode == head)
                            {
                                head = node;
                            }
                        }
                        
                        size++;
                        break;
                    }
                    else
                    {
                        node.previous = thisNode;
                        thisNode = thisNode.next;
                        index--;
                    }
                }
            }
        }
    }

    public void remove(int index) throws IndexOutOfBoundsException
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException();
        }
        else
        {
            Node thisNode = head;

            while (true)
            {
                Node previousNode = thisNode.previous;
                Node nextNode = thisNode.next;

                if (index == 0)
                {
                    // remove this node
                    if (thisNode == head)
                    {
                        head = nextNode;
                    }
                    if (thisNode == tail)
                    {
                        tail = previousNode;
                    }

                    if (nextNode != null)
                    {
                        nextNode.previous = previousNode;
                    }
                    if (previousNode != null)
                    {
                        previousNode.next = nextNode;
                    }

                    thisNode.previous = null;
                    thisNode.next = null;
                        
                    size--;
                    break;
                }
                else
                {
                    thisNode = thisNode.next;
                    index--;
                }
            }
        }
    }
}