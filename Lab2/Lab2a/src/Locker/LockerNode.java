package Locker;

public class LockerNode {
    protected LockerNode previous;
    protected int number;
    protected LockerNode next;

    protected LockerNode(LockerNode previous, int number, LockerNode next){
        this.previous = previous;
        this.number = number;
        this.next = next;
    }

    public void setPrevious(LockerNode previous) {
        this.previous = previous;
    }

    public void setNext(LockerNode next) {
        this.next = next;
    }
}
