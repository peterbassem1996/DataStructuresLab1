import java.util.*;
public class Palindrome {
    public static void main(String[] args){
        Scanner usrInput = new Scanner(System.in);
        System.out.println("Please, enter 5 sentences or words:");
        for(int i = 0; i < 5; i++){
            if(isPalindrome(usrInput.nextLine())){
                System.out.println("is a Palindrome");
            }
            else{
                System.out.println("not a Palindrome");
            }
        }
    }

    /*
    radar
    Able was I ere I saw Elba
    good
    Go Hang a Salami!  I'm a Lasagna Hog
    A man, a plan, a canal—Panama
    */
    public static boolean isPalindrome(String input){
        ArrayStackDataStrucClass<Character> letters= new ArrayStackDataStrucClass<>();
        for(int i = 0; i < input.length();i++){
            if (Character.isLetter(input.charAt(i))){
                letters.push(Character.toUpperCase(input.charAt(i)));
                //System.out.println(letters.peek());
            }
        }
        for(int i = 0; i < input.length();i++){
            if (Character.isLetter(input.charAt(i))){
                if(letters.peek().equals(Character.toUpperCase(input.charAt(i)))){
                    //System.out.println(letters.peek());
                    letters.pop();
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
