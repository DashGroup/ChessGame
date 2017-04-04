public class CheckmateException extends Exception
{
    CheckmateException(String color1){
        super(color1 + " made a checkmate to the opposite group");
    }
}
