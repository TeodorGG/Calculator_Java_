package tudor.calculator;

public class Messages {

    public static void printHeader(){
        System.out.println("*************************\n" +
                           "*                       *\n" +
                           "*      Калькулятор      *\n" +
                           "*                       *\n" +
                           "*************************");
    }

    public static void printMenu(){
        System.out.println("\n\n\nВыберите \n" +
                "\t1. Ввести строку\n" +
                "\t2. Выход");
    }

    public static void printInput(){
        System.out.print("\nВведите строку :");
    }

    public static void printResult(String e, String r){
        System.out.print(e + " = " + r);
    }

    public static void printError(String error){
        System.err.println("\nОшибка : " + error);
        throw new Error();
    }
}
