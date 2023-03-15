import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("=====================");
        System.out.println("| Simple Calculator |");
        System.out.println("=====================\n");
        System.out.println("Which operation would you like to use? (Enter an operator then press enter)\n");

        char chosenOperator = ' ';
        char[] validOperators = { '+', '-', '*', '/' };

        Scanner sc = new Scanner(System.in);
        boolean isValid = false;
        do {
            // Display options
            System.out.println("[+]: Addition");
            System.out.println("[-]: Subtraction");
            System.out.println("[*]: Multiplication");
            System.out.println("[/]: Division");

            try {
                chosenOperator = sc.next().charAt(0);

                // Check if operator is vaild
                for (char operator : validOperators) {
                    if (chosenOperator == operator) {
                        isValid = true;
                    }
                }

                if (isValid == false) {
                    System.out.println("Invalid option, please try again:\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid option, please try again:\n");
            }
        } while (isValid != true);

        // Get numerical inputs
        double number1 = getDouble(sc, "first");
        double number2 = getDouble(sc, "second");

        // Check for impossible arithmetic
        boolean isDividingByZero = false;
        do {
            if (chosenOperator == '/' && number2 == 0.0) {
                System.out.println("Cannot divide by 0, please enter a different number: ");
                number2 = getDouble(sc, "second");
            } else {
                isDividingByZero = true;
            }
        } while (isDividingByZero != true);

        // Perform arithmetic
        double result = 0.0;
        switch (chosenOperator) {
            case '+': {
                result = number1 + number2;
                break;
            }
            case '-': {
                result = number1 - number2;
                break;
            }
            case '*': {
                result = number1 * number2;
                break;
            }
            case '/': {
                result = number1 / number2;
                break;
            }
            default: {
                result = number1 + number2;
                break;
            }
        }

        // Display result
        System.out.println("\n" + number1 + " " + chosenOperator + " " + number2 + " = " + result);

        // Close scanner
        sc.close();
    }

    /**
     * Helper function to get a number (Double) input
     * 
     * @param sc            Scanner object
     * @param iterationText Word to denote which number the user should input
     * @return Double
     */
    public static Double getDouble(Scanner sc, String iterationText) {
        Double number = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print("Enter " + iterationText + " number: ");
                number = sc.nextDouble();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid number, please try again:\n");
                isValid = false;
                sc.next();
            }
        } while (isValid != true);

        return number;
    }
}
