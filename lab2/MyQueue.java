public abstract class MyQueue { 
    //enqueue a node  
    public abstract void enqueue(DLNode node); //dequeue a node  
    public abstract DLNode dequeue();
    //return front node of queue  
    public abstract DLNode front();
    //return number of nodes  
    public abstract int size();
}