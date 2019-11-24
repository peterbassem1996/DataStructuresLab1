import java.util.*;
public class Main {
    public static void main(String[] args){
        final double LANDING_TIME = 3;
        final double TAKE_OFF_TIME = 2;
        final double LANDING_RATE  = 10;
        final double TAKE_OFF_RATE = 10;
        final int ITERATIONS = 1440;
        Random generator = new Random(System.currentTimeMillis( ));
        ArrayQueue<Flight> toLand = new ArrayQueue<>();
        ArrayQueue<Flight> toTakeOff = new ArrayQueue<>();
        int freeOn = 0;
        int toTakeOffLength = 0;
        int toLandLength = 0;

        int landingTime = 0;
        int takeOffTime = 0;

        int landing = 0;
        int takingOff = 0;

        int timeInTakingOffQue = 0;
        int timeInLandingQue = 0;

        for(int time = 0; time < ITERATIONS; time++){
            if(generator.nextDouble() < LANDING_RATE/60){
                toLand.enqueue(new Flight(time));
                //System.out.println(toLand.dequeue());

            }
            if(generator.nextDouble() < TAKE_OFF_RATE/60){
                toTakeOff.enqueue(new Flight(time));
                //System.out.println(toTakeOff.dequeue());

            }
            if(time >= freeOn){
                if(!toLand.isEmpty()){
                    Flight L = toLand.dequeue();
                    L.setTimeDone(time + (int)LANDING_TIME);
                    //System.out.println("Landing " + L + " serviced at " + time);
                    freeOn = time + (int)LANDING_TIME;
                    landingTime += (L.getTimeDone()-L.getTimeIntroduced());
                    timeInLandingQue += (time-L.getTimeIntroduced());
                    landing++;
                }
                else if(!toTakeOff.isEmpty()){
                    Flight T = toTakeOff.dequeue();
                    T.setTimeDone(time + (int)TAKE_OFF_TIME);
                    //System.out.println("taking off " + T + " serviced at " + time);
                    freeOn = time + (int)TAKE_OFF_TIME;
                    takeOffTime += (T.getTimeDone()-T.getTimeIntroduced());
                    timeInTakingOffQue += (time-T.getTimeIntroduced());
                    takingOff++;
                }
            }
            //System.out.println(toTakeOff.count());
            //System.out.println(toLand.count());

            toTakeOffLength += toTakeOff.count();
            toLandLength += toLand.count();
        }

        System.out.printf("Average landing queue length: %.6f\n", (double) toLandLength / (double)ITERATIONS);
        System.out.printf("Average take off queue length: %.6f\n\n", (double)toTakeOffLength / (double)ITERATIONS);

        System.out.printf("Average landing queue time (Wait time to get serviced): %.6f\n", (double)timeInLandingQue/ (double)landing);
        System.out.printf("Average take off queue time (Wait time to get serviced): %.6f\n\n", (double)timeInTakingOffQue/ (double)takingOff);

        System.out.printf("Average landing time (time taken to get the service done): %.6f\n", (double)landingTime/ (double)landing);
        System.out.printf("Average take off time (time taken to get the service done): %.6f\n\n", (double)takeOffTime/ (double)takingOff);
    }

}
