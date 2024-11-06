import java.util.Scanner;

public class compoundcommands {

    public static String[] splitCommand(String commandString) {
        String[] parts = commandString.split(" ", 2);

        if (parts.length == 1) {
            parts = new String[] {parts[0], ""};
        }
        return parts;
        }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a 2-part command: ");
        String command = in.nextLine();
        String[] parts = command.split(" ");

        String part1 = parts[0];
        String part2 = parts[1];

        System.out.print("part 1 is: " + part1 + "\npart 2 is: " + part2);

    }
}