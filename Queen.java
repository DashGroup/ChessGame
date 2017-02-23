public class Queen extends Chesspieces
{
    private String[] name;
    private String[] position;
    private boolean[] alive;
    private boolean[] ifMove;
    private int numCount;
    public boolean rules(){
        return true;
    }
    public boolean specialRules(){
        return true;
    }
    public boolean ifAlive(){
        return true;
    }
}
