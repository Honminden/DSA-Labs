public class EmptyException extends Exception
{
    static final long serialVersionUID = 114514;

    public EmptyException(String message)
    {
        super(message);
    }

    public EmptyException()
    {
        super();
    }
}