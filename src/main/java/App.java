package edu.curtin.app;

import java.util.Scanner;
import java.util.logging.Logger;

/* Prints the main menu. Prompts user to enter file name to read and display the
*  maze to the user
*/

public class App {

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws CustomException {
        LOG.info(() -> "Printing main menu ");

        /* Main Menu */
        System.out.println("\n\033[32m------------------------------\033[m\n");
        System.out.println("\t\033[32mWelcome!!\033[m");
        System.out.println("\n\033[32m------------------------------\033[m\n");
        System.out.println("\t\033[31mMAZE GAME!!\033[m");
        System.out.println("\n\033[31m******************************\033[m\n\n");

        /* Read file class is called */
        Read read = new Read();

        LOG.info(() -> "Main function. Prompt user to enter file name");

        /* Prompts user to enter file name */
        try (Scanner in = new Scanner(System.in);) {

            System.out.println("Enter file name");

            String fName = in.nextLine();

            /* Entered file is read */
            read.readFile(fName);

        } catch (CustomException ee) /* Custom Exception caught to handle all internal errors */
        {
            LOG.warning(() -> "Error:\n\t" + ee);
        }

    }

}
