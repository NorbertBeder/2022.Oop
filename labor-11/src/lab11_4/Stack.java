package lab11_4;

import java.util.ArrayList;

public class Stack {
    private final int capacity;
    private final ArrayList<Object> items = new ArrayList<>();

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return items.size() == capacity;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void push(Object item) throws StackException {
        if(this.isFull()){
            throw new StackException("Stack is full!");
        }

        this.items.add(item);
    }

    public void pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        items.remove(items.size() - 1);
    }

    public Object top() throws StackException {
        if(items.isEmpty()) {
            throw new StackException("Stack is empty!");
        }
        return items.get(items.size()-1);
    }

    public int getSize(){
        return items.size();
    }

}
