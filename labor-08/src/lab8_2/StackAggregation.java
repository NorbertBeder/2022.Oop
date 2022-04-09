package lab8_2;

import java.util.ArrayList;

public class StackAggregation {
    private final int capacity;
    private final ArrayList<Object> items = new ArrayList<>();

    public StackAggregation(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull(){
        return items.size() == capacity;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void push(Object item){
        this.items.add(item);
    }

    public void pop() {
        if (!items.isEmpty()) {
            items.remove(items.size() - 1);
        }else{
            System.out.println("Stack is empty");
        }
    }

    public Object top(){
        if(items.isEmpty()) {
            return null;
        }
        return items.get(items.size()-1);
    }

    public int getSize(){
        return items.size();
    }

}
