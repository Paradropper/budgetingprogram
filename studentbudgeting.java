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

        
        Scanner commands = new Scanner(System.in);
        String command = "";
        double savedInput = 0;
        System.out.println("");
        System.out.println("Available variables are: \"principal\", \"income\", \"totalsavings\", \"totalexpenses\"");
do{
        System.out.print("enter the variable to redefine: ");
        command = commands.nextLine(); 

        switch(command) {

            case "principal":
                        String principal = "";
                try (Scanner in = new Scanner(new File("storedvariables/principal.txt"))) {
                    while (in.hasNextLine()) {
                        principal = in.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.err.println("File not found.");
                }
            System.out.println("\n");
            try (PrintWriter out = new PrintWriter(new FileWriter("storedvariables/principal.txt"))) { //change here
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("Current stored variable is: " + principal);
                    System.out.print("Enter your input: ");
                    if (in.hasNextDouble()) {
                        savedInput = in.nextDouble();
                        out.println(savedInput);
                        System.out.println("Input saved to file, \"PHP " + String.format("%.2f",savedInput) + "\"");
                        break; // exit the loop
                    } else {
                        System.out.println("Invalid input. Please enter a valid double.");
                        in.next(); // discard the invalid input
                    }
                }
            } catch (IOException e) {
                System.err.println("Error saving input to file.");
            }
            break;

            case "income":
            System.out.println("\n");
            try (PrintWriter out = new PrintWriter(new FileWriter("storedvariables/income.txt"))) { 
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
            break;

            case "totalsavings":
            System.out.println("\n");
            try (PrintWriter out = new PrintWriter(new FileWriter("storedvariables/totalsavings.txt"))) { 
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
            break;

            case "totalexpenses":
            System.out.println("\n");
            try (PrintWriter out = new PrintWriter(new FileWriter("storedvariables/totalexpenses.txt"))) { 
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.print("Enter your input: ");
                    if (in.hasNextDouble()) {
                        savedInput = in.nextDouble();
                        out.println(savedInput);
                        System.out.println("Input saved to file, \"PHP " + String.format("%.2f",savedInput) + "\"");
                        break; // exit the loop
                    } else {
                        System.out.println("Invalid input. Please enter a valid double.");
                        in.next(); // discard the invalid input
                    }
                }
            } catch (IOException e) {
                System.err.println("Error saving input to file.");
            }
            break;
            
        default:
        System.out.println("\rInvalid input, please try again.");

        case "return":
            break;

        
            
        }

        
        } while  (!command.equals("return"));
        
        return;

   
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
}

    
