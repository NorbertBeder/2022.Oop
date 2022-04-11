package lab9_1;

public class CircularQueue implements IQueue{
    private final int capacity;
    private final Object[] items;
    private int rear = -1;
    private int front = -1;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    @Override
    public boolean isFull() {
        return (front == rear + 1) || (front == 0 && rear == capacity-1);
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void enQueue(Object o) {
        if(isFull()){
            System.out.println("Queue is full");
        }else{
            if(front == -1){
                front = 0;
            }
            rear = (rear + 1) % capacity;
            items[rear] = o;
        }
    }

    @Override
    public Object deQueue() {
        Object o;
        if(!isEmpty()){
            o = items[front];
            items[front] = null;
            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front = (front + 1) % capacity;
            }
            return o;
        }
        return null;
    }


    @Override
    public void printQueue() {
        if(!isEmpty()){
            for(Object item : items) {
                if (item != null) {
                    System.out.print(item + " ");
                }
            }
            System.out.println();
        }
    }
}
