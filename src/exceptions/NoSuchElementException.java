package exceptions;

public class NoSuchElementException extends Exception {

    private static final String TREE_DOES_NOT_HAVE_SUCH_ELEMENT = "Tree does not have such element! ";
    
    public NoSuchElementException(){
        super(TREE_DOES_NOT_HAVE_SUCH_ELEMENT);
    }
}
