package tudor.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Messages.printHeader();
        Logic logic = new Logic();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        int v = -1;
        while (!exit){

            Messages.printMenu();
            v = scanner.nextInt();

            switch (v){
                case 1:
                    scanner = new Scanner(System.in);
                    Messages.printInput();
                    logic.setExpression(scanner.nextLine());

                    Messages.printResult(logic.getExpression(), logic.getResult());
                    break;
                case 2:
                    exit = true;
                    break;

            }

        }

    }
}
