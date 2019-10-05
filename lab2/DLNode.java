public class DLNode
{
    int element;
    DLNode prev;
    DLNode next;

    DLNode(int element)
    {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public int getElement()
    {
        return this.element;
    }

    public void setElement(int Element)
    {
        this.element = element;
    }

    public DLNode getPrev()
    {
        return this.prev;
    }

    public void setPrev(DLNode prev)
    {
        this.prev = prev;
    }

    public DLNode getNext()
    {
        return this.next;
    }

    public void setNext(DLNode next)
    {
        this.next = next;
    }
}