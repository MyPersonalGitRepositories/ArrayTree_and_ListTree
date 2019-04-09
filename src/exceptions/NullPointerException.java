package exceptions;

public class NullPointerException extends Exception {

    private static final String NULL_ADDING = "Can not add \"null\" element";

    public NullPointerException(){
        super(NULL_ADDING);
    }
}
