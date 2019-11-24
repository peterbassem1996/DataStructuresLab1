public class Flight {
    private int timeIntroduced;
    private int timeDone;

    public Flight(int timeIntroduced){
        this.timeIntroduced = timeIntroduced;
        timeDone = -1;
    }

    public int getTimeIntroduced() {
        return timeIntroduced;
    }

    public void setTimeIntroduced(int timeIntroduced) {
        this.timeIntroduced = timeIntroduced;
    }

    public int getTimeDone() {
        return timeDone;
    }

    public void setTimeDone(int timeDone) {
        this.timeDone = timeDone;
    }

    @Override
    public String toString(){
        return("introduced at: " + timeIntroduced + " done at: " + timeDone);

    }
}
