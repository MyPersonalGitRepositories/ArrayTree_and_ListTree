package exceptions;

public class SecurityException extends Exception {

    private static final String WRONG_INDEX = "Problem with index of element";

    public SecurityException(){
        super(WRONG_INDEX);
    }
}
