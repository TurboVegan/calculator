import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void lethalException(String message) {
        try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("\nthrows Exception //т.к. " + message);
            System.exit(1);
        }
    }
    public static void generalInputCheck(String input){
        char[] charArray = input.toCharArray();
        for (char element : charArray) {
            if ((element == '0') || (element == '1') || (element == '2') || (element == '3') || (element == '4') || (element == '5') ||
                    (element == '6') || (element == '7') || (element == '8') || (element == '9') || (element == ' ') || (element == '+') ||
                    (element == '-') || (element == '*') || (element == '/') || (element == 'I') || (element == 'V') || (element == 'X') ||
                    (element == 'L') || (element == 'C') || (element == 'D') || (element == 'M')) {
            } else {
                lethalException("на вход принимаются только два целых числа от 1 до 10 и одна математическая операция");
            }
        }
    }
    public static boolean NumericSystemsCollision(String[] postPostInput) {
        String s = String.join("", postPostInput);
        if ((s.contains("0") || s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") ||
                s.contains("7") || s.contains("8") || s.contains("9")) && (s.contains("I") || s.contains("V") || s.contains("X") ||
                s.contains("L") || s.contains("C") || s.contains("D") || s.contains("M"))) {
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean arabicNumbersCheck(String input){
        char[] charArray = input.toCharArray();
        for (char element : charArray) {
            int postElement = element;
            if ((48 <= postElement && postElement <= 57) || (postElement == 42) || (postElement == 43) ||
                    (postElement == 45) || (postElement == 47) || (postElement == 32)) {
            } else{
                return false;
            }
        }
        return true;
    }
    public static String[] mathExpressionToArray(String input){
        String postInput = input.replaceAll("\\s+", "");
        String[] postPostInput = postInput.split("[-+*/]");
        return postPostInput;
    }
    public static String string1Getter (String [] input){
        String string1 = input [0];
        return string1;
    }
    public static String string2Getter (String [] input){
        String string2 = input [1];
        return string2;
    }
    public static int RomanToInt(String input){
        Map <Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for (int i = 0; i < input.length(); i++){
            if ((i > 0) && map.get(input.charAt(i)) > map.get(input.charAt(i - 1))){
                result += map.get(input.charAt(i)) - 2 * map.get(input.charAt(i - 1));
            }else {
                result += map.get(input.charAt(i));
            }
        }
        return result;
    }
    public static void elementsNumberCheck (String input) {
        int length = mathExpressionToArray(input).length;
        switch (length) {
            case 2:
                break;
            case 1:
                lethalException("строка не является математической операцией");
            default:
                lethalException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
    }
    public static void magnitudeCheck (String input){
        int number1 = 0; int number2 = 0;
        if (NumericSystemsCollision(mathExpressionToArray(input))){
            lethalException("используются одновременно разные системы счисления");
        }
        else if(arabicNumbersCheck(input)){
            number1 = Integer.parseInt(mathExpressionToArray(input)[0]);
            number2 = Integer.parseInt(mathExpressionToArray(input)[1]);
        }
        else {
            number1 = RomanToInt(string1Getter(mathExpressionToArray(input)));
            number2 = RomanToInt(string2Getter(mathExpressionToArray(input)));
        }
        if((0 < number1 && number1 <= 10) && (0 < number2 && number2 <= 10)){
        } else{
            lethalException("на вход принимаются два числа от 1 до 10 включительно, не более, не менее");

        }
    }
    public static String operationSignReturner(String input){
        String postInput = input.replaceAll("\\s+", "");
        String[] preSign = postInput.split("[0-9A-Za-z]");
        String sign = String.join("", preSign);
        return sign;
    }
    public static void signChecker (String input){
        String sign = operationSignReturner(input);
        switch (sign.length()){
            case 1:
                break;
            default:
                lethalException("на вход принимается только один операнд");
        }
    }
    public static String intToRoman(int input) {
        if (input < 0){
            lethalException("в римской системе нет отрицательных чисел");
        }
        if (input == 0){
            lethalException("в римской системе нет нуля");
        }
        if (input > 3999){
            lethalException("в римской системе 3999 является порогом");
        }
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;
    }
    public static int inputToMathOperationResult(int number1, int number2, String sign){
        int result = 0;
        switch (sign) {
            case "/":
                result = number1 / number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
        }
        return result;
    }
    public static String mathOperationPrintOut(String input){
        int number1 = 0; int number2 = 0;
        if(arabicNumbersCheck(input)){
            number1 = Integer.parseInt(mathExpressionToArray(input)[0]);
            number2 = Integer.parseInt(mathExpressionToArray(input)[1]);
            String sign = operationSignReturner(input);
            String output = String.valueOf(inputToMathOperationResult(number1, number2, sign));
            System.out.println("\nOutput: " + output);
            return output;
        }
        else {
            number1 = RomanToInt(string1Getter(mathExpressionToArray(input)));
            number2 = RomanToInt(string2Getter(mathExpressionToArray(input)));
            String sign = operationSignReturner(input);
            String output = intToRoman(inputToMathOperationResult(number1, number2, sign));
            System.out.println("\nOutput: " +  output);
            return output;
        }
    }
    public static String calc(String input){
        generalInputCheck(input);
        elementsNumberCheck(input);
        magnitudeCheck(input);
        signChecker(input);
        return mathOperationPrintOut(input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("\nInput: ");
        calc(sc.nextLine());
    }
}



