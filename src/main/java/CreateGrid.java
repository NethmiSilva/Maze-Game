package edu.curtin.app;

/*Abstract class to implement Template method */
public abstract class CreateGrid {

    /* Hook method */
    protected abstract void assignCharacters(char[][] array, int row, int col) throws CustomException;

    /* Template method */
    public void makeMaze(char[][] array, int row, int col) throws CustomException {
        assignCharacters(array, row, col);
    }

}
