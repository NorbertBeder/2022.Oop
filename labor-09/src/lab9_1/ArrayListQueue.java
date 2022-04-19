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
        return !items.isEmpty();
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
        if(isEmpty()){
            return items.remove(0);
        }
        return null;
    }

    @Override
    public void printQueue() {
        System.out.println(items);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArrayListQueue that = (ArrayListQueue) o;

        if(this.items.size() != that.items.size()) {
            return false;
        }

        for (int i = 0; i < items.size(); i++){
            if(!this.items.get(i).equals(that.items.get(i))) {
                return false;
            }
        }

        return true;
    }


}
