public abstract class Pieces 
{
    protected String name;
    protected int[] position= new int[2];
    protected String color;
    protected boolean ifMove;
    protected int movementNumCount;
    protected int stayTurn;
    public abstract boolean followsBasicRules(int[] command);
    public abstract boolean followsExceptionalRules(int[] command);
    public void setStayTurn(){
        stayTurn++;
    }
    public boolean isAllowedToMove(int[] command){
        boolean check=false;
        if(followsBasicRules(command))
            check=true;
        else if(followsExceptionalRules(command))
            check = true;      
        if(check==true){
            movementNumCount++;
            stayTurn=1;
        }
        return check;
    }
    public void setPosition(int first, int second){
         position[0] = first;
         position[1] = second;
    }
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
