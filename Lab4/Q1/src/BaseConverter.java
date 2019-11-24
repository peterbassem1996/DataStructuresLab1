import java.util.*;
public class BaseConverter {
    long input;
    int base;
    ListStackDataStrucClass<Integer> theStack = new ListStackDataStrucClass<>();

    public BaseConverter() {
        this.input = 0;
        this.base = 0;
    }

    public void inputPrompt(){
        Scanner usrInput = new Scanner(System.in);
        System.out.println("Please enter the number you want to convert followed bu a base you want to convert to: (base is 2 to 9)");
        input = usrInput.nextLong();
        base = usrInput.nextInt();
    }

    public void convert(){
        int highestPower = (int)(Math.log((double)input) / Math.log((double)base));
        int highestValue = base - 1;
        //System.out.println(highestPower);
        //System.out.println(highestValue);
        for(int i = highestPower; i >= 0; i--){
            for(int j = highestValue; j >= 0; j--){
                if(j*Math.pow(base, i) <= input){
                    //System.out.println("pushing");
                    input -= (j*Math.pow(base, i));
                    //System.out.println("input is " + input);
                    theStack.push(j);
                    break;
                }
            }
        }
        /*while(!theStack.isEmpty()){
            System.out.println(theStack.peek());
            theStack.pop();
        }*/
    }

    public void print(){
        String output = "(Base " + base +") " + input + " = ";
        String output2 = " = ";
        reverse();
        int power = 0;
        while(!theStack.isEmpty()){
            output += theStack.peek() + "*" + base + "^" + power + " + ";
            output2 += theStack.peek();
            theStack.pop();
            power++;
        }
        System.out.println(output.substring(0, (output.length()-3))+ output2);
    }

    private void reverse(){
        ListStackDataStrucClass<Integer> temp = new ListStackDataStrucClass<>();
        while(!theStack.isEmpty()){
            temp.push(theStack.peek());
            theStack.pop();
        }
        theStack = temp;
    }

    public void run(){
        inputPrompt();
        convert();
        print();
    }
}
