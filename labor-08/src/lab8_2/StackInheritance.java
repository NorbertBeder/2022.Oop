package lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {

    private final int capacity;

    public StackInheritance(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object o){
        add(o);
    }
    public boolean isFull(Object o){
        return size() == capacity;
    }

    public boolean isEmpty(Object o){
        return isEmpty();
    }


    public void pop() {
        if (!isEmpty()) {
            remove(size() - 1);
        }else{
            System.out.println("Stack is empty");
        }
    }

    public Object top(){
        if(isEmpty()) {
            return null;
        }
        return get(size()-1);
    }

    public int getSize(){
        return size();
    }

}
