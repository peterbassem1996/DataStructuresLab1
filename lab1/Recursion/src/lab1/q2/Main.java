package lab1.q2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String hexVal;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a HEX value: ");
        hexVal = input.next();
        try{
            System.out.println("The value of " + hexVal + " in decimal is " + hex2Dec(hexVal));
        }
        catch (NumberFormatException ex){
            System.out.println("The entered value is not a hex Value!");
        }
    }

    public static int hex2Dec(String input) throws NumberFormatException {
        if (input.length() == 1) {
            return convertHexToDecimal(input.charAt(0));
        } else {
            return (int) ((convertHexToDecimal(input.charAt(0)) * Math.pow(16, input.length() - 1)) + hex2Dec(input.substring(1)));
        }
    }

    public static int convertHexToDecimal(char hex) throws NumberFormatException {
        switch (hex) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'a':
                return 49;
            case 'A':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                throw new NumberFormatException();
        }
    }
}
