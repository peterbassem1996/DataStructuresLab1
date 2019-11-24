package Locker;

public interface Lock {
    public abstract int currently();
    //returns the point which the nob is pointing to

    public abstract void alter(int code1, int code2, int code3);
    //changes the the code to a new one
    //parameters: code1, code2, code3
    //pre condition: the three parameters need to be in the rang of 0 to 39
    //post condition: The code is changed, the unlocking stage is reset

    public abstract void reset();
    //resets the lock
    //post condition: unlocking stage is reset

    public abstract void turn(int newValue, boolean direction);
    //lets you turn the nob in a certain direction to a certain number
    //parameters: newValue, direction
    //pre condition: new values needs to be from 0 to 39
    //post condition: current position is changed

    public abstract boolean attempt();
    //tries to open the lock

    public abstract boolean inquire();
    // tells you if the lock is open or shut

    public abstract void close();
    //closes the lock after it is opened
}
