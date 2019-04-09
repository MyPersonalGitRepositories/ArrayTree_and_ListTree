package exceptions;

public class IllegalArgumentException extends Exception {

    private static final String AN_ELEMENT_IN_THIS_PLACE = "The element is already present";

    public IllegalArgumentException(){
        super(AN_ELEMENT_IN_THIS_PLACE);
    }
}
