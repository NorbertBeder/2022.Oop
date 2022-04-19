package lab9_1;

public class CircularQueue implements IQueue{
    private final int CAPACITY;
    private final Object[] items;
    private int front;
    private int rear;


    public CircularQueue(int capacity){
        CAPACITY = capacity;
        items = new Object[CAPACITY];
        this.front = -1;
        this.rear = -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircularQueue that = (CircularQueue) o;
        if(this.items.length != that.items.length) return false;

        if(this.isEmpty() && that.isEmpty())
            return true;
        if(this.isEmpty()||that.isEmpty())
            return false;

        for (int i = 0; i < items.length; i++){
            int thisIndex = (this.front + i) % this.CAPACITY;
            int thatIndex = (that.front + i) % that.CAPACITY;
            if(!this.items[thisIndex].equals(that.items[thatIndex])) return false;
        }
        return true;
    }

    @Override
    public void enQueue(Object newObject) {
        if(!isFull()) {
            if(isEmpty()){
                this.front = 0;
            }
            this.rear = (this.rear + 1) % this.CAPACITY;
            this.items[this.rear] =  newObject;

        }
        else{
            System.out.println("Cant add number");
        }
    }

    @Override
    public Object deQueue() {

        if(!isEmpty()){
            Object temp = this.items[this.front];
            if(this.front == this.rear){

                this.items[this.front] = null;

                this.front = -1;
                this.rear = -1;

                return temp;
            }
            this.items[this.front] = null;
            this.front = (this.front + 1) % this.CAPACITY;
            return temp;

        }
        return null;

    }

    @Override
    public void printQueue() {
        for (int i = 0; i < this.CAPACITY; i++){
            if(isEmpty()){
                return;
            }
            int index = (i + this.front) % this.CAPACITY;
            if(this.items[index] != null) {
                System.out.print(this.items[index] + "  ");

            }
        }
        System.out.println();
    }

    @Override
    public boolean isEmpty() {
        return this.front == -1;
    }

    @Override
    public boolean isFull() {
        return (this.front == 0 && this.rear == this.CAPACITY - 1) || front == rear + 1;
    }

}
