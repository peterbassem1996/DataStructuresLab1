public class ArrayStackDataStrucClass<T> implements ArrayStackADT<T>{
    private T[] arr;
    private int topPosition;
    private int maxCap;

    public ArrayStackDataStrucClass(){
        maxCap = 100;
        topPosition = 0;
        arr = (T[])(new Object[maxCap]);
    }

    public ArrayStackDataStrucClass(int maxCap) {
        this.maxCap = maxCap;
        topPosition = 0;
        arr = (T[])(new Object[maxCap]);
    }

    public ArrayStackDataStrucClass(ArrayStackDataStrucClass stack){
        this.maxCap = stack.maxCap;
        topPosition = 0;
        arr = (T[])(new Object[maxCap]);
        for(int i = 0; i < stack.arr.length; i++){
            this.arr[i] = (T)stack.arr[i];
            topPosition++;
        }
    }

    public void initializeStack(){
        for(int i = 0; i < topPosition; i++){
            arr[i] = null;
        }
        topPosition = 0;
    }

    public boolean isEmpty(){
        return (this.topPosition == 0);
    }

    public boolean isFull(){
        return(this.topPosition == maxCap);
    }

    public void push(T element){
        if(this.isFull()){
            throw new StackOverflowException("full stack!");
        }
        else{
            this.arr[topPosition] = element;
            topPosition++;
        }
    }

    public T peek(){
        if(this.isEmpty()){
            throw new StackUnderflowException("Empty stack!");
        }
        return this.arr[topPosition - 1];
    }

    public void pop(){
        if(this.isEmpty()){
            throw new StackUnderflowException("Empty stack!");
        }
        else{
            this.arr[topPosition - 1] = null;
            topPosition--;
        }
    }

}
