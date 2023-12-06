package edu.curtin.app;

/*New Exception is created */
public class CustomException extends Exception {

    /* Constructor one */
    public CustomException(String msg) {
        super(msg);
    }

    /* Constructor two */
    public CustomException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
