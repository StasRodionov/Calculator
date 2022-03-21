import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите два операнда (римские от I до X или арабские от 1 до 10)\nи один оператор (+, -, /, *):");
        String expression = bufferedReader.readLine();
        String[] arrayExpression = expression.split(" ");
        RomanNumbers romanNumbers = new RomanNumbers();
        ArabicNumders arabicNumders = new ArabicNumders();

        int[] arrayRoman = new int[2];
        int numRomanDigit = 0;
        int indexArray = 0;

        if (arrayExpression.length <= 2) {
            System.out.println("Строка не является математической операцией");
            return;
        } else {
            try {
                for (int i = 0; i < arrayExpression.length; i += 2) {
                    try {
                        if (Integer.parseInt(arrayExpression[i]) > 0 && Integer.parseInt(arrayExpression[i]) <= 10) {
                            arrayRoman[indexArray] = Integer.parseInt(arrayExpression[i]);
                        } else {
                            System.out.println("Введенный операнд не соответсвует условию");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        arrayRoman[indexArray] = romanNumbers.romanNumConversion(arrayExpression[i], indexArray);
                        numRomanDigit++;
                    }
                    if (arrayRoman[indexArray] == 0) {
                        System.out.println("Введенный операнд не соответсвует условию");
                        return;
                    } else {
                        indexArray++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                return;
            }
        }
        System.out.println("Output:");
        if (numRomanDigit % 2 == 0 && numRomanDigit > 0) {
            if (arrayExpression[1].equals("+")) {
                System.out.println(romanNumbers.conversionNumToRoman(
                        romanNumbers.addition(arrayRoman[0], arrayRoman[1])));
            }
            if (arrayExpression[1].equals("-")) {
                if(romanNumbers.subtraction(arrayRoman[0], arrayRoman[1]) == 0){
                    System.out.println("Значение не может равное 0");
                }
                else if(romanNumbers.subtraction(arrayRoman[0], arrayRoman[1]) < 0) {
                    System.out.println("Значение не может быть отрицательным");
                }
                else {
                    System.out.println(romanNumbers.conversionNumToRoman(
                            romanNumbers.subtraction(arrayRoman[0], arrayRoman[1])));
                }
            }
            if (arrayExpression[1].equals("*")) {
                System.out.println(romanNumbers.conversionNumToRoman(
                        romanNumbers.multiplication(arrayRoman[0], arrayRoman[1])));
            }
            if (arrayExpression[1].equals("/")) {
                System.out.println(romanNumbers.conversionNumToRoman(
                        romanNumbers.division(arrayRoman[0], arrayRoman[1])));
            }
        } else if (numRomanDigit > 0) {
            System.out.println("Используются одновременно разные системы счисления");
        } else {
            if (arrayExpression[1].equals("+")) {
                System.out.println(arabicNumders.addition(arrayRoman[0], arrayRoman[1]));
            }
            if (arrayExpression[1].equals("-")) {
                System.out.println(arabicNumders.subtraction(arrayRoman[0], arrayRoman[1]));
            }
            if (arrayExpression[1].equals("*")) {
                System.out.println(arabicNumders.multiplication(arrayRoman[0], arrayRoman[1]));
            }
            if (arrayExpression[1].equals("/")) {
                System.out.println(arabicNumders.division(arrayRoman[0], arrayRoman[1]));
            }
        }
    }
}

