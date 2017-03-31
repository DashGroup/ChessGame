public class InvalidMoveException extends Exception 
{
    InvalidMoveException(String string){
        super("Sorry " + string + " is not a valid movement");
    }
}
