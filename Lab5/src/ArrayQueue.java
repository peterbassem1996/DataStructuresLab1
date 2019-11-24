public class ArrayQueue<T> implements QueueInterface<T>{
    protected final int DEFCAP = 100;
    protected T[] elements;
    protected int origCap;
    protected int numElements = 0;
    protected int front = 0;
    protected int rear;

    public ArrayQueue() {
        elements = (T[]) new Object[DEFCAP];
        rear = DEFCAP - 1;
        origCap = DEFCAP;
    }

    public ArrayQueue(int origCap) {
        elements = (T[]) new Object[origCap];
        rear = origCap - 1;
        this.origCap = origCap;
    }

    private void enlarge(){
        int j = front;
        T[] larger = (T[]) new Object[origCap + elements.length];
        for (int i = 0; i < numElements; i++){
            larger[i] = elements[j];
            j = (j + 1) % elements.length;
        }

        elements = larger;
        front = 0;
        rear = numElements - 1;
    }

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if(isFull()){
            enlarge();
        }
        else{
            rear = (rear + 1) % elements.length;
            elements[rear] = element;
            numElements++;
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        else {
            T returnVal = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            numElements--;
            return returnVal;
        }
    }

    @Override
    public boolean isFull() {
        return (numElements == elements.length);
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    @Override
    public T peek() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException();
        }
        else {
            T returnVal = elements[front];
            return returnVal;
        }
    }

    @Override
    public int count() {
        return numElements;
    }
}
