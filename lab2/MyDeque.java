public class MyDeque
{
    DLNode header;
    DLNode trailer;
    int size = 0;

    MyDeque(DLNode node)
    {
        header = new DLNode(0);
        trailer = new DLNode(0);
        
        if (node == null)
        {
            header.next = trailer;
            trailer.prev = header;
        }
        else
        {
            node.prev = header;
            node.next = trailer;

            header.next = node;
            trailer.prev = node;
        }
    }

    public void insertFirst(DLNode node)
    {
        if (node == null)
        {
            return;
        }
        else
        {
            node.prev = header;
            node.next = header.next;

            header.next.prev = node;
            header.next = node;

            size++;
        }
    }

    public DLNode removeFirst()
    {
        DLNode node = header.next;

        if (header.next == trailer)
        {
            return null;
        }
        else
        {
            node.next.prev = header;
            header.next = node.next;
    
            node.prev = null;
            node.next = null;

            size--;
    
            return node;
        }
    }

    public void insertLast(DLNode node)
    {
        if (node == null)
        {
            return;
        }
        else
        {
            node.next = trailer;
            node.prev = trailer.prev;

            trailer.prev.next = node;
            trailer.prev = node;

            size++;
        }
    }

    public DLNode removeLast()
    {
        DLNode node = trailer.prev;

        if (trailer.prev == header)
        {
            return null;
        }
        else
        {
            node.prev.next = trailer;
            trailer.prev = node.prev;
    
            node.prev = null;
            node.next = null;

            size--;
    
            return node;
        }
    }

    public DLNode first()
    {
        if (header.next == trailer)
        {
            return null;
        }
        else
        {
            return header.next;
        }
    }

    public DLNode last()
    {
        if (trailer.prev == header)
        {
            return null;
        }
        else
        {
            return trailer.prev;
        }
    }

    public int size()
    {
        return this.size;
    }

    public boolean isEmpty()
    {
        return (size <= 0);
    }

    public String toString()
    {
        String s = "";

        DLNode thisNode = header.next;

        while (thisNode != trailer)
        {
            s += thisNode.element + " ";

            thisNode = thisNode.next;
        }

        return s;
    }
}