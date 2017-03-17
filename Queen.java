public class Queen extends Pieces
{ 
    public boolean followsBasicRules(int[] command){
        boolean check = false;
        return check;
    }
    public boolean followsExceptionalRules(int[] command){
        return true;
    }

    public void setProperty(String input,String name,Pieces piece,String color){
        position=convertor(input);
        this.name=name;
        Board.getBoard()[position[0]][position[1]]=piece;
        this.color=color;
    }
}
