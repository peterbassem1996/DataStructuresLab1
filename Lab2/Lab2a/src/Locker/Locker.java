package Locker;

public class Locker implements Lock{
    private LockerNode numberSelected;
    private int code1;
    private int code2;
    private int code3;
    private int unlockingStage;
    private boolean open;

    public Locker(){
        this(0, 0 , 0);
    }

    public Locker(int code1, int code2, int code3){
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        unlockingStage = 0;
        open = false;
        numberSelected = new LockerNode(null, 0, null);
        LockerNode current = numberSelected;
        for (int i = 1; i < 40; i++){
            current.next = new LockerNode(current, i, null);
            current = current.next;
        }
        current.setNext(numberSelected);
        numberSelected.setPrevious(current);
    }

    public int currently() {
        return numberSelected.number;
    }

    public void reset(){
        System.out.print("You are passing by: ");
        for (int i = 0; i < 120; i++){
            System.out.print(numberSelected.number + " ");
            numberSelected = numberSelected.next;
        }
        System.out.print("\n");
        unlockingStage = 0;
    }

    public void turn(int newValue, boolean direction){
        int oldValue = numberSelected.number;
        System.out.print("You are passing by: ");
        if (direction) {
            while (numberSelected.next.number != newValue) {
                numberSelected = numberSelected.next;
                System.out.print(numberSelected.number + " ");
            }
            numberSelected = numberSelected.next;
            System.out.print(numberSelected.number + "\n");
        }
        else{
            while (numberSelected.previous.number != newValue) {
                numberSelected = numberSelected.previous;
                System.out.print(numberSelected.number + " ");
            }
            numberSelected = numberSelected.previous;
            System.out.print(numberSelected.number + "\n");
        }
        unlocking(oldValue, newValue, direction);
        //System.out.println(unlockingStage);
    }

    public void alter(int code1, int code2, int code3){
        this.code1 = code1;
        this.code2 = code2;
        this.code3 = code3;
        unlockingStage = 0;
    }

    public void close(){
        open = false;
        unlockingStage = 0;
        System.out.println("You\'ve closed the lock.");
    }

    public boolean attempt(){
        if(this.isUnlocked()){
            open = true;
            System.out.println("Vola! You\'ve successfully opened the lock.");
        }
        else{
            System.out.println("The lock is not unlocked!");
        }
        return open;
    }

    public boolean inquire(){
        return open;
    }

    //UNLOCKING MECHANISM
    /*
    Unlocking stages:
        1. make one complete revolution from where you are forward
        2. go to "code1" forwardly
        3.make one complete revolution from where you are backward
        4. go to "code2" backwardly
        5. go to "code3" forwardly
    */

    private void unlocking(int oldValue, int newValue, boolean direction){
        switch(unlockingStage){
            case 0:
                if(oldValue == newValue && direction){
                    unlockingStage++;
                    if(newValue == code1){
                        unlockingStage ++;
                    }
                }
                else{
                    unlockingStage = 6;
                }
                break;
            case 1:
                if(newValue == code1 && direction){
                    unlockingStage++;
                }
                else{
                    unlockingStage = 6;
                }
                break;
            case 2:
                if(oldValue == newValue && !direction){
                    unlockingStage++;
                    if(newValue == code2) {
                        unlockingStage++;
                    }
                }
                else{
                    unlockingStage = 6;
                }
                break;
            case 3:
                if(newValue == code2 && !direction){
                    unlockingStage++;
                }
                else{
                    unlockingStage = 6;
                }
                break;
            case 4:
                if(newValue == code3 && direction) {
                    unlockingStage++;
                }
                else{
                    unlockingStage = 6;
                }
        }
    }

    private boolean isUnlocked(){
        return (unlockingStage == 5);
    }
}
