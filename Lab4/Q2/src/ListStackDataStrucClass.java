public class ListStackDataStrucClass<T> {
    private class StackNode<T>{
        private T value;
        private StackNode next;

        public StackNode() {
            this.value = null;
            this.next = null;
        }

        public StackNode(T value, StackNode next) {
            this.value = value;
            this.next = next;
        }

        public StackNode(StackNode<T> SN) {
            this.value = SN.getValue();
            this.next = SN.getNext();
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
}
