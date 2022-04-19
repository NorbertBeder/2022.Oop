package lab9_1;

public interface IQueue {
    boolean isEmpty();
    boolean isFull();
    void enQueue(Object o);
    Object deQueue();
    void printQueue();
}
