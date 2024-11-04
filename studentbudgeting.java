import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class studentbudgeting {
    public static void main(String[] args) {
        
        Scanner mainsc = new Scanner(System.in);
        int option = 0;
        
        do {
        System.out.println("Enter your preference: ");
        System.out.println("Type \"1\" for Variable Changing ");
        System.out.println("Press \"2\" to quit ");
        System.out.println("Press \"3\" for overview ");
        
        System.out.print("Select an option: ");
        option  = mainsc.nextInt();

        switch (option) {
            case 1:
            input();
            break;

            case 2:
            System.out.println("Terminating Program...");
            System.exit(0);
            break;

            case 3:
            overview();
            break;

            default:
            System.out.println("Invalid option, please try again.");
        }

        
        } while (option != 2);
    }


////////////////////////////////////////////////////////////////////////////

static void overview() {

    System.out.println("Here is the overview of your current budget.");

    String income = "";
    try (Scanner in = new Scanner(new File("storedvariables/income.txt"))) {
        while (in.hasNextLine()) {
            income = in.nextLine();
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found.");
    }
    
    System.out.println("Current Income: PHP " + income + "0"); //income message

    String totalexpenses = "";
    try (Scanner in = new Scanner(new File("storedvariables/income.txt"))) {
        while (in.hasNextLine()) {
            totalexpenses = in.nextLine();
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found.");
    }
    System.out.println("Current Expenses: PHP " + totalexpenses + "0"); //totalexpenses message

    String totalsavings = "";
    try (Scanner in = new Scanner(new File("storedvariables/totalsavings.txt"))) {
        while (in.hasNextLine()) {
            totalsavings = in.nextLine();
        }
    } catch (FileNotFoundException e) {
        System.err.println("File not found.");
    }
    System.out.println("Current Expenses: PHP " + totalsavings + "0"); //totalsavings message




System.out.println("");
    return;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    static void input () {
        
        Scanner commandsc = new Scanner(System.in);

        double savedInput = 0;
        String command = "";

        

        
        
    do {    
        System.out.print("enter a command: ");
        command = commandsc.nextLine();

        if (command.equals("list")) { 
            String directoryPath = "storedvariables";
            File directory = new File(directoryPath);

            if (directory.exists() && directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null && files.length > 0) {
                    System.out.println("Defined variables in the \"" + directoryPath + "\" folder:");
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".txt")) {
                            // Extract the variable name by removing the .txt extension
                            String variableName = file.getName().substring(0, file.getName().length() - 4);
                            System.out.println(variableName);
                        }
                    }
            } else {
                System.out.println("No defined variables found in the \"" + directoryPath + "\" folder.");
            }
        } else {
            System.out.println("Directory \"" + directoryPath + "\" does not exist.");
        }
    } else if (command.equals("varchange")){


        Scanner in2 = new Scanner(System.in);
        System.out.print("Enter variable to define: ");
        String variable = in2.nextLine();
        String location = "storedvariables/"+variable+".txt";

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
    } else if (command.equals("return")) {
        System.out.println("returning");
    } else{
        System.err.println("unknown command.");
    }
} while (!command.equals("return"));
        
        return;
        }
   
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//     static void output () {

//       if(command.equals("stored")) {
//         try (Scanner in = new Scanner(new File("input.txt"))) {
//             while (in.hasNextLine()) {
//                 savedInput = in.nextLine();
//             }
//             System.out.println("The saved input is: " + savedInput);
//         } catch (FileNotFoundException e) {
//             System.err.println("File not found.");
//         }
//     }
// }


//end


    
