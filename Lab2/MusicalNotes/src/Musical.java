public interface Musical {
    public abstract void setLength(int length);
    /*
    This method allows the client to set the length.
    parameters: length
    pre condition: length should be from 0 to 4:
        o for sixteenth note
        1 for eighth note
        2 for quarter note
        3 for half note
        4 for whole note
        NOTE: IT IS THE CLIENTS RESPONSIBILITY TO CHECK FOR THE PRE CONDITION.
     post condition: this.length = length
     */

    public abstract void setValue(int value);
    /*
    This method allows the client to set the value.
    parameters: value
    pre condition: value should be from -9 to 2:
        -9: C, 0: A, 2: B
        NOTE: IT IS THE CLIENTS RESPONSIBILITY TO CHECK FOR THE PRE CONDITION.
     post condition: this.length = length
     */

    public abstract String retrieveLength();
    /*
    This method allows the client to retrieve the string value that corresponds to the length int.
    throws illegalArgumentException;
    */

    public abstract String retrieveValue();
    /*
    This method allows the client to retrieve the string value that corresponds to the value int.
    throws illegalArgumentException;
    */

    public abstract String naturalOrSharp();
    /*
    Tells the client whether the value corresponds to a sharp or a natural note.
    throws illegalArgumentException;
    */

    public abstract double getFrequency();
    /*
    returns the frequency = 440 * 2^(n/12)
     */
}
