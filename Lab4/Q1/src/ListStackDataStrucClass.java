public class ListStackDataStrucClass<T> implements ListStackADT<T>{
    private class StackNode<T>{
        private T value;
        private StackNode<T> next;

        public StackNode() {
            this.value = null;
            this.next = null;
        }

        public StackNode(T value, StackNode next) {
            this.value = value;
            this.next = next;
        }

        public StackNode(StackNode<T> sn) {
            this.value = sn.getValue();
            this.next = sn.getNext();
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public StackNode getNext() {
            return next;
        }

        public void setNext(StackNode next) {
            this.next = next;
        }
    }

    private StackNode<T> top;

    public ListStackDataStrucClass(StackNode top) {
        this.top = top;
    }

    public ListStackDataStrucClass() {
        this.top = null;
    }

    public ListStackDataStrucClass(ListStackDataStrucClass ls) {
        this.top = ls.top;
    }

    private StackNode getTop() {
        return top;
    }

    private void setTop(StackNode top) {
        this.top = top;
    }

    public boolean isEmpty(){
        //System.out.println(top == null);
        return (top == null);
    }

    public void push(T val){
        StackNode<T> newNode = new StackNode<>(val, top);
        top = newNode;
    }

    public void pop(){
        if(this.isEmpty()){
            throw new StackUnderflowException("Empty Stack!");
        }
        else{
            top = top.getNext();
        }
    }

    public T peek(){
        if(this.isEmpty()){
            throw new StackUnderflowException("Empty Stack!");
        }
        else{
            return top.getValue();
        }
    }

    @Override
    public String toString() {
        return "Top: " + top.getValue();
    }
}
