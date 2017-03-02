public abstract class Pieces
{
    protected String position;
    protected boolean alive;
    protected boolean ifMove;
    protected int numCount;
    public abstract boolean rules();
    public abstract boolean specialRules();
    public abstract boolean checkRules();
    public abstract void setPosition(String str);
    public boolean ifAlive(){return true;}
}
