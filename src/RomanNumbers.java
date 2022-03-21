import java.util.HashMap;
import java.util.Map;

public class RomanNumbers implements CalculationsOnNumbers{

    String[] romanNum = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    int [] arabNum = {100, 90, 50, 40, 10, 9, 5, 4, 1};

    public int romanNumConversion(String a, int b) {

        int romanNumArray = 0;

        Map<String, Integer> romanNum = new HashMap<>();
        romanNum.put("I", 1);
        romanNum.put("II", 2);
        romanNum.put("III", 3);
        romanNum.put("IV", 4);
        romanNum.put("V", 5);
        romanNum.put("VI", 6);
        romanNum.put("VII", 7);
        romanNum.put("VIII", 8);
        romanNum.put("IX", 9);
        romanNum.put("X", 10);

        for (Map.Entry<String, Integer> item : romanNum.entrySet()) {
            if (item.getKey().equals(a)) {
                romanNumArray = item.getValue();
            }
        }
        return romanNumArray;
    }

    @Override
    public int addition(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int subtraction(int num1, int num2) {
        int subtraction = num1 - num2;
        if (subtraction == 0){
           return 0;
        }
        else if (subtraction < 0){
            return -1;
        }
        else {
            return subtraction;
        }
    }

    @Override
    public int multiplication(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int division(int num1, int num2) {
        return num1 / num2;
    }

    public String conversionNumToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arabNum.length; i++){
            while (num >= arabNum[i]) {
                num -=arabNum[i];
                sb.append(romanNum[i]);
            }
        }
        return sb.toString();
    }
}
