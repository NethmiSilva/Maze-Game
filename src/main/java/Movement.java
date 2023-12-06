package edu.curtin.app;

/*Interface to implement Decorator pattern */
public interface Movement {

    boolean move(char[][] array, int row, int col) throws CustomException;

}
