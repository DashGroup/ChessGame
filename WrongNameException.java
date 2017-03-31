public class WrongNameException extends Exception
{
    WrongNameException(String string){
        super("Sorry " + string + " is not a correct name");
    }
}
