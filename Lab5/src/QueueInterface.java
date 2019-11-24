public interface QueueInterface<T> {
    void enqueue(T element) throws QueueOverflowException;
    //adds an element to the rear end of the queue
    //throws a QueueOverflowException if the queue is full

    T dequeue () throws  QueueUnderflowException;
    //remove and return the element at the front end of the queue
    //throws a QueueUnderflowException if the queue is empty

    boolean isFull();
    //returns true if the queue is full else returns false

    boolean isEmpty();
    //returns true if the queue is empty else returns false

    T peek () throws QueueUnderflowException;
    //returns without removing the element at the front end
    //throws a QueueUnderflowException if the queue is empty

    int count();
    //returns the number of elements in the queue
}
