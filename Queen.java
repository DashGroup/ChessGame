public class Queen extends Pieces
{ 
    public boolean rules(int[] command){
        return true;
    }
    public boolean exceptionalRules(int[] command){
        return true;
    }
    public boolean ifAllowedToMove(int[] command){
        boolean check = false;
        if(check == true){movementNumCount++;}
        return true;
    }
    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
