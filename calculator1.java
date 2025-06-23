import java.util.Scanner;

public class calculator1 {

    public void runCalculator() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the first number:");
            int x = sc.nextInt();

            System.out.println("Enter the second number:");
            int y = sc.nextInt();

            System.out.println("Please select operator:");
            System.out.println("a = addition, s = subtraction, m = multiplication, d = division");

            String operator = sc.next();

            switch (operator) {
                case "a":
                    System.out.println("Result: " + add(x, y));
                    break;
                case "s":
                    System.out.println("Result: " + sub(x, y));
                    break;
                case "m":
                    System.out.println("Result: " + mul(x, y));
                    break;
                case "d":
                    if (y != 0) {
                        System.out.println("Result: " + div(x, y));
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;
                default:
                    System.out.println("Wrong input given.");
            }

            System.out.println("\nDo you want another calculation? (yes/no):");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Calculator exited.");
                break;
            }

            System.out.println(); // spacing
        }

        sc.close();
    }

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public static void main(String[] args) {
        calculator1 calculator = new calculator1();
        calculator.runCalculator();
    }
}
