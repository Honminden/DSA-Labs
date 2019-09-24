public class Node
{
    int value;
    Node previous;
    Node next;

    public Node(int value)
    {
        this(value, null, null);
    }

    public Node(int value, Node previous, Node next)
    {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }
}