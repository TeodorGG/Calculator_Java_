package tudor.calculator;

import java.util.Scanner;

public class Logic {

    private String expression;
    private String result;
    private boolean roman = false;

    Logic(){}

    private void checkOperations() {
        String e = getExpression();
        if(checkCorrectSyntaxOfOperation(e)){
            Messages.printError("Данная арифметическая операция не поддерживается");
        }

        SwitchSubstring.of(e)
                .when("+", ()->calculate( 0, "+"))
                .when("-", ()->calculate( 1, "-"))
                .when("/", ()->calculate( 2, "/"))
                .when("*", ()->calculate( 3, "*"))
                .orElse(()->  Messages.printError("Данная арифметическая операция не поддерживается"));
    }

    private void calculate(int v, String e){
        int pos, v1, v2;
        String ex = getExpression();
        pos = ex.indexOf(e);
        setExpression(ex.substring(0, pos) + " " + e +" " + ex.substring(pos+1));
        pos = ex.indexOf(e);

        Scanner s1 = new Scanner(ex.substring(0, pos));
        Scanner s2 = new Scanner(ex.substring(pos+1));

        if(checkCorrectSyntaxOfNumber(pos)){
            v1 = RomanNumber.roman2integer(s1.nextLine().replaceAll(" ", ""));
            v2 = RomanNumber.roman2integer(s2.nextLine().replaceAll(" ", ""));
            setRoman(true);
        } else {


            v1 = s1.nextInt();
            v2 = s2.nextInt();

            if(s1.hasNext() || s2.hasNext()){
                Messages.printError("Данные повреждены");
            }
        }

        if (checkLimit(v1, v2)) {
            switch (v) {
                case 0 -> setResult(String.valueOf(v1 + v2));
                case 1 -> setResult(String.valueOf(v1 - v2));
                case 2 -> setResult(String.valueOf(v1 / v2));
                case 3 -> setResult(String.valueOf(v1 * v2));
                default -> Messages.printError("Данная арифметическая операция не поддерживается");
            }
        }

    }

    private boolean checkCorrectSyntaxOfNumber(int pos) {
        String ex = getExpression();
        String v1 = new Scanner(ex.substring(0, pos)).nextLine().replaceAll(" ", "");
        String v2 = new Scanner(ex.substring(pos+2)).nextLine().replaceAll(" ","");

        boolean c1 = RomanNumber.isRoman(v1);
        boolean c2 = RomanNumber.isRoman(v2);
        if(c1 && c2){
            return true;
        } else if(!c1 && !c2){
            return false;
        } else{
            Messages.printError("Цифры должны быть из одной системе счисления.");
            return false;
        }
    }

    private boolean checkLimit(int v1, int v2) {
        if( (v1 <= 10 && v1 >= 1) && (v2 <= 10 && v2 >= 1) ){
            return true;
        } else {
            Messages.printError("Ошибка диапазона : введенное значение меньше 10 и больше 1");
            return false;
        }
    }

    public static boolean checkCorrectSyntaxOfOperation(String e){

        String[] c = {"+", "-", "/", "*"};

        int l = c.length;
        for(int i = 0 ; i < l ; i++)
            for(int j = i ; j < l ; j++){
                boolean c1 = e.contains(c[i]) && e.contains(c[j]);
                boolean c2 = e.indexOf(c[i]) != e.lastIndexOf(c[i]) && e.contains(c[i]);

                if(c1 && c2)
                    return true;
            }

        return false;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    public String getResult() {
        checkOperations();
        return result;
    }

    public void setResult(String result) {
        if(isRoman()){
            this.result = RomanNumber.integer2roman(Integer.parseInt(result));
        } else{
            this.result = result;
        }
    }

    public boolean isRoman() {
        return roman;
    }

    public void setRoman(boolean roman) {
        this.roman = roman;
    }
}
