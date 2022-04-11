package lab9_1;

public interface IQueue {
    public boolean isEmpty();
    public boolean isFull();
    public void enQueue(Object o);
    public Object deQueue();
    public void printQueue();
}
