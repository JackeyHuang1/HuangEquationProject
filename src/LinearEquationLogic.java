import java.util.Scanner;

public class LinearEquationLogic {

    private LinearEquation coords;
    private Scanner scan;
    private boolean running;
    private boolean dupe;

    public LinearEquationLogic() {
        coords = null;
        scan = new Scanner(System.in);
        running = true;
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (running) {
            run();
            restart();
        }
    }

    private void run() {
        System.out.print("Enter Coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter Coordinate 2: ");
        String coord2 = scan.nextLine();
        int x_1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(",")));
        int y_1 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 2, coord1.length() - 1));
        int x_2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(",")));
        int y_2 = Integer.parseInt(coord2.substring(coord2.indexOf(",") + 2, coord2.length() - 1));
        while (x_1 == x_2) {
            System.out.print("Your X coordinates cannot be the same. Please enter a new x value for the second one. (Eg: Enter in 1 rather than (1, 10))");
            x_2 = scan.nextInt();
            dupe = true;
            }
        coords = new LinearEquation(x_1, y_1, x_2, y_2);
        System.out.println(coords.lineInfo());
        if (dupe != true) {
            System.out.print("Enter an x-value: ");
            double x_value = scan.nextDouble();
            System.out.println(coords.coordinateForX(x_value));
        }
        scan.nextLine();
    }

    private void restart() {
        String answer;
        boolean loop = true;
        while (loop) {
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            answer = scan.nextLine();
            if (answer.equals("y")) {
                running = true;
                loop = false;
            } else if (answer.equals("n")) {
                running = false;
                loop = false;
                dupe = false;
                System.out.println("Thank you for using the slope calculator, goodbye!");
            } else {
                System.out.println("Invalid option, try again!");
            }
        }
    }
}