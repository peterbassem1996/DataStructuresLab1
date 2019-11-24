public interface ListStackADT<T> {
    public abstract boolean isEmpty();
    public abstract void push(T val);
    public abstract void pop();
    public abstract T peek();
    public abstract String toString();
}
