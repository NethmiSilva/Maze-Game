package edu.curtin.app;

import java.util.logging.Logger;

/*Clears the terminal */
public class Clear {

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Clear.class.getName());

    /* Function to clear the terminal */
    public void clearScreen() {
        LOG.info(() -> "Clearing console");
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

}
