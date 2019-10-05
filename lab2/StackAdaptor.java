public class StackAdaptor extends MyStack
{
    MyDeque myDeque;
    
    StackAdaptor(MyDeque myDeque)
    {
        this.myDeque = myDeque;
    }

    @Override
    public void push(DLNode node)
    {
        myDeque.insertLast(node);
    }

    @Override
    public DLNode pop()
    {
        DLNode node = myDeque.last();

        myDeque.removeLast();

        return node;
    }

    @Override
    public DLNode top()
    {
        return myDeque.last();
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