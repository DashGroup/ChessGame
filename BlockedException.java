public class BlockedException extends Exception
{
    BlockedException(){
        super("Blocked by own pieces, cannot move");
    }
}
