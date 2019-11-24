public interface ArrayStackADT<T> {
    public abstract void initializeStack();
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract void push(T element);
    public abstract T peek();
    public abstract void pop();
}
