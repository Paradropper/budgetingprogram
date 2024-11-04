import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class codevariableswitching {

    public static void main(String[] args){
    Scanner commandsc = new Scanner(System.in);

    double savedInput = 0;
    String command = "";
    
        System.out.print("enter a command: ");
        command = commandsc.nextLine();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (command.equals("varchange")) {
            Scanner in2 = new Scanner(System.in);
            System.out.print("Enter variable to define: ");
            String variable = in2.nextLine();
            String location = "storedvariables2/"+variable+".txt";

            File file = new File(location);
            if (file.exists()) {
                // Notify the user that the file already exists
                System.out.println("The file \"" + location + "\" already exists.");
                System.out.print("Do you want to overwrite it? (yes/no): ");
                String response = in2.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    System.out.println("Operation canceled. No changes made.");
                    return; // Exit if the user does not want to overwrite
                } 
            } else {
                System.out.println("Creating new file...");
            }
    
            try (PrintWriter out = new PrintWriter(new FileWriter(location))) { 
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter your input: ");
                    if (in.hasNextDouble()) {
                        savedInput = in.nextDouble();
                        out.println(savedInput);
                        System.out.println("Input saved to file, \"PHP " + String.format("%.2f",savedInput) + "\"");
                        break; 
                    } else {
                        System.out.println("Invalid input. Please enter a valid double.");
                        in.next(); 
                    }
                }
            } catch (IOException e) {
                System.err.println("Error saving input to file.");
            }
        } else {
            //insert error here
        }
        
        }
}
