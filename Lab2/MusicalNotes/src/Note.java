public class Note implements Musical{
    private int length;
    private int value;

    public Note(){
        length = 2;
        value = -9;
    }

    @Override
    public void setLength(int length){
        this.length = length;
    }

    @Override
    public void setValue(int value){
        this.value = value;
    }

    @Override
    public String retrieveLength(){
        switch (length){
            case 0:
                return "16th note";
            case 1:
                return "8th note";
            case 2:
                return "1/4 note";
            case 3:
                return "1/2 note";
            case 4:
                return "whole note";
            default:
                throw new IllegalArgumentException("the length passed to this object is not valid!");
        }
    }

    @Override
    public String retrieveValue() {
        switch (value) {
            case -9:
                return "C";
            case -8:
                return "C#";
            case -7:
                return "D";
            case -6:
                return "D#";
            case -5:
                return "E";
            case -4:
                return "F";
            case -3:
                return "F#";
            case -2:
                return "G";
            case -1:
                return "G#";
            case 0:
                return "A";
            case 1:
                return "A#";
            case 2:
                return "B";
            default:
                throw new IllegalArgumentException("the value passed to this object is not valid!");
        }
    }

    @Override
    public String naturalOrSharp(){
        if(this.retrieveValue().substring(1).equals("#")){
            return "Sharp";
        }
        else{
            return "Natural";
        }
    }

    @Override
    public double getFrequency(){
        return (440 * Math.pow(2, (double)value/12));
    }

    @Override
    public String toString(){

        return "This note is a " + this.retrieveLength() + ", " + this.retrieveValue().charAt(0) + " " + naturalOrSharp() + " of a frequency of " + String.format("%6.2f", this.getFrequency());
    }
}
