public class Prime {
    public static void main(String[] args){
        System.out.println("3960 = " + prime(3960));
        System.out.println("1234 = " + prime(1234));
        System.out.println("222222 = " + prime(222222));
        System.out.println("13780 = " + prime(13780));
    }

    public static String prime(int n){
        ArrayStackDataStrucClass<Integer> stack = new ArrayStackDataStrucClass<>();
        String returnVal = "";
        int d = 2;
        while (n != 1){
            if (n % d == 0){
                stack.push(d);
                n = n/d;
            }
            else{
                d++;
            }
        }
        while(!stack.isEmpty()){
            returnVal += stack.peek() + " * ";
            stack.pop();
        }
        return returnVal.substring(0,returnVal.length()-3);
    }
}
