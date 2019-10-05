public class QueueAdaptor extends MyQueue
{
    MyDeque myDeque;
    
    QueueAdaptor(MyDeque myDeque)
    {
        this.myDeque = myDeque;
    }

    @Override
    public void enqueue(DLNode node)
    {
        myDeque.insertLast(node);
    }

    @Override
    public DLNode dequeue()
    {
        DLNode node = myDeque.first();

        myDeque.removeFirst();

        return node;
    }

    @Override
    public DLNode front()
    {
        return myDeque.first();
    }

    @Override
    public int size()
    {
        return myDeque.size();
    }

    @Override
    public String toString()
    {
        return myDeque.toString();
    }
}