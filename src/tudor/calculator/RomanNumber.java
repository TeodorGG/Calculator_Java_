package tudor.calculator;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    public static int roman2integer(String s) {
        Map<Character,Integer> numbersMap = new HashMap<>();
        numbersMap.put('I',1);
        numbersMap.put('V',5);
        numbersMap.put('X',10);
        numbersMap.put('L',50);
        numbersMap.put('C',100);
        numbersMap.put('D',500);
        numbersMap.put('M',1000);

        int result = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(i > 0 && numbersMap.get(ch) > numbersMap.get(s.charAt(i - 1)))
                result += numbersMap.get(ch) - 2*numbersMap.get(s.charAt(i - 1));
            else
                result += numbersMap.get(ch);
        }

        return result;
    }

    public static String integer2roman(int s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder roman = new StringBuilder();

        for(int i = 0 ; i < values.length ; i++) {
            while(s >= values[i]) {
                s -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public static boolean isRoman(String s) {
        return !s.isEmpty()
                && s.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
    }
}
