public abstract class Pieces 
{
    protected String name;
    protected int[] position= new int[2];
    protected String color;
    protected boolean alive;
    protected boolean ifMove;
    protected int numCount;
    public abstract boolean rules(int[] command);
    public abstract boolean specialRules(int[] command);
    public abstract boolean ifAllowedToMove(int[] command);
    public boolean ifAlive(){return true;}
    public int[] convertor(String position){
        int[] arr = new int[2];
        int first = position.charAt(0);
        if(first>=65&&first<=72)
        first = first-65;
        else if(first>=97&&first<=104)
        first = first-97;
        int second = 8-Integer.valueOf(position.substring(1,2));
        arr[0] = second;
        arr[1] = first;
        return arr;
    }

}
