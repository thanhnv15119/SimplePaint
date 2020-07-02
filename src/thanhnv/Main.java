package thanhnv;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = "";
        DrawUtils drawer = new DrawUtils();
        do {
            try {
                System.out.print("enter command: ");
                command = sc.nextLine();

                String[] commands = command.split("\\s");
                command = commands[0];

                switch (command.charAt(0)) {
                    case 'C':
                        System.out.println("Draw Cavas");
                        drawer.drawCanvas(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                        break;
                    case 'L':
                        System.out.println("Draw Line");
                        drawer.drawLine(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]), 'x');
                        break;
                    case 'R':
                        System.out.println("Draw Rectangle");
                        drawer.drawRectangle(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), Integer.parseInt(commands[3]), Integer.parseInt(commands[4]), 'x');
                        break;
                    case 'B':
                        System.out.println("Bucket Fill");
                        drawer.bucketFill(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), commands[3].charAt(0));
                        break;
                    case 'Q':
                        System.out.println("Bye");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please try again use commands C L B Q");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error Syntax");
            }
        } while (!command.equals("q"));
    }
}
