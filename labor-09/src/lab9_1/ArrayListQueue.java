package lab9_1;

import java.util.ArrayList;

public class ArrayListQueue implements IQueue {
    private final ArrayList<Object> items = new ArrayList<>();
    private final int capacity;

    public ArrayListQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() == capacity;
    }

    @Override
    public void enQueue(Object o) {
        if(!isFull()){
            items.add(o);
        }else{
            System.out.println("Queue is full");
        }
    }

    @Override
    public Object deQueue() {
        if(!isEmpty()){
            return items.remove(0);
        }
        return null;
    }

    @Override
    public void printQueue() {
        System.out.println(items);
    }
}
